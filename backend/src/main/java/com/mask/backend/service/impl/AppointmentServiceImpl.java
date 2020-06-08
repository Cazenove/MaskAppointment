package com.mask.backend.service.impl;

import com.mask.backend.mapper.AppointmentMapper;
import com.mask.backend.mapper.CustomAppointmentMapper;
import com.mask.backend.mapper.PlaceMapper;
import com.mask.backend.mapper.WaitingMapper;
import com.mask.backend.pojo.*;
import com.mask.backend.resource.AppointResource;
import com.mask.backend.resource.QueryResource;
import com.mask.backend.resource.QueryResult;
import com.mask.backend.service.AppointmentService;
import com.mask.backend.util.PropertyMapperUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZYF
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class AppointmentServiceImpl implements AppointmentService {

    @Resource
    AppointmentMapper appointmentMapper;

    @Resource
    PlaceMapper placeMapper;

    @Resource
    WaitingMapper waitingMapper;

    @Resource
    CustomAppointmentMapper customAppointmentMapper;

    @Override
    public int getStatus() {
        AppointmentExample example = new AppointmentExample();
        AppointmentExample.Criteria criteria = example.createCriteria();
        criteria.andStatussEqualTo(1);
        List<Appointment> appointments = appointmentMapper.selectByExample(example);
        if (appointments.isEmpty()) {
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public List<Place> getPlace() {
        PlaceExample example = new PlaceExample();
        List<Place> places = placeMapper.selectByExample(example);
        return places;
    }

    @Override
    public String doAppointment(AppointResource resource) {
        if (getStatus() == 0) {
            return "未开放预约";
        }

        AppointmentExample example = new AppointmentExample();
        AppointmentExample.Criteria criteria = example.createCriteria();
        criteria.andStatussEqualTo(1);
        List<Appointment> appointments = appointmentMapper.selectByExample(example);
        if (appointments.get(0).getLimitt() < resource.getAppointNum()) {
            return "预约口罩数超过限制";
        }

        Waiting newWaiting = PropertyMapperUtil.map(resource, Waiting.class);
        newWaiting.setAppointmentId(appointments.get(0).getId());
        if (waitingMapper.insert(newWaiting) == 1) {
            return "ok";
        }
        else {
            return "服务器内部错误";
        }
    }

    @Override
    public List<QueryResult> query(QueryResource resource) {
        List<QueryResult> queryResults = customAppointmentMapper.queryAppoint(resource.getTelephone());
        return queryResults;
    }
}
