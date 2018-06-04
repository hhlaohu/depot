package com.yiya.web.controller;

import com.yiya.api.bean.TabOnhandVehicleDTO;
import com.yiya.web.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @name: TabOnhandVehicleController
 * @description:
 * @author: huzhihong
 * @email: hh_laohu@163.com
 * @date: 2018/5/28 上午9:37
 */
@Controller
public class TabOnhandVehicleController {

    private final DepotService depotService;

    @Autowired
    public TabOnhandVehicleController(DepotService depotService) {
        this.depotService = depotService;
    }

    @ResponseBody
    @RequestMapping("getId")
    public TabOnhandVehicleDTO list(Long id) {
        return depotService.findByid(id);
    }

}
