package org.example.kunuz.service;

import org.example.kunuz.dto.CommentLikeDto;
import org.example.kunuz.model.CommentLike;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.CommentLikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentLikeService {

    @Autowired
    CommentLikeRepo commentLikeRepo;

    public List<CommentLike> getAllCommentLike() {
        return commentLikeRepo.findAll();
    }

    public CommentLike getById(Long id) {
        return commentLikeRepo.findById(id).get();
    }

    public Result save(CommentLikeDto commentLikeDto) {
        CommentLike commentLike = new CommentLike();
        commentLike.setStatus(commentLikeDto.getStatus());
        commentLike.setCreatedDate(commentLikeDto.getCreatedDate());
        commentLikeRepo.save(commentLike);
        return new Result(true,"Comment Like saved successfully");
    }

    public Result update(CommentLikeDto commentLikeDto, Long id) {
        Optional<CommentLike> byId = commentLikeRepo.findById(id);
        if (byId.isPresent()) {
            CommentLike commentLike = byId.get();
            commentLike.setStatus(commentLikeDto.getStatus());
            commentLike.setCreatedDate(commentLikeDto.getCreatedDate());
            commentLikeRepo.save(commentLike);
            return new Result(true,"Comment Like updated successfully");
        }
        return new Result(false,"Comment Like not found");
    }

    public Result delete(Long id) {
        commentLikeRepo.deleteById(id);
        return new Result(true,"Comment Like deleted successfully");
    }

}
