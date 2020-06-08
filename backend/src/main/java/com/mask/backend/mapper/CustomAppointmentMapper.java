package com.mask.backend.mapper;

import com.mask.backend.resource.QueryResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomAppointmentMapper {
    List<QueryResult> queryAppoint(@Param(value = "telephone") String telephone);
}
