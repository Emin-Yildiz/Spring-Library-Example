package com.example.library.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "categoryName", nullable = false, unique = true) // kategori adı boş girilemez ve eşsizdir.
    private String categoryName;
    @Column(name = "description",length = 100) // açıklama max 100 karakter olabilir.
    @Size(max = 100, message = "Açıklama max 100 karakter olabilir.") // açıklamanın kontrolü yapıldı.
    private String description;

    public Category(Long id, String categoryName, String description) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
    }

    public Category(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
