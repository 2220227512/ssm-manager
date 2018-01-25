package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.TreeNode;

/**
* 商品分类接口
* <p>Title: ItemCatService</p>  
* <p>Description: </p>  
* @author 唯  
* @date 2018-1-1
*/
public interface ItemCatService {
	/**
	 * 根据父节点id查询分类菜单
	 * <p>Title: findListByParentId</p>  
	 * <p>Description: </p>  
	 * @param parentid
	 * @return
	 */
	List<TreeNode> findListByParentId(Long parentid);

}
