package com.taotao.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传接口
* <p>Title: ImageService</p>  
* <p>Description: </p>  
* @author 唯  
* @date 2018-1-3
 */
public interface ImageService {

	/**
	 * 图片上传
	 * <p>Title: uploadImage</p>  
	 * <p>Description: </p>  
	 * @param uploadimage
	 * @return
	 */
	Map uploadImage(MultipartFile uploadImage);
}
