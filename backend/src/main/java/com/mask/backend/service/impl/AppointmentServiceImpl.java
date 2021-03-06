package com.mask.backend.service.impl;

import com.mask.backend.dto.RegionalDrawDTO;
import com.mask.backend.mapper.*;
import com.mask.backend.pojo.*;
import com.mask.backend.resource.*;
import com.mask.backend.service.AppointmentService;
import com.mask.backend.util.PropertyMapperUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
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
    DrawMapper drawMapper;

    @Resource
    PlaceMapper placeMapper;

    @Resource
    WaitingMapper waitingMapper;

    @Resource
    CustomAppointmentMapper customAppointmentMapper;

    @Override
    public Appointment getStatus() {
        AppointmentExample example = new AppointmentExample();
        AppointmentExample.Criteria criteria = example.createCriteria();
        criteria.andStatussEqualTo(1);
        List<Appointment> appointments = appointmentMapper.selectByExample(example);
        if (appointments.isEmpty()) {
            return null;
        }
        return appointments.get(0);
    }

    @Override
    public List<Place> getPlace() {
        PlaceExample example = new PlaceExample();
        List<Place> places = placeMapper.selectByExample(example);
        return places;
    }

    @Override
    public String doAppointment(AppointResource resource) {
        Appointment curAppointment = getStatus();
        if (curAppointment == null) {
            return "未开放预约";
        }
        if (curAppointment.getLimitt() < resource.getAppointNum()) {
            return "预约口罩数超过限制";
        }
        if (isIdnumAppointed(resource.getIdNum(), curAppointment.getId())) {
            return "该身份证号码本轮次已预约";
        }
        if (isTelephoneAppointed(resource.getTelephone(), curAppointment.getId())) {
            return "该电话号码本轮次已预约";
        }

        Waiting newWaiting = PropertyMapperUtil.map(resource, Waiting.class);
        newWaiting.setAppointmentId(curAppointment.getId());
        if (waitingMapper.insert(newWaiting) == 1) {
            return "ok";
        }

        return "服务器内部错误";
    }

    @Override
    public List<QueryResult> query(QueryResource resource) {
        List<QueryResult> queryResults = customAppointmentMapper.queryAppoint(resource.getTelephone());
        return queryResults;
    }

    @Override
    public List<Appointment> listAppointment() {
        AppointmentExample example = new AppointmentExample();
        List<Appointment> list = appointmentMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<RegionalDrawDTO> listCount(Integer id) {
        List<RegionalDrawDTO> dataList = new LinkedList<>();
        DrawExample drawExample = new DrawExample();
        drawExample.createCriteria().andAppointmentIdEqualTo(id);
        List<Draw> waitingList = drawMapper.selectByExample(drawExample);
        for (Draw d : waitingList) {
            //获取单个中签号码信息
            WaitingExample waitingExample = new WaitingExample();
            waitingExample.createCriteria().andIdEqualTo(d.getWaitingId());
            Waiting waiting = waitingMapper.selectByExample(waitingExample).get(0);
            //从中签号码信息获取地点信息
            PlaceExample placeExample = new PlaceExample();
            placeExample.createCriteria().andIdEqualTo(waiting.getPlaceId());
            Place place = placeMapper.selectByExample(placeExample).get(0);
            //dto赋值过程  flag标记是否是已记录地区，若该地区未被记录则新加一个对象进入list
            Integer flag = 0;
            for (RegionalDrawDTO data : dataList) {
                if (data.getPlace().equals(place.getPlace())) {
                    data.setCount(data.getCount() + waiting.getAppointNum());
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                RegionalDrawDTO newData = new RegionalDrawDTO();
                newData.setPlace(place.getPlace());
                newData.setCount(waiting.getAppointNum());
                dataList.add(newData);
            }
        }
        return dataList;
    }

    @Override
    public boolean isIdnumAppointed(String idNum, Integer appointmentId) {
        WaitingExample example = new WaitingExample();
        WaitingExample.Criteria criteria = example.createCriteria();
        criteria.andIdNumEqualTo(idNum)
                .andAppointmentIdEqualTo(appointmentId);

        return !waitingMapper.selectByExample(example).isEmpty();
    }

    @Override
    public boolean isTelephoneAppointed(String telephone, Integer appointmentId) {
        WaitingExample example = new WaitingExample();
        WaitingExample.Criteria criteria = example.createCriteria();
        criteria.andTelephoneEqualTo(telephone)
                .andAppointmentIdEqualTo(appointmentId);

        return !waitingMapper.selectByExample(example).isEmpty();
    }
}
