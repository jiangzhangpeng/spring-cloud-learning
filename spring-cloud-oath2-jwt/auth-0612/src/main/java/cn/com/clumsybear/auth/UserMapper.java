package cn.com.clumsybear.auth;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

	@Select({ "select id, username, password, role from swxt_test_user where username = #{username,jdbcType=VARCHAR}" })

	User findByUsername(String username);

	@Insert({ "insert into swxt_test_user (id, username, password, role ) values (#{id,jdbcType=VARCHAR}, ",
			"#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, #{role,jdbcType=VARCHAR})" })
	int save(User user);
}
