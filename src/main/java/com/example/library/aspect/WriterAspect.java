package com.example.library.aspect;

import com.example.library.entities.Writer;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WriterAspect {

    private final Logger logger = LoggerFactory.getLogger(WriterAspect.class);

    @After(value = "execution(* com.example.library.controller.*.addWriter(..))")
    public void afterCategoryAdd(){
        logger.info("Yazar eklendi.");
    }

    @Before(value = "execution(* com.example.library.controller.*.addWriter(..))")
    public void beforeCategoryAdd(){
        logger.info("Yazar ekleniyor.");
    }

    @AfterReturning(value = "execution(* com.example.library.controller.*.addWriter(..))", returning = "writer")
    public void afterReturningAddUser(Writer writer){
        logger.info("Yazar eklendi eklenen kullanıcı bilgileri: \n" +
                "Writer name: " + writer.getWriterName() + "\n"
        );
    }

    // veya kullanarak birden fazla metod belirtebiliriz.
    @AfterThrowing(value = "execution(* com.example.library.controller.*.addWriter(..)) || execution(* com.example.library.controller.*.updateWritter(..)) || execution(* com.example.library.controller.*.deleteWritter(..))", throwing = "e")
    public void afterThrowing(Exception e){
        logger.error("İşlem gerçekleştirilirken hata ile karşılaşıldı: " + e.getMessage());
    }
}
