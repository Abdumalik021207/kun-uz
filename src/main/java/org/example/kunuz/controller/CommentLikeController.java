package org.example.kunuz.controller;

import org.example.kunuz.dto.CommentLikeDto;
import org.example.kunuz.model.CommentLike;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.CommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentlike")
public class CommentLikeController {

    @Autowired
    CommentLikeService commentLikeService;

    @GetMapping
    public List<CommentLike> getCommentLike() {
        return commentLikeService.getAllCommentLike();
    }

    @GetMapping("/{id}")
    public CommentLike getCommentLike(@PathVariable Long id) {
        return commentLikeService.getById(id);
    }

    @PostMapping
    public Result addCommentLike(@RequestBody CommentLikeDto commentLikeDto) {
        return commentLikeService.save(commentLikeDto);
    }

    @PutMapping("/{id}")
    public Result updateCommentLike(@PathVariable Long id, @RequestBody CommentLikeDto commentLikeDto) {
        return commentLikeService.update(commentLikeDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteCommentLike(@PathVariable Long id) {
        return commentLikeService.delete(id);
    }

}
