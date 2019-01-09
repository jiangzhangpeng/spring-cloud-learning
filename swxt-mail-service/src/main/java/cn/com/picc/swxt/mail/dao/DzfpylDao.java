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

import cn.com.picc.swxt.mail.bean.DzfpylBean;

@Repository
public class DzfpylDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final String SQL = "select kpdwdm, kpdwmc, jqbh, total, surplus, userate, cpname from t_maw_skrisk_dzfpyl ";

	public List<DzfpylBean> findAll() {
		return jdbcTemplate.query(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			}
		}, new RowMapper<DzfpylBean>() {
			@Override
			public DzfpylBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				DzfpylBean bean = new DzfpylBean();
				bean.setCpname(rs.getString("cpname"));
				bean.setJqbh(rs.getString("jqbh"));
				bean.setKpdwdm(rs.getString("kpdwdm"));
				bean.setKpdwmc(rs.getString("kpdwmc"));
				bean.setSurplus(rs.getInt("surplus"));
				bean.setTotal(rs.getInt("total"));
				bean.setUserate(rs.getDouble("userate"));
				return bean;
			}
		});
	}

}
