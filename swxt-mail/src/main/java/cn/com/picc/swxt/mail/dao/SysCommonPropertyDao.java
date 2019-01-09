package cn.com.picc.swxt.mail.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

@Repository
public class SysCommonPropertyDao {
	private static final String SQL = "update t_sys_common_property set propertyvalue = ? where propertyname = ? ";
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int updateSwitch(String proName, String proValue) {
		return jdbcTemplate.update(SQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				int k = 1;
				ps.setString(k++, proValue);
				ps.setString(k++, proName);
			}
		});
	}
}
