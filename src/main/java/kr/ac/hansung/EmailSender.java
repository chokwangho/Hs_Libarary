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

	// 일반 텍스트 메일을 보내는 메소드
	public void sendMail(String book_type, String book_title) {
		// 일반 텍스트 메일을 보낼 수 있는 객체 생성
		// 메일 보내는 서버설정

		try {
			// 받는 사람 및 설정
			recommandInfos = recommandInfoDAO.getTotalRecommand();

			for (RecommandInfo recommandInfo : recommandInfos) {
				mail = new SimpleEmail();

				mail.setHostName("smtp.naver.com");
				mail.setSmtpPort(587);
				mail.setAuthentication("smgr8178@naver.com", "dbfgjsdl2");

				// 보안 메일 설정
				mail.setSSL(true);
				mail.setTLS(true);

				// 메일 본문의 인코딩 설정
				mail.setCharset("utf-8");

				String str;
				System.out.println(recommandInfo.getName());
				if (recommandInfo.getNotify_type() == 2 || recommandInfo.getNotify_type() == 3) {
					if (book_type.equals("IT")) {
						if (!(recommandInfo.getBook_type() == 1 || recommandInfo.getBook_type() == 3
								|| recommandInfo.getBook_type() == 5 || recommandInfo.getBook_type() == 7))
							continue;
					} else if (book_type.equals("과학")) {
						if (!(recommandInfo.getBook_type() == 2 || recommandInfo.getBook_type() == 3
								|| recommandInfo.getBook_type() == 6 || recommandInfo.getBook_type() == 7))
							continue;
					} else if (book_type.equals("역사")) {
						if (!(recommandInfo.getBook_type() == 4 || recommandInfo.getBook_type() == 5
								|| recommandInfo.getBook_type() == 6 || recommandInfo.getBook_type() == 7))
							continue;
					}

					switch (recommandInfo.getBook_type()) {
					case 1:
						str = "IT";
						break;
					case 2:
						str = "과학";
						break;
					case 3:
						str = "IT/과학";
						break;
					case 4:
						str = "역사";
						break;
					case 5:
						str = "IT/역사";
						break;
					case 6:
						str = "과학/역사";
						break;
					case 7:
						str = "IT/과학/역사";
						break;
					default:
						str = "선택없음";
						break;
					}

					// 받는사람 설정
					mail.addTo(recommandInfo.getEmail().trim(), recommandInfo.getName().trim(), "utf-8");
					// 보내는 사람 설정
					mail.setFrom("smgr8178@naver.com", "관리자", "utf-8");
					// 제목설정
					mail.setSubject("한성대학교 도서관 신간 도서 알림");
					// 내용 설정
					mail.setMsg("한성대학교 도서관입니다. \n" + recommandInfo.getName().trim() + "님께서 신청하신 " + str + "분야의 "
							+ book_title
							+ " 책이 추가되었습니다.\n자세한 내용은 아래 한성대학교 도서관 홈페이지 링크를 확인해주세요.\nhttp://yulheon.iptime.org:8080/Hansung_Libary/");
					// 메일 보내기
					mail.send();

					System.out.println(recommandInfo.getEmail().trim() + "발송완료");
				}
			}
		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
