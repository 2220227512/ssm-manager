package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ItemCatService;
/**
 * 商品分类controller
* <p>Title: ItemCatController</p>  
* <p>Description: </p>  
* @author 唯  
* @date 2018-1-1
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 查询商品分类菜单
	 * <p>Title: findListByParentId</p>  
	 * <p>Description: </p>  
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<TreeNode> findListByParentId(@RequestParam(value="id",defaultValue="0") Long parentId){
		List<TreeNode> results = itemCatService.findListByParentId(parentId);
		return results;
	}
}
