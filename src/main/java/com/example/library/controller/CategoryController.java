package com.example.library.controller;

import com.example.library.dto.request.CategoryUpdateDTO;
import com.example.library.dto.response.CategoryGetResponseDTO;
import com.example.library.entities.Category;
import com.example.library.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryGetResponseDTO> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryGetResponseDTO getById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
        //return ResponseEntity<>(categoryService.addCategory(category), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody CategoryUpdateDTO updateDTO){
        return categoryService.updateById(id,updateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteById(id);
    }
}
