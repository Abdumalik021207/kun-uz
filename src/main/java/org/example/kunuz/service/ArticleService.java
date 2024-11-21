package org.example.kunuz.service;

import org.example.kunuz.dto.ArticleDto;
import org.example.kunuz.model.Article;
import org.example.kunuz.model.Region;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.ArticleRepo;
import org.example.kunuz.repository.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    ArticleRepo articleRepo;

    @Autowired
    RegionRepo regionRepo;

    public List<Article> findAll() {
        return articleRepo.findAll();
    }

    public Article findById(Long id) {
        return articleRepo.findById(id).get();
    }

    public Result create(ArticleDto articleDto) {
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        article.setContent(articleDto.getContent());
        article.setDescription(articleDto.getDescription());
        article.setImageId(articleDto.getImageId());
        article.setModeratorId(articleDto.getModeratorId());

        Region region = new Region();
        region.setNameUz(articleDto.getNameUz());
        region.setNameRu(articleDto.getNameRu());
        region.setNameEn(articleDto.getNameEn());
        region.setCreatedDate(articleDto.getCreatedDate());
        region.setVisible(articleDto.getVisible());
        region.setOrderNumber(articleDto.getOrderNumber());
        Region save = regionRepo.save(region);
        article.setRegionId((List<Region>) save);

        article.setPublishedDate(articleDto.getPublishedDate());
        article.setPublisherId(articleDto.getPublisherId());
        article.setStatus(articleDto.getStatus());
        article.setSharedCount(articleDto.getSharedCount());
        article.setCreateDate(articleDto.getCreateDate());
        article.setViewCount(articleDto.getViewCount());
        article.setVisible(articleDto.getVisible());
        articleRepo.save(article);
        return new Result(true,"Article created successfully");
    }

    public Result update(ArticleDto articleDto, Long id) {
        Optional<Article> byId = articleRepo.findById(id);
        if (byId.isPresent()) {
            Article article = byId.get();
            article.setTitle(articleDto.getTitle());
            article.setContent(articleDto.getContent());
            article.setDescription(articleDto.getDescription());
            article.setImageId(articleDto.getImageId());
            article.setModeratorId(articleDto.getModeratorId());
            article.setPublishedDate(articleDto.getPublishedDate());
            article.setPublisherId(articleDto.getPublisherId());
            article.setStatus(articleDto.getStatus());
            article.setSharedCount(articleDto.getSharedCount());
            article.setCreateDate(articleDto.getCreateDate());
            article.setViewCount(articleDto.getViewCount());
            article.setVisible(articleDto.getVisible());

            Region region = new Region();
            region.setNameUz(articleDto.getNameUz());
            region.setNameRu(articleDto.getNameRu());
            region.setNameEn(articleDto.getNameEn());
            region.setCreatedDate(articleDto.getCreatedDate());
            region.setVisible(articleDto.getVisible());
            region.setOrderNumber(articleDto.getOrderNumber());
            Region save = regionRepo.save(region);
            article.setRegionId((List<Region>) save);

            articleRepo.save(article);
            return new Result(true,"Article updated successfully");
        }
        return new Result(false,"Article not found");
    }

    public Result delete(Long id) {
        articleRepo.deleteById(id);
        return new Result(true,"Article deleted successfully");
    }

}
