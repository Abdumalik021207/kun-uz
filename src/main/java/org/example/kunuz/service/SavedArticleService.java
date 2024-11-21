package org.example.kunuz.service;

import org.example.kunuz.dto.SavedArticleDto;
import org.example.kunuz.model.*;
import org.example.kunuz.repository.CommentRepo;
import org.example.kunuz.repository.ProfileRepo;
import org.example.kunuz.repository.RegionRepo;
import org.example.kunuz.repository.SavedArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavedArticleService {

    @Autowired
    SavedArticleRepo savedArticleRepo;

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    RegionRepo regionRepo;

    @Autowired
    ProfileRepo profileRepo;

    public List<SavedArticle> findAll() {
        return savedArticleRepo.findAll();
    }

    public SavedArticle findById(Long id) {
        return savedArticleRepo.findById(id).get();
    }

    public Result create(SavedArticleDto savedArticleDto) {
        SavedArticle savedArticle = new SavedArticle();
        savedArticle.setCreatedDate(savedArticleDto.getCreatedDate());
        savedArticle.setStatus(savedArticleDto.getStatus());

        // Comment

        Comment comment = new Comment();
        comment.setContent(savedArticleDto.getContent());
        comment.setCreatedDate(savedArticleDto.getCreatedDate());
        comment.setReplyId(savedArticleDto.getReplyId());
        Profile profile = new Profile();
        profile.setName(savedArticleDto.getName());
        profile.setEmail(savedArticleDto.getEmail());
        profile.setPhone(savedArticleDto.getPhone());
        profile.setSurname(savedArticleDto.getSurname());
        profile.setRole(savedArticleDto.getRole());
        profile.setStatus(savedArticleDto.getStatus());
        profile.setVisible(savedArticleDto.getVisible());
        profile.setPhotoId(savedArticleDto.getPhotoId());
        profile.setCreateData(savedArticleDto.getCreateData());

        Profile save = profileRepo.save(profile);

        Article article = new Article();
        article.setTitle(savedArticleDto.getTitle());
        article.setContent(savedArticleDto.getContent());
        article.setDescription(savedArticleDto.getDescription());
        article.setImageId(savedArticleDto.getImageId());
        article.setModeratorId(savedArticleDto.getModeratorId());
        article.setPublishedDate(savedArticleDto.getPublishedDate());
        article.setPublisherId(savedArticleDto.getPublisherId());
        article.setStatus(savedArticleDto.getStatus());
        article.setSharedCount(savedArticleDto.getSharedCount());
        article.setCreateDate(savedArticleDto.getCreateDate());
        article.setViewCount(savedArticleDto.getViewCount());
        article.setVisible(savedArticleDto.getVisible());

        Region region = new Region();
        region.setNameUz(savedArticleDto.getNameUz());
        region.setNameRu(savedArticleDto.getNameRu());
        region.setNameEn(savedArticleDto.getNameEn());
        region.setCreatedDate(savedArticleDto.getCreatedDate());
        region.setVisible(savedArticleDto.getVisible());
        region.setOrderNumber(savedArticleDto.getOrderNumber());

        Region save1 = regionRepo.save(region);
        article.setRegionId((List<Region>) save1);

        comment.setArticleId(article);

        comment.setProfileId(save);
        comment.setUpdatedDate(savedArticleDto.getUpdatedDate());
        comment.setVisible(savedArticleDto.getVisible());

        commentRepo.save(comment);
        savedArticle.setCommentId(comment);
        savedArticle.setProfileId(profile);

        savedArticleRepo.save(savedArticle);
        return new Result(true, "Saved article successfully created");
    }

    public Result update(Long id, SavedArticleDto savedArticleDto) {
        Optional<SavedArticle> byId = savedArticleRepo.findById(id);
        if (byId.isPresent()) {
            SavedArticle savedArticle = byId.get();
            savedArticle.setCreatedDate(savedArticleDto.getCreatedDate());
            savedArticle.setStatus(savedArticleDto.getStatus());

            // Comment

            Comment comment = new Comment();
            comment.setContent(savedArticleDto.getContent());
            comment.setCreatedDate(savedArticleDto.getCreatedDate());
            comment.setReplyId(savedArticleDto.getReplyId());
            Profile profile = new Profile();
            profile.setName(savedArticleDto.getName());
            profile.setEmail(savedArticleDto.getEmail());
            profile.setPhone(savedArticleDto.getPhone());
            profile.setSurname(savedArticleDto.getSurname());
            profile.setRole(savedArticleDto.getRole());
            profile.setStatus(savedArticleDto.getStatus());
            profile.setVisible(savedArticleDto.getVisible());
            profile.setPhotoId(savedArticleDto.getPhotoId());
            profile.setCreateData(savedArticleDto.getCreateData());

            Profile save = profileRepo.save(profile);

            Article article = new Article();
            article.setTitle(savedArticleDto.getTitle());
            article.setContent(savedArticleDto.getContent());
            article.setDescription(savedArticleDto.getDescription());
            article.setImageId(savedArticleDto.getImageId());
            article.setModeratorId(savedArticleDto.getModeratorId());
            article.setPublishedDate(savedArticleDto.getPublishedDate());
            article.setPublisherId(savedArticleDto.getPublisherId());
            article.setStatus(savedArticleDto.getStatus());
            article.setSharedCount(savedArticleDto.getSharedCount());
            article.setCreateDate(savedArticleDto.getCreateDate());
            article.setViewCount(savedArticleDto.getViewCount());
            article.setVisible(savedArticleDto.getVisible());

            Region region = new Region();
            region.setNameUz(savedArticleDto.getNameUz());
            region.setNameRu(savedArticleDto.getNameRu());
            region.setNameEn(savedArticleDto.getNameEn());
            region.setCreatedDate(savedArticleDto.getCreatedDate());
            region.setVisible(savedArticleDto.getVisible());
            region.setOrderNumber(savedArticleDto.getOrderNumber());

            Region save1 = regionRepo.save(region);
            article.setRegionId((List<Region>) save1);

            comment.setArticleId(article);

            comment.setProfileId(save);
            comment.setUpdatedDate(savedArticleDto.getUpdatedDate());
            comment.setVisible(savedArticleDto.getVisible());

            commentRepo.save(comment);
            savedArticle.setCommentId(comment);
            savedArticle.setProfileId(profile);

            savedArticleRepo.save(savedArticle);
            return new Result(true, "Saved article successfully updated");
        }
        return new Result(false, "Saved article not found");
    }

    public Result delete(Long id) {
        savedArticleRepo.deleteById(id);
        return new Result(true, "Saved article successfully deleted");
    }

}
