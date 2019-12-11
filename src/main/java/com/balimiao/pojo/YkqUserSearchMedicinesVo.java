package com.balimiao.pojo;

import java.util.Comparator;
import java.util.Date;

/**
 * @Description: TODO
 * @Author zhushaopeng
 * @Date 2019/11/11
 **/
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

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getDrugstoreId() {
        return drugstoreId;
    }

    public void setDrugstoreId(Integer drugstoreId) {
        this.drugstoreId = drugstoreId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineCommonName() {
        return medicineCommonName;
    }

    public void setMedicineCommonName(String medicineCommonName) {
        this.medicineCommonName = medicineCommonName;
    }

    public String getMedicineMainImage() {
        return medicineMainImage;
    }

    public void setMedicineMainImage(String medicineMainImage) {
        this.medicineMainImage = medicineMainImage;
    }

    public String getMedicineSpecifications() {
        return medicineSpecifications;
    }

    public void setMedicineSpecifications(String medicineSpecifications) {
        this.medicineSpecifications = medicineSpecifications;
    }

    public Double getMedicineSmartfacePrice() {
        return medicineSmartfacePrice;
    }

    public void setMedicineSmartfacePrice(Double medicineSmartfacePrice) {
        this.medicineSmartfacePrice = medicineSmartfacePrice;
    }

    public String getDrugstoreName() {
        return drugstoreName;
    }

    public void setDrugstoreName(String drugstoreName) {
        this.drugstoreName = drugstoreName;
    }

    public Double getDrugstoreDistance() {
        return drugstoreDistance;
    }

    public void setDrugstoreDistance(Double drugstoreDistance) {
        this.drugstoreDistance = drugstoreDistance;
    }

    public Date getDrugstoreCreateTime() {
        return drugstoreCreateTime;
    }

    public void setDrugstoreCreateTime(Date drugstoreCreateTime) {
        this.drugstoreCreateTime = drugstoreCreateTime;
    }

    public Date getMedicinesCreateTime() {
        return medicinesCreateTime;
    }

    public void setMedicinesCreateTime(Date medicinesCreateTime) {
        this.medicinesCreateTime = medicinesCreateTime;
    }

    @Override
    public String toString() {
        return "YkqUserSearchMedicinesVo{" +
                "medicineId=" + medicineId +
                ", drugstoreId=" + drugstoreId +
                ", medicineName='" + medicineName + '\'' +
                ", medicineCommonName='" + medicineCommonName + '\'' +
                ", medicineMainImage='" + medicineMainImage + '\'' +
                ", medicineSpecifications='" + medicineSpecifications + '\'' +
                ", medicineSmartfacePrice=" + medicineSmartfacePrice +
                ", drugstoreName='" + drugstoreName + '\'' +
                ", drugstoreDistance=" + drugstoreDistance +
                ", drugstoreCreateTime=" + drugstoreCreateTime +
                ", medicinesCreateTime=" + medicinesCreateTime +
                '}';
    }
}
