package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.po.TbContent;

/**
 * 内容管理接口
* <p>Title: ContentService</p>  
* <p>Description: </p>  
* @author 唯  
* @date 2018-1-8
 */
public interface ContentService {

	/**
	 * 添加
	 * <p>Title: insertContent</p>  
	 * <p>Description: </p>  
	 * @param content
	 * @return
	 */
	TaotaoResult insertContent(TbContent content) ;
}
