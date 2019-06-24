package cn.com.clumsybear.multidb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.clumsybear.multidb.model.Demo;
import cn.com.clumsybear.multidb.service.DemoService;

@RestController
@RequestMapping("api/xx")
public class DemoController {

	@Autowired
	private DemoService demoService;

	/**
	 * 测试查询方法
	 * 
	 * @return
	 */
	@GetMapping(value = "select")
	public List<Demo> selectDemo() {
		return demoService.selectDemo();
	}

	/**
	 * 测试查询方法
	 * 
	 * @return
	 */
	@GetMapping(value = "get")
	public List<Demo> getDemo() {
		return demoService.getDemo();
	}

	@PostMapping(value = "update")
	public String updataDemo(@RequestBody Demo demo) {
		demoService.updateDemoById(demo);
		return "success";
	}

}
