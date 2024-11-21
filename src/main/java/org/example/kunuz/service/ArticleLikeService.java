package org.example.kunuz.service;

import org.example.kunuz.dto.ArticleLikeDto;
import org.example.kunuz.model.*;
import org.example.kunuz.repository.ArticleLIkeRepo;
import org.example.kunuz.repository.ArticleRepo;
import org.example.kunuz.repository.ProfileRepo;
import org.example.kunuz.repository.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleLikeService {

    @Autowired
    ArticleLIkeRepo articleLIkeRepo;

    @Autowired
    ArticleRepo articleRepo;

    @Autowired
    RegionRepo regionRepo;

    @Autowired
    ProfileRepo profileRepo;



    public List<ArticleLike> articleLikeList() {
        return articleLIkeRepo.findAll();
    }

    public ArticleLike articleLikeListByArticleId(Long id) {
        return articleLIkeRepo.findById(id).get();
    }

    public Result create(ArticleLikeDto articleLikeDto) {
        ArticleLike articleLike = new ArticleLike();
        articleLike.setCreatedDate(articleLikeDto.getCreatedDate());
        articleLike.setStatus(articleLikeDto.getStatus());

        Profile profile = new Profile();
        profile.setName(articleLikeDto.getName());
        profile.setEmail(articleLikeDto.getEmail());
        profile.setPhone(articleLikeDto.getPhone());
        profile.setSurname(articleLikeDto.getSurname());
        profile.setRole(articleLikeDto.getRole());
        profile.setStatus(articleLikeDto.getStatus());
        profile.setVisible(articleLikeDto.getVisible());
        profile.setPhotoId(articleLikeDto.getPhotoId());
        profile.setCreateData(articleLikeDto.getCreateData());
        profileRepo.save(profile);

        Article article = new Article();
        article.setTitle(articleLikeDto.getTitle());
        article.setContent(articleLikeDto.getContent());
        article.setDescription(articleLikeDto.getDescription());
        article.setImageId(articleLikeDto.getImageId());
        article.setModeratorId(articleLikeDto.getModeratorId());

        Region region = new Region();
        region.setNameUz(articleLikeDto.getNameUz());
        region.setNameRu(articleLikeDto.getNameRu());
        region.setNameEn(articleLikeDto.getNameEn());
        region.setCreatedDate(articleLikeDto.getCreatedDate());
        region.setVisible(articleLikeDto.getVisible());
        region.setOrderNumber(articleLikeDto.getOrderNumber());
        Region save = regionRepo.save(region);
        article.setRegionId((List<Region>) save);

        article.setPublishedDate(articleLikeDto.getPublishedDate());
        article.setPublisherId(articleLikeDto.getPublisherId());
        article.setStatus(articleLikeDto.getStatus());
        article.setSharedCount(articleLikeDto.getSharedCount());
        article.setCreateDate(articleLikeDto.getCreateDate());
        article.setViewCount(articleLikeDto.getViewCount());
        article.setVisible(articleLikeDto.getVisible());
        articleRepo.save(article);

        articleLike.setArticleId(article);
        articleLike.setProfileId(profile);

        articleLIkeRepo.save(articleLike);
        return new Result(true,"ArticleLike created successfully");
    }

    public Result update(ArticleLikeDto articleLikeDto, Long id) {
        Optional<ArticleLike> byId = articleLIkeRepo.findById(id);
        if (byId.isPresent()) {
            ArticleLike articleLike = byId.get();
            articleLike.setCreatedDate(articleLikeDto.getCreatedDate());
            articleLike.setStatus(articleLikeDto.getStatus());

            Profile profile = new Profile();
            profile.setName(articleLikeDto.getName());
            profile.setEmail(articleLikeDto.getEmail());
            profile.setPhone(articleLikeDto.getPhone());
            profile.setSurname(articleLikeDto.getSurname());
            profile.setRole(articleLikeDto.getRole());
            profile.setStatus(articleLikeDto.getStatus());
            profile.setVisible(articleLikeDto.getVisible());
            profile.setPhotoId(articleLikeDto.getPhotoId());
            profile.setCreateData(articleLikeDto.getCreateData());
            profileRepo.save(profile);

            Article article = new Article();
            article.setTitle(articleLikeDto.getTitle());
            article.setContent(articleLikeDto.getContent());
            article.setDescription(articleLikeDto.getDescription());
            article.setImageId(articleLikeDto.getImageId());
            article.setModeratorId(articleLikeDto.getModeratorId());

            Region region = new Region();
            region.setNameUz(articleLikeDto.getNameUz());
            region.setNameRu(articleLikeDto.getNameRu());
            region.setNameEn(articleLikeDto.getNameEn());
            region.setCreatedDate(articleLikeDto.getCreatedDate());
            region.setVisible(articleLikeDto.getVisible());
            region.setOrderNumber(articleLikeDto.getOrderNumber());
            Region save = regionRepo.save(region);
            article.setRegionId((List<Region>) save);

            article.setPublishedDate(articleLikeDto.getPublishedDate());
            article.setPublisherId(articleLikeDto.getPublisherId());
            article.setStatus(articleLikeDto.getStatus());
            article.setSharedCount(articleLikeDto.getSharedCount());
            article.setCreateDate(articleLikeDto.getCreateDate());
            article.setViewCount(articleLikeDto.getViewCount());
            article.setVisible(articleLikeDto.getVisible());
            articleRepo.save(article);

            articleLike.setArticleId(article);
            articleLike.setProfileId(profile);

            articleLIkeRepo.save(articleLike);
            return new Result(true,"ArticleLike updated successfully");
        }
        return new Result(false,"ArticleLike not found");
    }

    public Result delete(Long id) {
        articleLIkeRepo.deleteById(id);
        return new Result(true,"ArticleLike deleted successfully");
    }

}
