package com.example.library.dto.request;

import com.example.library.entities.Category;

import java.util.List;

public class BookCreateDTO {
    // kitap'a post isteği atıldığında aşağıdaki alanlar ile istek atılır çünkü bu alanlar kitap nesnesi için zorunlu ve yeterlidir.
    public String isbn;
    public String bookName;
    public int pageNumber;
    public int printingYear;
    public Long writerId;
    public Long pbHouseId;
    public List<Category> categoryList;
}
