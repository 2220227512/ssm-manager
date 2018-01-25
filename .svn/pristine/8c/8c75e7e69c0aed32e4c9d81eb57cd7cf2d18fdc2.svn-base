package com.taotao.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.po.TbItem;
import com.taotao.po.TbItemExample;

public class TestPageHelper {

	private TbItemMapper getmapper() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	    return (TbItemMapper)applicationContext.getBean(TbItemMapper.class);
	}
	@Test
	public void testPage(){
		TbItemMapper itemMapper=getmapper();
	
		TbItemExample example =new TbItemExample();
		PageHelper.startPage(1, 10);
	    List<TbItem> items = itemMapper.selectByExample(example);
	    System.out.println(items.size());
	    for (TbItem item : items) {
	    	
			System.out.println("1):"+item.getTitle());
		}
	    
	    PageInfo<TbItem> info=new PageInfo<>(items);
	    System.out.println("总数："+info.getTotal());
		
	}

	
	
}
