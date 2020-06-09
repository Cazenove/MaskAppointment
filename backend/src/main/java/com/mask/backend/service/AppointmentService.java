package com.mask.backend.service;

import com.mask.backend.dto.RegionalDrawDTO;
import com.mask.backend.pojo.Appointment;
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
    Appointment getStatus();

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

    /**
     *返回所有轮次信息
     *
     *
     * @return 轮次信息
     */
    List<Appointment> listAppointment();

    /**
     *返回地区中签数
     *
     * @param id 轮次id
     * @return 各地中签数
     */
    List<RegionalDrawDTO> listCount(Integer id);

    /**
     * 判断身份证本轮是否预约过
     *
     * @param idNum 身份证
     * @param appointmentId 预约轮次
     * @return <code>true</code> - 预约过 </br> <code>false</code> - 没预约过
     */
    boolean isIdnumAppointed(String idNum, Integer appointmentId);

    /**
     * 判断电话本轮是否预约过
     *
     * @param telephone 电话
     * @param appointmentId 预约轮次
     * @return <code>true</code> - 预约过 </br> <code>false</code> - 没预约过
     */
    boolean isTelephoneAppointed(String telephone, Integer appointmentId);
}
