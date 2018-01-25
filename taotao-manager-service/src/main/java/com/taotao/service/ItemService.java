package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.po.TbItem;

/**
 * 商品接口
 * @author Administrator
 *
 */
public interface ItemService {

	/**
	 * 根据id查询商品
	 * @param itemId
	 * @return
	 */
	public TbItem getItemById(Long itemId);
	
	/**
	 * 分页查询商品列表
	 * <p>Title: findListByPageHelper</p>  
	 * <p>Description: </p>  
	 * @param page
	 * @param rows
	 * @return
	 */
	EUDataGridResult findListByPageHelper(int page,int rows);
	/**
	 * 保存商品
	 * <p>Title: saveItem</p>  
	 * <p>Description: </p>  
	 * @param item
	 * @return
	 */
	TaotaoResult saveItem(TbItem item,String desc,String itemParams)throws Exception;

	 //TaotaoResult saveItem(TbItem item, String desc);
}
