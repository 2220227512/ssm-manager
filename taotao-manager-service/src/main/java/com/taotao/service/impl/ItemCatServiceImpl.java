package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.po.TbItemCat;
import com.taotao.po.TbItemCatExample;
import com.taotao.service.ItemCatService;
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	@Override
	public List<TreeNode> findListByParentId(Long parentid) {
		TbItemCatExample example =new TbItemCatExample();
		TbItemCatExample.Criteria criteria=example.createCriteria();
		criteria.andParentIdEqualTo(parentid);
		List<TbItemCat> itemcats = itemCatMapper.selectByExample(example);
		List<TreeNode> results =new ArrayList<>();
		for (TbItemCat itemcat : itemcats) {
			TreeNode result=new TreeNode(itemcat.getId(),itemcat.getName(),itemcat.getIsParent()?"closed":"open");
		     results.add(result);
		
		}
		return results;
	}

}
