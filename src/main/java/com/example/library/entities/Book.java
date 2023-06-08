package com.example.library.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ISBN",nullable = false, length = 30) // isbn alanı boş geçilemez ve max 30 karakter girilebilir.
    private String ISBN;
    @Column(name = "bookName",nullable = false,length = 50) // kitap ismi boş girilemez ve max 50 karakter uzunluğunda olaabilir.
    private String bookName;
    @Column(nullable = false)
    private int pageNumber;
    @Column(nullable = false)
    private int printingYear;
    @ManyToOne(fetch = FetchType.EAGER) // lazy = Kitaplara get isteği yaptığım zaman yazar ve yayın evi bilgilerinin gelmesini istemiyorum.
    @JoinColumn(name = "writer_id")
    private Writer writer;
    @ManyToOne(fetch = FetchType.EAGER) // eager olunca bana yazar ve yayınevi bilgilerini getirir.
    @JoinColumn(name = "publishing_house_id")
    private PublishingHouse publishingHouse;
    @ManyToMany
    private List<Category> category;

    public Book(Long id, String ISBN, String bookName, int pageNumber, int printingYear, Writer writer, PublishingHouse publishingHouse, List<Category> category) {
        this.id = id;
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.printingYear = printingYear;
        this.writer = writer;
        this.publishingHouse = publishingHouse;
        this.category = category;
    }

    public Book(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPrintingYear() {
        return printingYear;
    }

    public void setPrintingYear(int printingYear) {
        this.printingYear = printingYear;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

}
