package com.yiya.service.impl;

import com.yiya.api.bean.TabOnhandVehicleDTO;
import com.yiya.api.service.TabOnhandVehicleService;
import com.yiya.bean.TabOnhandVehicle;
import com.yiya.mapper.TabOnhandVehicleMapper;
import com.yiya.util.CopyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by laohu on 2018/5/23.
 */

@Service("tabOnhandVehicleService")
public class TabOnhandVehicleServiceImpl implements TabOnhandVehicleService {

    @Autowired
    TabOnhandVehicleMapper tabOnhandVehicleMapper;

    @Override
    public TabOnhandVehicleDTO findById(Long id) {
        TabOnhandVehicle tabOnhandVehicle = tabOnhandVehicleMapper.selectByPrimaryKey(id);
        TabOnhandVehicleDTO tabOnhandVehicleDTO = new TabOnhandVehicleDTO();
        CopyProperties.copyPropertysWithoutNull(tabOnhandVehicleDTO, tabOnhandVehicle);
        return tabOnhandVehicleDTO;
    }
}
