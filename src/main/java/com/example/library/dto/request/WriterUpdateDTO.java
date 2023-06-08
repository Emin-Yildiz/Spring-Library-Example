package com.example.library.dto.request;

import javax.validation.constraints.Size;

public class WriterUpdateDTO {

    // yazara güncelleme isteği atıldığında aşağıdaki alanlar ile istek atılır çünkü sadece bu alanlar güncellenir.
    public String website;
    @Size(min = 11, max = 11,message = "Numara 11 haneli olmalı")
    public String phone;
}
