package com.yiya.web.controller;

import com.yiya.common.base.BaseController;
import com.yiya.web.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by laohu on 2018/5/23.
 */

@Controller
public class TabOnhandVehicleController extends BaseController {

    @Autowired
    DepotService depotService;

    @ResponseBody
    @RequestMapping("list")
    public void list() {
        depotService.list();
    }

}
