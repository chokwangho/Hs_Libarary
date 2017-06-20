package kr.ac.hansung.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BookInfoDAO {

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}


	public List<BookInfo> getTotalBook() {
		String sqlStatement = "select book_code, book_type, title, author, publish from book";
		return jdbcTemplateObject.query(sqlStatement, new RowMapper<BookInfo>() {

			public BookInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

				BookInfo bookInfo = new BookInfo();

				bookInfo.setBook_code(rs.getString("book_code"));
				bookInfo.setBook_type(rs.getString("book_type"));
				bookInfo.setTitle(rs.getString("title"));
				bookInfo.setAuthor(rs.getString("author"));
				bookInfo.setPublish(rs.getInt("publish"));

				return bookInfo;
			}

		});

	}

	public boolean insert(BookInfo bookInfo) {

		String book_code = bookInfo.getBook_code();
		String title = bookInfo.getTitle();
		String author = bookInfo.getAuthor();
		String book_type = bookInfo.getBook_type();
		int publish = bookInfo.getPublish();

		String sqlStatement = String.format(
				"insert into book ( book_code, book_type, title, author, publish) values(\"%s\", \"%s\", \"%s\", \"%s\", %d)",
				book_code, book_type, title, author, publish);

		return (jdbcTemplateObject.update(sqlStatement) == 1);
	}

	// public boolean delete(int bType) {
	// String sqlStatement = String.format("delete from state where bType = %d",
	// bType);
	//
	// return (jdbcTemplateObject.update(sqlStatement) == 1);
	//
	// }

}