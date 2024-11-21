package org.example.kunuz.service;

import org.example.kunuz.dto.CommentDto;
import org.example.kunuz.model.*;
import org.example.kunuz.repository.ArticleRepo;
import org.example.kunuz.repository.CommentRepo;
import org.example.kunuz.repository.ProfileRepo;
import org.example.kunuz.repository.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    ArticleRepo articleRepo;

    @Autowired
    RegionRepo regionRepo;

    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    public Comment findById(Long id) {
        return commentRepo.findById(id).get();
    }

    public Result create(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setCreatedDate(commentDto.getCreatedDate());
        comment.setReplyId(commentDto.getReplyId());
        Profile profile = new Profile();
        profile.setName(commentDto.getName());
        profile.setEmail(commentDto.getEmail());
        profile.setPhone(commentDto.getPhone());
        profile.setSurname(commentDto.getSurname());
        profile.setRole(commentDto.getRole());
        profile.setStatus(commentDto.getStatus());
        profile.setVisible(commentDto.getVisible());
        profile.setPhotoId(commentDto.getPhotoId());
        profile.setCreateData(commentDto.getCreateData());

        Profile save = profileRepo.save(profile);

        Article article = new Article();
        article.setTitle(commentDto.getTitle());
        article.setContent(commentDto.getContent());
        article.setDescription(commentDto.getDescription());
        article.setImageId(commentDto.getImageId());
        article.setModeratorId(commentDto.getModeratorId());
        article.setPublishedDate(commentDto.getPublishedDate());
        article.setPublisherId(commentDto.getPublisherId());
        article.setStatus(commentDto.getStatus());
        article.setSharedCount(commentDto.getSharedCount());
        article.setCreateDate(commentDto.getCreateDate());
        article.setViewCount(commentDto.getViewCount());
        article.setVisible(commentDto.getVisible());

        Region region = new Region();
        region.setNameUz(commentDto.getNameUz());
        region.setNameRu(commentDto.getNameRu());
        region.setNameEn(commentDto.getNameEn());
        region.setCreatedDate(commentDto.getCreatedDate());
        region.setVisible(commentDto.getVisible());
        region.setOrderNumber(commentDto.getOrderNumber());

        Region save1 = regionRepo.save(region);
        article.setRegionId((List<Region>) save1);

        comment.setArticleId(article);

        comment.setProfileId(save);
        comment.setUpdatedDate(commentDto.getUpdatedDate());
        comment.setVisible(commentDto.getVisible());

        commentRepo.save(comment);
        return new Result(true,"Comment has been created successfully");
    }

    public Result update(CommentDto commentDto, Long id) {
        Optional<Comment> byId = commentRepo.findById(id);
        if (byId.isPresent()) {
            Comment comment = byId.get();
            comment.setContent(commentDto.getContent());
            comment.setCreatedDate(commentDto.getCreatedDate());
            comment.setReplyId(commentDto.getReplyId());

            Profile profile = new Profile();
            profile.setName(commentDto.getName());
            profile.setEmail(commentDto.getEmail());
            profile.setPhone(commentDto.getPhone());
            profile.setSurname(commentDto.getSurname());
            profile.setRole(commentDto.getRole());
            profile.setStatus(commentDto.getStatus());
            profile.setVisible(commentDto.getVisible());
            profile.setPhotoId(commentDto.getPhotoId());
            profile.setCreateData(commentDto.getCreateData());

            Profile save = profileRepo.save(profile);
            comment.setProfileId(save);

            Article article = new Article();
            article.setTitle(commentDto.getTitle());
            article.setContent(commentDto.getContent());
            article.setDescription(commentDto.getDescription());
            article.setImageId(commentDto.getImageId());
            article.setModeratorId(commentDto.getModeratorId());
            article.setPublishedDate(commentDto.getPublishedDate());
            article.setPublisherId(commentDto.getPublisherId());
            article.setStatus(commentDto.getStatus());
            article.setSharedCount(commentDto.getSharedCount());
            article.setCreateDate(commentDto.getCreateDate());
            article.setViewCount(commentDto.getViewCount());
            article.setVisible(commentDto.getVisible());

            Region region = new Region();
            region.setNameUz(commentDto.getNameUz());
            region.setNameRu(commentDto.getNameRu());
            region.setNameEn(commentDto.getNameEn());
            region.setCreatedDate(commentDto.getCreatedDate());
            region.setVisible(commentDto.getVisible());
            region.setOrderNumber(commentDto.getOrderNumber());

            Region save1 = regionRepo.save(region);
            article.setRegionId((List<Region>) save1);

            comment.setArticleId(article);

            comment.setUpdatedDate(commentDto.getUpdatedDate());
            comment.setVisible(commentDto.getVisible());
            commentRepo.save(comment);
            return new Result(true,"Comment has been updated successfully");
        }
        return new Result(false,"Comment not found");
    }

    public Result delete(Long id) {
        commentRepo.deleteById(id);
        return new Result(true,"Comment has been deleted");
    }

}
