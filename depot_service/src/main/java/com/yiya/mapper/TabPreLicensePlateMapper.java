package com.yiya.mapper;

import com.yiya.bean.TabPreLicensePlate;
import com.yiya.bean.TabPreLicensePlateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabPreLicensePlateMapper {
    int countByExample(TabPreLicensePlateExample example);

    int deleteByExample(TabPreLicensePlateExample example);

    int deleteByPrimaryKey(Integer pre_license_plate_id);

    int insert(TabPreLicensePlate record);

    int insertSelective(TabPreLicensePlate record);

    List<TabPreLicensePlate> selectByExample(TabPreLicensePlateExample example);

    TabPreLicensePlate selectByPrimaryKey(Integer pre_license_plate_id);

    int updateByExampleSelective(@Param("record") TabPreLicensePlate record, @Param("example") TabPreLicensePlateExample example);

    int updateByExample(@Param("record") TabPreLicensePlate record, @Param("example") TabPreLicensePlateExample example);

    int updateByPrimaryKeySelective(TabPreLicensePlate record);

    int updateByPrimaryKey(TabPreLicensePlate record);
}