package cn.com.clumsybear.multidb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.clumsybear.multidb.mapper.DemoMapper;
import cn.com.clumsybear.multidb.model.Demo;

@Service
public class DemoService {

	@Autowired
	private DemoMapper demoMapper;

	/**
	 * 测试查询方法
	 * 
	 * @return
	 */
	public List<Demo> selectDemo() {
		return demoMapper.selectDemo();
	}

	/**
	 * 测试查询方法
	 * 
	 * @return
	 */
	public List<Demo> getDemo() {
		return demoMapper.selectDemo();
	}

	/**
	 * 根据Demo.id查询测试Demo
	 * 
	 * @param Demo
	 * @return
	 */
	public Demo selectDemoById(Demo demo) {
		return demoMapper.selectDemoById(demo.getId());
	}

	/**
	 * 根据Demo.id查询测试Demo
	 * 
	 * @param Demo
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public int updateDemoById(Demo Demo) {
		// 获取session，可从session获取用户等信息
		return demoMapper.updateDemoById(Demo);
	}

	/**
	 * 根据id查询测试Demo
	 * 
	 * @param id
	 * @return
	 */
	public Demo selectDemoById(String id) {
		return demoMapper.selectDemoById(id);
	}

	public static void main(String[] args) {

	}

}
