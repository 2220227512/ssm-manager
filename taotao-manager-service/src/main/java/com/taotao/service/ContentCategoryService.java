package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.pojo.TreeNode;

/**
 * 内容分类接口
* <p>Title: ContentCategoryService</p>  
* <p>Description: </p>  
* @author 唯  
* @date 2018-1-7
 */
public interface ContentCategoryService {

	/**
	 * 查看全部
	 * <p>Title: getCategoryList</p>  
	 * <p>Description: </p>  
	 * @param parentId
	 * @return
	 */
	public List<TreeNode> getCategoryList(long parentId) ;
	/**
	 * 添加
	 * <p>Title: instertCategory</p>  
	 * <p>Description: </p>  
	 * @param parentId
	 * @param name
	 * @return
	 */
	TaotaoResult instertCategory(long parentId,String name);
	
	/**
	 * 删除
	 * <p>Title: deleteCategory</p>  
	 * <p>Description: </p>  
	 * @param id
	 * @param parentId
	 * @return
	 */
	TaotaoResult deleteCategory(long id,long parentId);
	/**
	 * 更新 重命名
	 * <p>Title: updateCatgory</p>  
	 * <p>Description: </p>  
	 * @param id
	 * @param name
	 * @return
	 */
	TaotaoResult updateCatgory(long id,String name);
	
	
}
