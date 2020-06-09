package com.mask.backend.resource;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusResult {
    Integer limit;
    String startTime;
    String endTime;
}
