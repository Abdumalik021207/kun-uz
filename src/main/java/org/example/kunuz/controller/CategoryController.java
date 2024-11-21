package org.example.kunuz.controller;

import org.example.kunuz.dto.CategoryDto;
import org.example.kunuz.model.Category;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public Result save(@RequestBody CategoryDto categoryDto) {
        return categoryService.create(categoryDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        return categoryService.update(categoryDto, id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return categoryService.delete(id);
    }

}
