package com.mask.backend.controller;

import com.mask.backend.pojo.Appointment;
import com.mask.backend.resource.*;
import com.mask.backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/start")
    @ResponseBody
    public Object startAppointment(@RequestBody @Valid AppointmentStartResource resource) {

        if(adminService.lastAppointmentOpening()) {
            return ResponceBody.error("上次预约未结束");
        }
        if(adminService.startAppointment(resource) == -1) {
            return ResponceBody.error("程序内部错误，开放预约失败");
        }

        return ResponceBody.ok("开放预约成功", null);
    }

    @PostMapping("/end")
    @ResponseBody
    public Object endAppointment() {

        int checkValue = adminService.endAppointment();
        if(checkValue == 0) {
            return ResponceBody.error("预约已经结束，无需再进行结束预约操作");
        } else if(checkValue == -1) {
            return ResponceBody.error("程序内部错误，结束预约失败");
        }

        return ResponceBody.ok("已经结束预约", null);
    }

    @GetMapping("/draw")
    @ResponseBody
    public Object getDrawList(@RequestBody @Valid DrawListResource resource) {

        if(adminService.getAppointment(resource.getId()) == null) {
            return ResponceBody.error("该预约轮次不存在");
        }

        if(adminService.isAppointmentOpening(resource.getId())) {
            return ResponceBody.error("该轮预约还未结束，无中签名单");
        }

        List<DrawResultResource> list = adminService.listDraw(resource.getId());

        return ResponceBody.ok(null, list);
    }

    @GetMapping("/draw/list")
    @ResponseBody
    public Object getAllDrawList() {
        List<DrawResultResource> list = null;
        try {
            list = adminService.listAllDraw();
        } catch (Exception exc) {
            return ResponceBody.error("程序内部错误，获取所有中签名单失败");
        }

        return ResponceBody.ok(null, list);
    }

    @GetMapping("/appointment")
    @ResponseBody
    public Object getAppointment(@RequestBody @Valid AppointmentGetResource resource) {
        Appointment appointment = adminService.getAppointment(resource.getId());
        if(appointment == null) {
            return ResponceBody.error("该预约轮次不存在");
        }

        return ResponceBody.ok(null, appointment);
    }

    @GetMapping("/appointment/list")
    @ResponseBody
    public Object listAppointment() {
        List<Appointment> list = null;
        try {
            list = adminService.listAppointment();
        } catch (Exception exc) {
            return ResponceBody.error("程序内部错误，获取预约列表失败");
        }

        return ResponceBody.ok(null, list);
    }

}
