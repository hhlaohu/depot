package com.yiya.mapper;

import com.yiya.bean.TabOnhandVehicle;
import com.yiya.bean.TabOnhandVehicleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabOnhandVehicleMapper {
    int countByExample(TabOnhandVehicleExample example);

    int deleteByExample(TabOnhandVehicleExample example);

    int deleteByPrimaryKey(Long onhand_vehicle_id);

    int insert(TabOnhandVehicle record);

    int insertSelective(TabOnhandVehicle record);

    List<TabOnhandVehicle> selectByExample(TabOnhandVehicleExample example);

    TabOnhandVehicle selectByPrimaryKey(Long onhand_vehicle_id);

    int updateByExampleSelective(@Param("record") TabOnhandVehicle record, @Param("example") TabOnhandVehicleExample example);

    int updateByExample(@Param("record") TabOnhandVehicle record, @Param("example") TabOnhandVehicleExample example);

    int updateByPrimaryKeySelective(TabOnhandVehicle record);

    int updateByPrimaryKey(TabOnhandVehicle record);
}