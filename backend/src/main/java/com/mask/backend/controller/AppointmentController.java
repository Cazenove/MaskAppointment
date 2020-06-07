package com.mask.backend.controller;

import com.mask.backend.resource.AppointResource;
import com.mask.backend.resource.QueryResource;
import com.mask.backend.resource.ResponceBody;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class AppointmentController {

    /**
     * 获取当前预约状态
     *
     * @return 响应体
     */
    @GetMapping("/status")
    @ResponseBody
    Object getStatus() {
        // todo
        return ResponceBody.ok(null, null);
    }

    /**
     * 获取取货地点
     *
     * @return 响应体
     */
    @GetMapping("/place")
    @ResponseBody
    Object getPlace() {
        // todo
        return ResponceBody.ok(null, new ArrayList<>());
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
        // todo
        return ResponceBody.ok("预约成功", null);
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
        // todo
        return ResponceBody.ok(null, new ArrayList<>());
    }
}
