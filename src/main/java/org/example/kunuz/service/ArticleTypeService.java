package org.example.kunuz.service;

import org.example.kunuz.dto.ArticleTypeDto;
import org.example.kunuz.model.ArticleType;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.ArticleTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleTypeService {

    @Autowired
    ArticleTypeRepo articleTypeRepo;

    public List<ArticleType> findAll() {
        return articleTypeRepo.findAll();
    }

    public ArticleType findById(Long id) {
        return articleTypeRepo.findById(id).get();
    }

    public Result create(ArticleTypeDto articleTypeDto) {
        ArticleType articleType = new ArticleType();
        articleType.setCreatedDate(articleTypeDto.getCreatedDate());
        articleType.setOrderNumber(articleTypeDto.getOrderNumber());
        articleType.setVisible(articleTypeDto.getVisible());
        articleType.setNameUz(articleTypeDto.getNameUz());
        articleType.setNameRu(articleTypeDto.getNameRu());
        articleType.setNameEng(articleTypeDto.getNameEng());
        articleTypeRepo.save(articleType);
        return new Result(true,"ArticleType created successfully");
    }

    public Result update(ArticleTypeDto articleTypeDto, Long id) {
        Optional<ArticleType> byId = articleTypeRepo.findById(id);
        if (byId.isPresent()) {
            ArticleType articleType = byId.get();
            articleType.setCreatedDate(articleTypeDto.getCreatedDate());
            articleType.setOrderNumber(articleTypeDto.getOrderNumber());
            articleType.setVisible(articleTypeDto.getVisible());
            articleType.setNameUz(articleTypeDto.getNameUz());
            articleType.setNameRu(articleTypeDto.getNameRu());
            articleType.setNameEng(articleTypeDto.getNameEng());
            articleTypeRepo.save(articleType);
            return new Result(true,"ArticleType updated successfully");
        }
        return new Result(false,"ArticleType not found");
    }

    public Result delete(Long id) {
        articleTypeRepo.deleteById(id);
        return new Result(true,"ArticleType deleted successfully");
    }

}
