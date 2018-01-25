package com.taotao.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.mapper.TbContentMapper;
import com.taotao.po.TbContent;
import com.taotao.service.ContentService;
@Service
public class ContentServiceImpl implements ContentService {

	@Value("{REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("{REST_INDEX_AD_SYN_URL}")
	private String REST_INDEX_AD_SYN_URL;
	
	@Autowired
	private TbContentMapper contentMapper;
	@Override
	public TaotaoResult insertContent(TbContent content) {
		
		//缓存同步
		try {
			Long cid=content.getCategoryId();
			HttpClientUtil.doGet(REST_BASE_URL+REST_INDEX_AD_SYN_URL+cid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		content.setUpdated(new Date());
		content.setCreated(new Date());
		if(content.getPic()==null){
			content.setPic("http://192.168.190.128/2018/01/03/1514979137315598.jpg");
		}
       if(content.getPic2()==null){
    	   content.setPic2("http://192.168.190.128/2018/01/03/1514979137315598.jpg");
		}
		contentMapper.insert(content);
		return TaotaoResult.ok();
	}

}
