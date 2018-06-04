package com.yiya.web.service;

import com.yiya.api.bean.TabOnhandVehicleDTO;

/**
 * @name: DepotService
 * @description:
 * @author: huzhihong
 * @email: hh_laohu@163.com
 * @date: 2018/5/28 上午9:36
 */
public interface DepotService {

    TabOnhandVehicleDTO findByid(Long id);

}
