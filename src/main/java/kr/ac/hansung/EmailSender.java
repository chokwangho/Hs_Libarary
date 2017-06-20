package kr.ac.hansung;

import java.util.List;

import org.apache.commons.mail.SimpleEmail;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.ac.hansung.jdbc.RecommandInfo;
import kr.ac.hansung.jdbc.RecommandInfoDAO;

public class EmailSender {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/ac/hansung/beans/beans.xml");
	RecommandInfoDAO recommandInfoDAO = (RecommandInfoDAO) context.getBean("RecommandInfoDAO");
	List<RecommandInfo> recommandInfos;
	SimpleEmail mail;

	// �Ϲ� �ؽ�Ʈ ������ ������ �޼ҵ�
	public void sendMail(String book_type, String book_title) {
		// �Ϲ� �ؽ�Ʈ ������ ���� �� �ִ� ��ü ����
		// ���� ������ ��������

		try {
			// �޴� ��� �� ����
			recommandInfos = recommandInfoDAO.getTotalRecommand();

			for (RecommandInfo recommandInfo : recommandInfos) {
				mail = new SimpleEmail();

				mail.setHostName("smtp.naver.com");
				mail.setSmtpPort(587);
				mail.setAuthentication("smgr8178@naver.com", "dbfgjsdl2");

				// ���� ���� ����
				mail.setSSL(true);
				mail.setTLS(true);

				// ���� ������ ���ڵ� ����
				mail.setCharset("utf-8");

				String str;
				System.out.println(recommandInfo.getName());
				if (recommandInfo.getNotify_type() == 2 || recommandInfo.getNotify_type() == 3) {
					if (book_type.equals("IT")) {
						if (!(recommandInfo.getBook_type() == 1 || recommandInfo.getBook_type() == 3
								|| recommandInfo.getBook_type() == 5 || recommandInfo.getBook_type() == 7))
							continue;
					} else if (book_type.equals("����")) {
						if (!(recommandInfo.getBook_type() == 2 || recommandInfo.getBook_type() == 3
								|| recommandInfo.getBook_type() == 6 || recommandInfo.getBook_type() == 7))
							continue;
					} else if (book_type.equals("����")) {
						if (!(recommandInfo.getBook_type() == 4 || recommandInfo.getBook_type() == 5
								|| recommandInfo.getBook_type() == 6 || recommandInfo.getBook_type() == 7))
							continue;
					}

					switch (recommandInfo.getBook_type()) {
					case 1:
						str = "IT";
						break;
					case 2:
						str = "����";
						break;
					case 3:
						str = "IT/����";
						break;
					case 4:
						str = "����";
						break;
					case 5:
						str = "IT/����";
						break;
					case 6:
						str = "����/����";
						break;
					case 7:
						str = "IT/����/����";
						break;
					default:
						str = "���þ���";
						break;
					}

					// �޴»�� ����
					mail.addTo(recommandInfo.getEmail().trim(), recommandInfo.getName().trim(), "utf-8");
					// ������ ��� ����
					mail.setFrom("smgr8178@naver.com", "������", "utf-8");
					// ������
					mail.setSubject("�Ѽ����б� ������ �Ű� ���� �˸�");
					// ���� ����
					mail.setMsg("�Ѽ����б� �������Դϴ�. \n" + recommandInfo.getName().trim() + "�Բ��� ��û�Ͻ� " + str + "�о��� "
							+ book_title
							+ " å�� �߰��Ǿ����ϴ�.\n�ڼ��� ������ �Ʒ� �Ѽ����б� ������ Ȩ������ ��ũ�� Ȯ�����ּ���.\nhttp://yulheon.iptime.org:8080/Hansung_Libary/");
					// ���� ������
					mail.send();

					System.out.println(recommandInfo.getEmail().trim() + "�߼ۿϷ�");
				}
			}
		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
