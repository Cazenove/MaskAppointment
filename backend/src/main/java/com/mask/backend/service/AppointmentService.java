package com.mask.backend.service;

import com.mask.backend.pojo.Place;
import com.mask.backend.resource.AppointResource;
import com.mask.backend.resource.QueryResource;
import com.mask.backend.resource.QueryResult;

import java.util.List;

/**
 * @author ZYF
 */
public interface AppointmentService {

    /**
     * 获取预约状态
     *
     * @return 0 未开放预约 <br/> 1 开放预约
     */
    int getStatus();

    /**
     * 获取取货地点列表
     *
     * @return 取货地点列表
     */
    List<Place> getPlace();

    /**
     * 执行预约
     *
     * @param resource 预约参数
     * @return 是否预约成功
     */
    String doAppointment(AppointResource resource);

    /**
     * 查询预约
     *
     * @param resource 查询参数
     * @return 预约结果
     */
    List<QueryResult> query(QueryResource resource);
}
