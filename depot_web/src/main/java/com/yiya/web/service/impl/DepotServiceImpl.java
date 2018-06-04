package com.yiya.web.service.impl;

import com.yiya.api.bean.TabOnhandVehicleDTO;
import com.yiya.api.service.TabOnhandVehicleService;
import com.yiya.web.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @name: DepotServiceImpl
 * @description:
 * @author: huzhihong
 * @email: hh_laohu@163.com
 * @date: 2018/5/28 上午9:36
 */
@Service(value = "depotService")
public class DepotServiceImpl implements DepotService {

    @Autowired
    private TabOnhandVehicleService tabOnhandVehicleService;

    @Override
    public TabOnhandVehicleDTO findByid(Long id) {
        TabOnhandVehicleDTO tabOnhandVehicleDTO = tabOnhandVehicleService.findById(id);
        return tabOnhandVehicleDTO;
    }
}
