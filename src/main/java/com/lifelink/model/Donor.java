package com.lifelink.model;

import java.sql.Date;

public class Donor {

    private int donorId;
    private String donorName;
    private String bloodGroup;
    private int age;
    private String gender;
    private String phone;
    private Date lastDonation;

    public Donor() {
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastDonation() {
        return lastDonation;
    }

    public void setLastDonation(Date lastDonation) {
        this.lastDonation = lastDonation;
    }
}