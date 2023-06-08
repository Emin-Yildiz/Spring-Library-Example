package com.example.library.dto.request;

import javax.validation.constraints.Size;

public class PbHouseUpdateDTO {
    // yayınevine güncelleme isteği atıldığında aşağıdaki alanlar ile istek atılır çünkü sadece bu alanlar güncellenir.
    public String website;
    public String address;
    @Size(min = 11,max = 11, message = "Telefon numarası 11 haneli olalıdır.")
    public String phone;
}
