package com.yiya.mapper;

import com.yiya.bean.TabArea;
import com.yiya.bean.TabAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabAreaMapper {
    int countByExample(TabAreaExample example);

    int deleteByExample(TabAreaExample example);

    int deleteByPrimaryKey(Integer area_id);

    int insert(TabArea record);

    int insertSelective(TabArea record);

    List<TabArea> selectByExample(TabAreaExample example);

    TabArea selectByPrimaryKey(Integer area_id);

    int updateByExampleSelective(@Param("record") TabArea record, @Param("example") TabAreaExample example);

    int updateByExample(@Param("record") TabArea record, @Param("example") TabAreaExample example);

    int updateByPrimaryKeySelective(TabArea record);

    int updateByPrimaryKey(TabArea record);
}