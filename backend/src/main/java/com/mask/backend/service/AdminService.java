package com.mask.backend.service;

import com.mask.backend.pojo.Appointment;
import com.mask.backend.pojo.Draw;
import com.mask.backend.resource.AppointmentStartResource;

import java.util.List;

/**
 * @author SilverBay
 */
public interface AdminService {

    /**
     * 查看当前预约轮次是否开放
     * @return 当前轮次开放状态
     */
    boolean lastAppointmentOpening();

    /**
     * 查看某次预约是否正在开放
     * @param id 预约轮次id
     * @return 该预约轮次是否开放，若id不存在，返回false
     */
    boolean isAppointmentOpening(int id);

    /**
     * 开始一轮新的预约
     * @param resource 请求体参数
     * @return 数据库修改的条数，成功开启预约返回1
     */
    int startAppointment(AppointmentStartResource resource);

    /**
     * 开奖并结束当前轮次预约
     * @return 当前轮次预约已经结束返回0，结束成功返回1
     */
    int endAppointment();

    /**
     * 获取某轮预约中签名单
     * @param id 预约轮次id
     * @return 中签名单列表
     */
    List<Draw> listDraw(int id);

    /**
     * 获取全部中签信息
     * @return 全部中签信息列表1
     */
    List<Draw> listAllDraw();

    /**
     * 获取某个预约轮次信息
     * @param id 预约轮次id
     * @return 预约轮次对象，id不存在返回null
     */
    Appointment getAppointment(int id);

    /**
     * 获取全部预约轮次信息
     * @return 全部预约轮次列表
     */
    List<Appointment> listAppointment();

}
