package com.aeroband.datamanage.domain;

import lombok.Data;

@Data
public class PointInfo {
    private Integer pointId;
    private String pointName;
    private Integer pointType;
    private Integer status;
    private boolean isGathered;
}
