package com.example.library.aspect;

import com.example.library.entities.Book;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {

    private final Logger logger = LoggerFactory.getLogger(BookAspect.class);

    @After(value = "execution(* com.example.library.controller.*.addBook(..))")
    public void afterCategoryAdd(){
        logger.info("Kitap eklendi.");
    }

    @Before(value = "execution(* com.example.library.controller.*.addBook(..))")
    public void beforeCategoryAdd(){
        logger.info("Kitap ekleniyor.");
    }

    @AfterReturning(value = "execution(* com.example.library.controller.*.addBook(..))", returning = "book")
    public void afterReturningAddUser(Book book){
        logger.info("Kitap eklendi eklenen kullanıcı bilgileri: \n" +
                "Book name: " + book.getBookName() + "\n" +
                "Book writer: " + book.getWriter().getWriterName() + "\n"
        );
    }

    // veya kullanarak birden fazla metod belirtebiliriz.
    @AfterThrowing(value = "execution(* com.example.library.controller.*.addBook(..))|| execution(* com.example.library.controller.*.deleteById(..))", throwing = "e")
    public void afterThrowing(Exception e){
        logger.error("İşlem gerçekleştirilirken hata ile karşılaşıldı: " + e.getMessage());
    }
}