package com.yiya.api.service;


import com.yiya.api.bean.TabOnhandVehicleDTO;
/**
 * @name: TabOnhandVehicleService
 * @description: 在场车辆服务
 * @author: huzhihong
 * @email: hh_laohu@163.com
 * @date: 2018/5/28 上午9:39
 */
public interface TabOnhandVehicleService {

    /**
     * 根据id查在场车辆
     *
     * @param id
     * @return
     */
    TabOnhandVehicleDTO findById(Long id);

}
