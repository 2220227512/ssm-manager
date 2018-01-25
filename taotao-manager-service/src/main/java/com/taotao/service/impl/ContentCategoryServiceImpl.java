package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.pojo.TreeNode;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.po.TbContentCategory;
import com.taotao.po.TbContentCategoryExample;
import com.taotao.service.ContentCategoryService;
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	@Override
	public List<TreeNode> getCategoryList(long parentId) {
		TbContentCategoryExample example =new TbContentCategoryExample();
		TbContentCategoryExample.Criteria criteria=example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> lists=contentCategoryMapper.selectByExample(example);
	    List<TreeNode> tList=new ArrayList<>();
		for (TbContentCategory content : lists) {
			TreeNode tree=new TreeNode();
			tree.setId(content.getId());
			tree.setText(content.getName());
			tree.setState(content.getIsParent()?"closed":"open");
			tList.add(tree);
		}
		
		
		
		return tList;
	}
	@Override
	public TaotaoResult instertCategory(long parentId, String name) {
		TbContentCategory record =new TbContentCategory();
		record.setCreated(new Date());
		record.setUpdated(new Date());
		record.setName(name);
		record.setParentId(parentId);
		record.setSortOrder(1);
		record.setStatus(1);//'状态。可选值:1(正常),2(删除)',
		record.setIsParent(false);
		contentCategoryMapper.insert(record);
		
		TbContentCategory  contcat =contentCategoryMapper.selectByPrimaryKey(parentId);
		if(!contcat.getIsParent()){
			contcat.setIsParent(true);
			contentCategoryMapper.updateByPrimaryKey(contcat);
			
		}
		return TaotaoResult.ok(record);
	}
	@Override
	public TaotaoResult deleteCategory(long id, long parentId) {
		contentCategoryMapper.deleteByPrimaryKey(id);
		if(parentId!=0){
			deleteByparentId(parentId);
		}
		
		
		return TaotaoResult.ok();
	}
	
	/**
	 * 需要把parentid对应的记录的isparent改成false。注意：删除直接是物理删除。
	 * <p>Title: deleteByparentId</p>  
	 * <p>Description: </p>  
	 * @param parentId
	 */
	public void deleteByparentId(long parentId){
		TbContentCategoryExample example =new TbContentCategoryExample();
		TbContentCategoryExample.Criteria criteria=example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> lists=contentCategoryMapper.selectByExample(example);
		if(lists.size()>0){
			for (TbContentCategory record : lists) {
				record.setIsParent(false);
				contentCategoryMapper.updateByPrimaryKey(record);
			}
		}
		
		
	}
	@Override
	public TaotaoResult updateCatgory(long id, String name) {
		
		TbContentCategory record=contentCategoryMapper.selectByPrimaryKey(id);
		record.setName(name);
		record.setUpdated(new Date());
		contentCategoryMapper.updateByPrimaryKey(record);
		return TaotaoResult.ok();
	}

}
