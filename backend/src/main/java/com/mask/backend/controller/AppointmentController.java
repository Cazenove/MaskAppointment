package com.mask.backend.controller;

import com.mask.backend.dto.RegionalDrawDTO;
import com.mask.backend.pojo.Appointment;
import com.mask.backend.resource.AppointResource;
import com.mask.backend.resource.QueryResource;
import com.mask.backend.resource.QueryResult;
import com.mask.backend.resource.ResponceBody;
import com.mask.backend.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class AppointmentController {

    @Resource(name = "appointmentServiceImpl")
    AppointmentService appointmentService;

    /**
     * 获取当前预约状态
     *
     * @return 响应体
     */
    @GetMapping("/status")
    @ResponseBody
    Object getStatus() {
        if (appointmentService.getStatus() == 1) {
            return ResponceBody.ok(null, null);
        }
        return ResponceBody.error("未开放预约");
    }

    /**
     * 获取取货地点
     *
     * @return 响应体
     */
    @GetMapping("/place")
    @ResponseBody
    Object getPlace() {
        return ResponceBody.ok(null, appointmentService.getPlace());
    }

    /**
     * 预约口罩
     *
     * @param resource 参数
     * @return 响应体
     */
    @PostMapping("/appoint")
    @ResponseBody
    Object appoint(@RequestBody @Valid AppointResource resource) {
        String result = appointmentService.doAppointment(resource);

        if ("ok".equals(result)) {
            return ResponceBody.ok("预约成功", null);
        }
        return ResponceBody.error(result);
    }

    /**
     * 预约查询
     *
     * @param resource 参数
     * @return 响应体
     */
    @PostMapping("/query")
    @ResponseBody
    Object query(@RequestBody @Valid QueryResource resource) {
        List<QueryResult> queryResults = appointmentService.query(resource);
        if (queryResults.isEmpty()) {
            return ResponceBody.error("未中签");
        }
        return ResponceBody.ok(null, queryResults.get(0));
    }

    /**
     * 返回所有轮次信息
     *
     *
     * @return 响应体
     */
    @GetMapping("/appointment/list")
    @ResponseBody
    Object listAppointment() {
        return ResponceBody.ok(null,appointmentService.listAppointment());
    }

    /**
     * 返回某轮各地中签数
     *
     * @param id 轮次id
     * @return 响应体
     */
    @GetMapping("/place/statistics")
    @ResponseBody
    Object listCount(@RequestBody @Valid Integer id) {
        List<RegionalDrawDTO> list = appointmentService.listCount(id);
        if (list.size() == 0) {
            return ResponceBody.error("id无效或轮次未开始");
        }
        return ResponceBody.ok(null,list);
    }
}
