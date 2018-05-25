package com.yiya.api.service;


import com.yiya.api.bean.TabOnhandVehicleDTO;

/**
 * Created by laohu on 2018/5/23.
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
