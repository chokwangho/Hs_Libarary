package kr.ac.hansung.jdbc;

public class RecommandInfo {
	private int book_type = 0, notify_type = 0;
	private String phone_num = "", email = "", name = "";

	public RecommandInfo() {
	}

	public RecommandInfo(String name, int book_type, int notify_type, String phone_num, String email) {
		this.name = name;
		this.book_type = book_type;
		this.notify_type = notify_type;
		this.phone_num = phone_num;
		this.email = email;
	}

	public String getBook_type_str() {
		String str;
		switch (getBook_type()) {
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
		return str;
	}
	
	public String getNotify_type_str() {
		String str;
		switch (getNotify_type()) {
		case 1:
			str = "휴대폰";
			break;
		case 2:
			str = "이메일";
			break;
		case 3:
			str = "휴대폰/이메일";
			break;
		default:
			str = "선택없음";
			break;
		}
		return str;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBook_type() {
		return book_type;
	}

	public void setBook_type(int book_type) {
		this.book_type = book_type;
	}

	public int getNotify_type() {
		return notify_type;
	}

	public void setNotify_type(int notify_type) {
		this.notify_type = notify_type;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// @Override
	// public String toString() {
	// return String.format("%4d, %d, %s, %30s, %s, %d, %s", year, semester,
	// subject_code, subject_name, division,
	// grade, score);
	// }

}
