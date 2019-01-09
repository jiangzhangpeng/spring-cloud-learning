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

import cn.com.picc.swxt.mail.bean.DzfpylMailAddressBean;

@Repository
public class DzfpylMailAddressDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final String SQL = "select nsrsbh, nsrsmc, fplxmc, mailaddress from t_maw_mailaddress_pl ";

	public List<DzfpylMailAddressBean> findAll() {
		return jdbcTemplate.query(SQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			}
		}, new RowMapper<DzfpylMailAddressBean>() {
			@Override
			public DzfpylMailAddressBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				DzfpylMailAddressBean bean = new DzfpylMailAddressBean();
				bean.setFplxmc(rs.getString("fplxmc"));
				bean.setNsrsbh(rs.getString("nsrsbh"));
				bean.setNsrsmc(rs.getString("nsrsmc"));
				bean.setMailaddress(rs.getString("mailaddress"));
				return bean;
			}
		});
	}

}
