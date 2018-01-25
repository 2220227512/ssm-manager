package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class FtpTest {

	@Test
	public void testftp() throws FileNotFoundException{
		FileInputStream inputStream = new FileInputStream(new File("F:\\2016-9-6 手机\\背景\\2215.jpg"));
		FtpUtil.uploadFile("192.168.190.128", 21, "ftpuser", "120021", "/home/ftpuser/ ", "/2018/01/02", "2215.jpg", inputStream);
		//FtpUtil.uploadFile("192.168.190.128", "21", "ftpuser", "120021", "/home/ftpuser/", "/2018/01/02", "2215.jpg", inputStream);
		
	}
}
