package com.example.library.aspect;

import com.example.library.entities.Category;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CategoryAspect {

    private final Logger logger = LoggerFactory.getLogger(CategoryAspect.class);

    @After(value = "execution(* com.example.library.controller.*.addCategory(..))")
    public void afterCategoryAdd(){
        logger.info("Kategori eklendi.");
    }

    @Before(value = "execution(* com.example.library.controller.*.addCategory(..))")
    public void beforeCategoryAdd(){
        logger.info("Kategori ekleniyor.");
    }

    @AfterReturning(value = "execution(* com.example.library.controller.*.addCategory(..))", returning = "category")
    public void afterReturningAddUser(Category category){
        logger.info("Kategori eklendi eklenen kullanıcı bilgileri: \n" +
                "Category name: " + category.getCategoryName() + "\n" +
                "Category description: " + category.getDescription() + "\n"
        );
    }

    // veya kullanarak birden fazla metod belirtebiliriz.
    @AfterThrowing(value = "execution(* com.example.library.controller.*.addCategory(..)) || execution(* com.example.library.controller.*.updateCategory(..)) || execution(* com.example.library.controller.*.deleteCategory(..))", throwing = "e")
    public void afterThrowing(Exception e){
        logger.error("İşlem gerçekleştirilirken hata ile karşılaşıldı: " + e.getMessage());
    }
}
