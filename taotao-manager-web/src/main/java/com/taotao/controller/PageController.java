package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
* <p>Title: PageController</p>  
* <p>Description: </p>  
* @author 唯  
* @date 2017-12-31
 */
@Controller
public class PageController {

	/**
	 * 去首页
	 * <p>Title: pageIndex</p>  
	 * <p>Description: </p>  
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex(){
		
		return "index";
	}
	
	/**
	 * 去不同页面
	 * <p>Title: showPage</p>  
	 * <p>Description: </p>  
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
