package kr.ac.hansung.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class RecommandInfoDAO {

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<RecommandInfo> getTotalRecommand() {
		String sqlStatement = "select member, book_type, notify_type, phone_num, email from recommand_book";
		return jdbcTemplateObject.query(sqlStatement, new RowMapper<RecommandInfo>() {

			public RecommandInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

				RecommandInfo recommandInfo = new RecommandInfo();

				recommandInfo.setName(rs.getString("member"));
				recommandInfo.setBook_type(rs.getInt("book_type"));
				recommandInfo.setNotify_type(rs.getInt("notify_type"));
				recommandInfo.setPhone_num(rs.getString("phone_num"));
				recommandInfo.setEmail(rs.getString("email"));

				return recommandInfo;
			}

		});

	}

	public boolean insert(RecommandInfo recommandInfo) {

		int book_type = recommandInfo.getBook_type();
		int notify_type = recommandInfo.getNotify_type();
		String phone_num = recommandInfo.getPhone_num();
		String email = recommandInfo.getEmail();
		String member = recommandInfo.getName();

		String sqlStatement = String.format(
				"insert into recommand_book ( member, book_type, notify_type, phone_num, email) values(\"%s\",%d,%d,\"%s\", \"%s\")",
				member, book_type, notify_type, phone_num, email);

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