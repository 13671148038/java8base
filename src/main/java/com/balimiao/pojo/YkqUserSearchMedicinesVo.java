package com.balimiao.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author zhushaopeng
 * @Date 2019/11/11
 **/
@Data
public class YkqUserSearchMedicinesVo {
    private Integer medicineId;
    private Integer drugstoreId;
    private String medicineName;
    private String medicineCommonName;
    private String medicineMainImage;
    private String medicineSpecifications;
    private Double medicineSmartfacePrice;
    private String drugstoreName;
    private Double drugstoreDistance;
    private Date drugstoreCreateTime;
    private Date medicinesCreateTime;
    private boolean ddd;
    private Long id;
}
