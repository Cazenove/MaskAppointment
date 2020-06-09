package com.mask.backend.service.impl;

import com.mask.backend.mapper.AppointmentMapper;
import com.mask.backend.mapper.DrawMapper;
import com.mask.backend.mapper.WaitingMapper;
import com.mask.backend.pojo.*;
import com.mask.backend.resource.AppointmentStartResource;
import com.mask.backend.service.AdminService;
import com.mask.backend.util.PropertyMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author SilverBay
 */
public class AdminServiceImpl implements AdminService {

    @Autowired
    AppointmentMapper appointmentMapper;
    @Autowired
    DrawMapper drawMapper;
    @Autowired
    WaitingMapper waitingMapper;

    @Override
    public boolean lastAppointmentOpening() {
        AppointmentExample example = new AppointmentExample();
        List<Appointment> list = appointmentMapper.selectByExample(example);
        return list.get(list.size() -1).getStatuss() == 1;
    }

    @Override
    public boolean isAppointmentOpening(int id) {
        AppointmentExample example = new AppointmentExample();
        AppointmentExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Appointment> list = appointmentMapper.selectByExample(example);
        if(list.isEmpty()) { return false; }

        return list.get(0).getStatuss() == 1;
    }

    @Override
    public int startAppointment(AppointmentStartResource resource) {
        Appointment appointment = new Appointment();
        appointment = PropertyMapperUtil.map(resource, Appointment.class);
        return appointmentMapper.insertSelective(appointment);
    }

    @Override
    public int endAppointment() {
        AppointmentExample example = new AppointmentExample();
        List<Appointment> list = appointmentMapper.selectByExample(example);
        Appointment lastAppointment = list.get(list.size() - 1);
        if(lastAppointment.getStatuss() == 0) {
            return 0;
        } else {
            handleDraw(lastAppointment);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String endTime = sdf.format(new Date());
            lastAppointment.setEndtime(endTime);
            lastAppointment.setStatuss(0);
            return appointmentMapper.updateByPrimaryKeySelective(lastAppointment);
        }
    }

    @Override
    public List<Draw> listDraw(int id) {
        DrawExample example = new DrawExample();
        DrawExample.Criteria criteria = example.createCriteria();
        criteria.andAppointmentIdEqualTo(id);
        return drawMapper.selectByExample(example);
    }

    @Override
    public List<Draw> listAllDraw() {
        DrawExample example = new DrawExample();
        return drawMapper.selectByExample(example);
    }

    @Override
    public Appointment getAppointment(int id) {
        AppointmentExample example = new AppointmentExample();
        AppointmentExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Appointment> list = appointmentMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Appointment> listAppointment() {
        AppointmentExample example = new AppointmentExample();
        return appointmentMapper.selectByExample(example);
    }

    private void handleDraw(Appointment appointment) {
        int maskNum = appointment.getMaxx();

        WaitingExample example = new WaitingExample();
        WaitingExample.Criteria criteria = example.createCriteria();
        criteria.andAppointmentIdEqualTo(appointment.getId());
        List<Waiting> list = waitingMapper.selectByExample(example);
        Collections.shuffle(list);

        int i;
        for(i=0; i<list.size() && maskNum-list.get(i).getAppointNum() >= 0; i++) {
            maskNum -= list.get(i).getAppointNum();
            Draw draw = new Draw();
            draw.setAppointmentId(appointment.getId());
            draw.setWaitingId(list.get(i).getId());
            drawMapper.insertSelective(draw);
        }

        for(;i<list.size(); i++) {
            if(maskNum == list.get(i).getAppointNum()) {
                Draw draw = new Draw();
                draw.setAppointmentId(appointment.getId());
                draw.setWaitingId(list.get(i).getId());
                drawMapper.insertSelective(draw);
                break;
            }
        }
    }

}
