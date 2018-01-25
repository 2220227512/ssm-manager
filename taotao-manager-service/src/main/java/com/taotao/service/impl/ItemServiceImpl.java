package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.po.TbItem;
import com.taotao.po.TbItemDesc;
import com.taotao.po.TbItemExample;
import com.taotao.po.TbItemParamItem;
import com.taotao.service.ItemService;
/**
 * 商品接口实现
 * @author Lsj
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	@Override
	public TbItem getItemById(Long itemId) {
		TbItem item=itemMapper.selectByPrimaryKey(itemId);
		return item;
	}
	@Override
	public EUDataGridResult findListByPageHelper(int page, int rows) {
		TbItemExample example =new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> items = itemMapper.selectByExample(example);
		PageInfo<TbItem> info=new PageInfo<>(items);
		Long total=info.getTotal();
		
		EUDataGridResult edgr =new EUDataGridResult();
		edgr.setRows(items);
		edgr.setTotal(total);
		return edgr;
	}
	@Override
	public TaotaoResult saveItem(TbItem item,String desc,String itemParams)throws Exception {
		Long itemid =IDUtils.genItemId();
		item.setId(itemid);//设置id
		item.setStatus((byte)1);     //设置状态
		Date date=new Date();
		item.setCreated(date);
		item.setUpdated(date);
		System.out.println(item.toString());
		itemMapper.insert(item);
		TaotaoResult result =insertItemDesc(itemid,desc);
		
		if(result.getStatus()!=200){
			throw  new Exception();
		}
		result=insertItemParamItem(itemid, itemParams);
		if(result.getStatus()!=200){
			throw  new Exception();
		}
		
		return TaotaoResult.ok();
	}
	
	public TaotaoResult insertItemDesc(Long itemId,String desc){
		TbItemDesc itemdesc=new TbItemDesc();
		itemdesc.setItemId(itemId);
		itemdesc.setItemDesc(desc);
		itemdesc.setCreated(new Date());
		itemdesc.setUpdated(new Date());
		itemDescMapper.insert(itemdesc);
		return TaotaoResult.ok();
		
	}
	
	/**
	 * 保存规格参数
	 * <p>Title: insertItemParamItem</p>  
	 * <p>Description: </p>  
	 * @param itemId
	 * @param itemParams
	 * @return
	 */
	public TaotaoResult insertItemParamItem(Long itemId,String itemParams){
		TbItemParamItem ipi=new TbItemParamItem();
		ipi.setCreated(new Date());
		ipi.setUpdated(new Date());
		ipi.setItemId(itemId);
		ipi.setParamData(itemParams);
		itemParamItemMapper.insert(ipi);
		return TaotaoResult.ok();
	}
	
	

}
