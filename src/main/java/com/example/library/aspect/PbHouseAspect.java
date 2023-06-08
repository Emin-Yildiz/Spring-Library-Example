package com.example.library.aspect;

import com.example.library.entities.PublishingHouse;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PbHouseAspect {

    private final Logger logger = LoggerFactory.getLogger(PbHouseAspect.class);

    @After(value = "execution(* com.example.library.controller.*.addPbHouse(..))")
    public void afterCategoryAdd(){
        logger.info("Yayınevi eklendi.");
    }

    @Before(value = "execution(* com.example.library.controller.*.addPbHouse(..))")
    public void beforeCategoryAdd(){
        logger.info("Yayınevi ekleniyor.");
    }

    @AfterReturning(value = "execution(* com.example.library.controller.*.addWriter(..))", returning = "pbHouse")
    public void afterReturningAddUser(PublishingHouse pbHouse){
        logger.info("Yayınevi eklendi eklenen yayınevi bilgileri: \n" +
                "PbHouse name: " + pbHouse.getPublishingHouseName() + "\n"
        );
    }

    // veya kullanarak birden fazla metod belirtebiliriz.
    @AfterThrowing(value = "execution(* com.example.library.controller.*.addPbHouse(..)) || execution(* com.example.library.controller.*.updatePbHouse(..)) || execution(* com.example.library.controller.*.deletePbHouse(..))", throwing = "e")
    public void afterThrowing(Exception e){
        logger.error("İşlem gerçekleştirilirken hata ile karşılaşıldı: " + e.getMessage());
    }
}
