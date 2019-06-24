package cn.com.clumsybear.multidb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.com.clumsybear.multidb.model.Demo;

@Mapper
public interface DemoMapper {

	/**
	 * 测试查询方法
	 * 
	 * @return
	 */
	@Select({ "select id, name, json from swxt_test" })
	List<Demo> selectDemo();

	/**
	 * 根据id查询测试Demo
	 * 
	 * @param id
	 * @return
	 */
	@Select({ "select id, name, json from swxt_test where id = #{id,jdbcType=VARCHAR}" })
	Demo selectDemoById(String id);

	/**
	 * 根据id查询测试Demo
	 * 
	 * @param id
	 * @return
	 */
	@Update({
			"update swxt_test set name=#{name,jdbcType=VARCHAR} where id = #{id,jdbcType=VARCHAR}" })
	int updateDemoById(Demo demo);
}
