package org.example.kunuz.controller;

import org.example.kunuz.dto.ArticleLikeDto;
import org.example.kunuz.model.ArticleLike;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.ArticleLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articlelike")
public class ArticleLikeController {

    @Autowired
    ArticleLikeService articleLikeService;

    @GetMapping
    public List<ArticleLike> getAll() {
        return articleLikeService.articleLikeList();
    }

    @GetMapping("/{id}")
    public ArticleLike getById(@PathVariable Long id) {
        return articleLikeService.articleLikeListByArticleId(id);
    }

    @PostMapping
    public Result create(@RequestBody ArticleLikeDto articleLikeDto) {
        return articleLikeService.create(articleLikeDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody ArticleLikeDto articleLikeDto) {
        return articleLikeService.update(articleLikeDto, id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return articleLikeService.delete(id);
    }

}
