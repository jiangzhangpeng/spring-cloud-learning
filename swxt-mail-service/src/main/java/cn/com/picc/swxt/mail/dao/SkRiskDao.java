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

import cn.com.picc.swxt.mail.bean.SkRiskBean;

@Repository
public class SkRiskDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final String SQL = "select runid, cpname, riskkind, riskinfo from t_maw_skrisk_info  ";

	public List<SkRiskBean> findAll() {
		return jdbcTemplate.query(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			}
		}, new RowMapper<SkRiskBean>() {
			@Override
			public SkRiskBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				SkRiskBean bean = new SkRiskBean();
				bean.setRunid(rs.getString("runid"));
				bean.setCpname(rs.getString("cpname"));
				bean.setRiskKind(rs.getString("riskkind"));
				bean.setRiskInfo(rs.getString("riskinfo"));
				return bean;
			}
		});
	}
}
