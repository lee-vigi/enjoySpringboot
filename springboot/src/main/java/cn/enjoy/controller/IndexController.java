package cn.enjoy.controller;

import cn.enjoy.utls.EnableMyBean;
import cn.enjoy.utls.MyBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;

@RestController
@EnableMyBean
public class IndexController {

	@Resource
	private MyBean myBean;

	@RequestMapping("/index")
	public String index() {
		//myBean.method();
		return "springboot 2.0";
	}

}
