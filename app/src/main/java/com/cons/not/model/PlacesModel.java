package com.cons.not.model;

/**
 * Created by Constantinos on 17/04/2018.
 */

public class PlacesModel {
    private String name;
    private String imgUrl;
    private String description;
    private String website;
    private String address;
    private String phone;
    private String openingHours;
    private String mapUrl;

    public PlacesModel() {
        // TODO Auto-generated constructor stub
    }

    public PlacesModel(String name, String imgUrl, String description, String website, String address, String phone, String openingHours, String mapUrl) {
        super();
        this.name = name;
        this.imgUrl = imgUrl;
        this.description = description;
        this.website = website;
        this.address = address;
        this.phone = phone;
        this.openingHours = openingHours;
        this.mapUrl = mapUrl;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }
}
