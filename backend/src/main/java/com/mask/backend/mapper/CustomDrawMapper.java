package com.mask.backend.mapper;

import com.mask.backend.resource.DrawResultResource;

import java.util.List;

public interface CustomDrawMapper {

    List<DrawResultResource> getDrawResult(int id);

    List<DrawResultResource> getAllDrawResult();
}
