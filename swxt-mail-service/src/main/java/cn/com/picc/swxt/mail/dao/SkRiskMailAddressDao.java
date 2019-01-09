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

import cn.com.picc.swxt.mail.bean.SkRiskMailAddressBean;

@Repository
public class SkRiskMailAddressDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final String SQL = "select orgname, mailaddress from t_maw_mailaddress_info ";

	public List<SkRiskMailAddressBean> findAll() {
		return jdbcTemplate.query(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			}
		}, new RowMapper<SkRiskMailAddressBean>() {
			@Override
			public SkRiskMailAddressBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				SkRiskMailAddressBean bean = new SkRiskMailAddressBean();
				bean.setOrgname(rs.getString("orgname"));
				bean.setMailaddress(rs.getString("mailaddress"));
				return bean;
			}
		});
	}

}
