package com.taotao.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.ImageService;
@Service
public class ImageServiceImpl implements ImageService {

	@Value("${Ftp_host}")
	private String Ftp_host;
	
	@Value("${Ftp_port}")
	private int Ftp_port;
	
	@Value("${Ftp_username}")
	private String Ftp_username;
	
	@Value("${Ftp_password}")
	private String Ftp_password;

	@Value("${Ftp_basePath}")
	private String Ftp_basePath;
	
	@Value("${Ftp_image_url}")
	private String Ftp_image_url;
	
	
	
	
	@Override
	public Map uploadImage(MultipartFile uploadImage) {
		Map resulMap=new HashMap<>();
		//获取扩展名
		String uploadname = uploadImage.getOriginalFilename();
		String ext=uploadname.substring(uploadname.lastIndexOf("."));
		//新文件名
		String newImageName=IDUtils.genImageName()+ext;
		//文件路径
		String dTime=new DateTime().toString("/yyyy/MM/dd");
		
		System.out.println(Ftp_image_url+dTime+"/"+newImageName);
		try {
		Boolean bool=	FtpUtil.uploadFile(Ftp_host, Ftp_port, Ftp_username, Ftp_password, Ftp_basePath, dTime, newImageName, uploadImage.getInputStream());
		if(!bool){
			resulMap.put("error", 1);
			resulMap.put("message", "图片上传失败");
		}
		resulMap.put("error", 0);
		resulMap.put("url", Ftp_image_url+dTime+"/"+newImageName);
		
		
		} catch (IOException e) {
			resulMap.put("error", 1);
			resulMap.put("message", "图片上传异常");
		}
		return resulMap;
	}

}
