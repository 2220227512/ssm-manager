package com.taotao.mapper;

import com.taotao.po.Yxol;
import com.taotao.po.YxolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxolMapper {
    int countByExample(YxolExample example);

    int deleteByExample(YxolExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Yxol record);

    int insertSelective(Yxol record);

    List<Yxol> selectByExample(YxolExample example);

    Yxol selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Yxol record, @Param("example") YxolExample example);

    int updateByExample(@Param("record") Yxol record, @Param("example") YxolExample example);

    int updateByPrimaryKeySelective(Yxol record);

    int updateByPrimaryKey(Yxol record);
}