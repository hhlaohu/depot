package com.yiya.mapper;

import com.yiya.bean.TabFreeInOutList;
import com.yiya.bean.TabFreeInOutListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabFreeInOutListMapper {
    int countByExample(TabFreeInOutListExample example);

    int deleteByExample(TabFreeInOutListExample example);

    int deleteByPrimaryKey(Integer free_in_out_id);

    int insert(TabFreeInOutList record);

    int insertSelective(TabFreeInOutList record);

    List<TabFreeInOutList> selectByExample(TabFreeInOutListExample example);

    TabFreeInOutList selectByPrimaryKey(Integer free_in_out_id);

    int updateByExampleSelective(@Param("record") TabFreeInOutList record, @Param("example") TabFreeInOutListExample example);

    int updateByExample(@Param("record") TabFreeInOutList record, @Param("example") TabFreeInOutListExample example);

    int updateByPrimaryKeySelective(TabFreeInOutList record);

    int updateByPrimaryKey(TabFreeInOutList record);
}