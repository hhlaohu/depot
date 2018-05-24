package com.yiya.service.impl;

import com.yiya.annotation.BaseService;
import com.yiya.bean.TabOnhandVehicle;
import com.yiya.bean.TabOnhandVehicleExample;
import com.yiya.common.base.BaseServiceImpl;
import com.yiya.mapper.TabOnhandVehicleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by laohu on 2018/5/23.
 */

@Service
@Transactional
@BaseService
public class TabOnhandVehicleServiceImpl extends BaseServiceImpl<TabOnhandVehicleMapper,TabOnhandVehicle,TabOnhandVehicleExample> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TabOnhandVehicleServiceImpl.class);

    @Autowired
    TabOnhandVehicleMapper tabOnhandVehicleMapper;
}
