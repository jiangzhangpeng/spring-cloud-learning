package cn.com.picc.swxt.mail.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.com.picc.swxt.mail.bean.SysCommonPropertyBean;

@Repository
public class SysCommonPropertyDao {
	private static final String SQL = "update t_sys_common_property set propertyvalue = ? where propertyname = ? ";
	private static final String SQL_SWITCH = "select propertyname, propertyvalue, propertyremark from t_sys_common_property where propertyname = ? ";
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

	public List<SysCommonPropertyBean> getPropertyByProName(String proName) {
		return jdbcTemplate.query(SQL_SWITCH, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, proName);

			}
		}, new RowMapper<SysCommonPropertyBean>() {

			@Override
			public SysCommonPropertyBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				SysCommonPropertyBean bean = new SysCommonPropertyBean();
				bean.setPropertyName(rs.getString("propertyname"));
				bean.setPropertyValue(rs.getString("propertyvalue"));
				bean.setPropertyRemark(rs.getString("propertyremark"));
				return bean;
			}
		});
	}
}
