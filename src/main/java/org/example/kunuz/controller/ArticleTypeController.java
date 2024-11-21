package org.example.kunuz.controller;

import org.example.kunuz.dto.ArticleTypeDto;
import org.example.kunuz.model.ArticleType;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articletype")
public class ArticleTypeController {

    @Autowired
    ArticleTypeService articleTypeService;

    public List<ArticleType> getArticleTypeList() {
        return articleTypeService.findAll();
    }

    public ArticleType getArticleTypeById(@PathVariable Long id) {
        return articleTypeService.findById(id);
    }

    public Result addArticleType(@RequestBody ArticleTypeDto articleTypeDto) {
        return articleTypeService.create(articleTypeDto);
    }

    public Result updateArticleType(@RequestBody ArticleTypeDto articleTypeDto, @PathVariable Long id) {
        return articleTypeService.update(articleTypeDto, id);
    }

    public Result deleteArticleTypeById(@PathVariable Long id) {
        return articleTypeService.delete(id);
    }

}
