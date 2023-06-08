package com.example.library.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PUBLISHING_HOUSE")
public class PublishingHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "publishingHouseName",nullable = false)
    private String publishingHouseName;

    @Column(name = "website")
    private String website;

    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    @Size(min = 11,max = 11, message = "Telefon numarası 11 haneli olalıdır.") //telefon numarası 11 haneli olup olamadığı kontrolü yapılır.
    private String phone;

    public PublishingHouse(Long id, String publishingHouseName, String website, String address, String phone) {
        this.id = id;
        this.publishingHouseName = publishingHouseName;
        this.website = website;
        this.address = address;
        this.phone = phone;
    }

    public PublishingHouse(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublishingHouseName() {
        return publishingHouseName;
    }

    public void setPublishingHouseName(String publishingHouseName) {
        this.publishingHouseName = publishingHouseName;
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
}
