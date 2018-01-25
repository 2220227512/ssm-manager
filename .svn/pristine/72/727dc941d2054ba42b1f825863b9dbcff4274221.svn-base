package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.po.TbItemParam;
import com.taotao.po.TbItemParamExample;
import com.taotao.po.TbItemParamItemExample;
import com.taotao.service.ItemParamService;
@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	@Override
	public TaotaoResult getItemParamByCid(Long itemcid) {
		
		TbItemParamExample example =new TbItemParamExample();
		TbItemParamExample.Criteria criteria=example.createCriteria();
		criteria.andItemCatIdEqualTo(itemcid);
	    List<TbItemParam> itemparan =itemParamMapper.selectByExampleWithBLOBs(example);
	    if(itemparan.size()>0&&itemparan!=null){
	    	return TaotaoResult.ok(itemparan.get(0));
	    }
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult insertItemParam(Long cid,String paramData) {
		TbItemParam itemParam =new TbItemParam();
		itemParam.setCreated(new Date());
		
		itemParam.setUpdated(new Date());
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		itemParamMapper.insert(itemParam);
		
		return TaotaoResult.ok();
	}

}
