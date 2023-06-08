package com.example.library.services;

import com.example.library.dto.request.CategoryUpdateDTO;
import com.example.library.dto.response.CategoryGetResponseDTO;
import com.example.library.entities.Category;
import com.example.library.repossitory.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper mapper){
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    //  kategori ekleme
    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    // bütün kategorileri getirme
    public List<CategoryGetResponseDTO> getAllCategory(){
        List<Category> categories = categoryRepository.findAll();
        List<CategoryGetResponseDTO> categoryResponse = new ArrayList<>();

        categories.forEach(category -> {
            categoryResponse.add(mapper.map(category,CategoryGetResponseDTO.class));
        });

        return categoryResponse;
    }

    // id'ye göre kategiro bilgilerini getirme
    public CategoryGetResponseDTO getCategoryById(Long id){
        Optional<Category> foundCategory = categoryRepository.findById(id);
        if (foundCategory.isPresent()){
            Category category = foundCategory.get();
            CategoryGetResponseDTO responseDTO = mapper.map(category, CategoryGetResponseDTO.class);
            return responseDTO;
        }else {
            return null;
        }
    }

    // bir model veri tabanına eklenirlen tüm alanların eklenmesi gerekir bu durumda bütün alanları getirmek için aşağıdaki metod kullanılır.
    public Category getCategoryAllFieldById(Long id){
        Optional<Category> foundCategory = categoryRepository.findById(id);
        if (foundCategory.isPresent()){
            return foundCategory.get();
        }else {
            return null;
        }
    }

    // kategori güncelleme sadece açıklama alanı güncellenir.
    public Category updateById(Long id, CategoryUpdateDTO updateDTO){
        Optional<Category> foundCategory = categoryRepository.findById(id);
        if (foundCategory.isPresent()){
            Category category = foundCategory.get();
            mapper.map(updateDTO,category);
            return categoryRepository.save(category);
        }else {
            return null;
        }
    }
    // kategori silme
    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }
}
