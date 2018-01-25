package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ContentCategoryService;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	//列表查询
	@RequestMapping("/list")
	@ResponseBody
	public List<TreeNode> getContentList(@RequestParam(value="id",defaultValue="0") Long parentId){
		List<TreeNode> result =contentCategoryService.getCategoryList(parentId);
		
		return result;
	}
	
	//添加
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult createContentCategory(Long parentId, String name) {
		TaotaoResult result = contentCategoryService.instertCategory(parentId, name);
		return result;
	}
	
	//删除
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContetCategory(Long id,Long parentId){
		System.out.println(parentId+"ddddd"+id);
		TaotaoResult result =contentCategoryService.deleteCategory(id, parentId);
		return result;
	}
	
	//更新
	
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult updateContetCategory(String name,Long id){
		TaotaoResult result =contentCategoryService.updateCatgory(id, name);
		return result;
	}


}
