package org.example.kunuz.controller;

import org.example.kunuz.dto.ArticleDto;
import org.example.kunuz.model.Article;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> findAll() {
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public Article findById(@PathVariable Long id) {
        return articleService.findById(id);
    }

    @PostMapping
    public Result save(@RequestBody ArticleDto articleDto) {
        return articleService.create(articleDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody ArticleDto articleDto) {
        return articleService.update(articleDto, id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return articleService.delete(id);
    }

}
