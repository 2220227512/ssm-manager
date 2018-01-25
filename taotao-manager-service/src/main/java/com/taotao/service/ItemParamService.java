package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;


/**
 * 商品规格模板
* <p>Title: ItemParamService</p>  
* <p>Description: </p>  
* @author 唯  
* @date 2018-1-4
 */
public interface ItemParamService {

	/**
	 * 根据商品id查询模板是否存在
	 * <p>Title: getItemParamByCid</p>  
	 * <p>Description: </p>  
	 * @param itemcid
	 * @return
	 */
	TaotaoResult getItemParamByCid(Long itemcid);
	
	/**
	 * 插入一条数据
	 * <p>Title: insertItemParam</p>  
	 * <p>Description: </p>  
	 * @param cid
	 * @return
	 */
	TaotaoResult insertItemParam(Long cid ,String paramData);
}
