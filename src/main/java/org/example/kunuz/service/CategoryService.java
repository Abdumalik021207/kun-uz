package org.example.kunuz.service;

import org.example.kunuz.dto.CategoryDto;
import org.example.kunuz.model.Category;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Category findById(Long id) {
        return categoryRepo.findById(id).get();
    }

    public Result create(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCreatedDate(categoryDto.getCreatedDate());
        category.setVisible(categoryDto.getVisible());
        category.setOrderNumber(categoryDto.getOrderNumber());
        category.setNameUz(categoryDto.getNameUz());
        category.setNameRu(categoryDto.getNameRu());
        category.setNameEng(categoryDto.getNameEng());
        categoryRepo.save(category);
        return new Result(true,"Category created successfully");
    }

    public Result update(CategoryDto categoryDto, Long id) {
        Optional<Category> byId = categoryRepo.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            category.setCreatedDate(categoryDto.getCreatedDate());
            category.setVisible(categoryDto.getVisible());
            category.setOrderNumber(categoryDto.getOrderNumber());
            category.setNameUz(categoryDto.getNameUz());
            category.setNameRu(categoryDto.getNameRu());
            category.setNameEng(categoryDto.getNameEng());
            categoryRepo.save(category);
            return new Result(true,"Category updated successfully");
        }
        return new Result(false,"Category not found");
    }

    public Result delete(Long id) {
        categoryRepo.deleteById(id);
        return new Result(true,"Category deleted successfully");
    }

}
