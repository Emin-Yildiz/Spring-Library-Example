package com.example.library.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "WRITER")
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "writer_name",nullable = false)
    private String writerName;
    @Column(name = "website")
    private String website;
    @Column(name = "phone")
    @Size(min = 11, max = 11,message = "Numara 11 haneli olmalı") // phone alanı 11 haneli olmalı yoksa veritabanına kaydetmez
    private String phone;

    public Writer(){}
    public Writer(Long id, String writerName, String website, String phone) {
        this.id = id;
        this.writerName = writerName;
        this.website = website;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
