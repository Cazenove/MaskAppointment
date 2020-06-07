package com.mask.backend.resource;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponceBody {
    private int status;
    private String msg;
    private Object data;

    /**
     * 错误响应
     *
     * @param msg 错误信息
     * @return 响应体
     */
    public static ResponceBody error(String msg) {
        return builder()
                .status(0)
                .msg(msg)
                .build();
    }

    /**
     * 成功响应
     *
     * @param data 携带的数据
     * @return 响应体
     */
    public static ResponceBody ok(String msg, Object data) {
        return builder()
                .status(1)
                .msg(msg)
                .data(data)
                .build();
    }
}
