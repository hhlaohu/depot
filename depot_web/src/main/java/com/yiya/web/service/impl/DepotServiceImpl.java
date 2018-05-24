package com.yiya.web.service.impl;

import com.yiya.bean.TabOnhandVehicle;
import com.yiya.bean.TabOnhandVehicleExample;
import com.yiya.service.TabOnhandVehicleService;
import com.yiya.web.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by laohu on 2018/5/23.
 */
@Service("depotService")
public class DepotServiceImpl implements DepotService {

    @Autowired
    private TabOnhandVehicleService tabOnhandVehicleService;

    @Override
    public List<TabOnhandVehicle> list(){
        return tabOnhandVehicleService.selectByExample(new TabOnhandVehicleExample());
    }
}
