package org.example.kunuz.controller;

import org.example.kunuz.dto.SavedArticleDto;
import org.example.kunuz.model.Result;
import org.example.kunuz.model.SavedArticle;
import org.example.kunuz.service.SavedArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savedarticle")
public class SavedArticleController {

    @Autowired
    SavedArticleService savedArticleService;

    @GetMapping
    public List<SavedArticle> getSavedArticles() {
        return savedArticleService.findAll();
    }

    @GetMapping("/{id}")
    public SavedArticle getSavedArticle(@PathVariable Long id) {
        return savedArticleService.findById(id);
    }

    @PostMapping
    public Result saveArticle(@RequestBody SavedArticleDto savedArticleDto) {
        return savedArticleService.create(savedArticleDto);
    }

    @PutMapping("/{id}")
    public Result updateArticle(@PathVariable Long id, @RequestBody SavedArticleDto savedArticleDto) {
        return savedArticleService.update(id, savedArticleDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteArticle(@PathVariable Long id) {
        return savedArticleService.delete(id);
    }

}
