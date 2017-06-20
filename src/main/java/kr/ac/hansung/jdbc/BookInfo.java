package kr.ac.hansung.jdbc;

public class BookInfo {
	private int publish;
	private String book_code, title, author, book_type;

	// 연산을 위한 변수
	private int sum;

	public BookInfo() {
	}

	public BookInfo(String book_code, String book_type, String title, String author, int publish) {
		this.publish = publish;
		this.book_type = book_type;
		this.book_code = book_code;
		this.title = title;
		this.author = author;
	}

	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}

	public int getPublish() {
		return publish;
	}

	public void setPublish(int publish) {
		this.publish = publish;
	}

	public String getBook_code() {
		return book_code;
	}

	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	// @Override
	// public String toString() {
	// return String.format("%4d, %d, %s, %30s, %s, %d, %s", year, semester,
	// subject_code, subject_name, division,
	// grade, score);
	// }

}
