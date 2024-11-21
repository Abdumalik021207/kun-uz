package org.example.kunuz.controller;

import org.example.kunuz.dto.CommentDto;
import org.example.kunuz.model.Comment;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getComments() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @PostMapping
    public Result addComment(@RequestBody CommentDto commentDto) {
        return commentService.create(commentDto);
    }

    @PutMapping("/{id}")
    public Result updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto) {
        return commentService.update(commentDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteComment(@PathVariable Long id) {
        return commentService.delete(id);
    }
}
