package org.example.kunuz.controller;

import org.example.kunuz.dto.AttachDto;
import org.example.kunuz.model.Attach;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attach")
public class AttachController {

    @Autowired
    AttachService attachService;

    @GetMapping
    public List<Attach> getAttachList() {
        return attachService.findAll();
    }

    @GetMapping("/{id}")
    public Attach getAttach(@PathVariable Long id) {
        return attachService.findById(id);
    }

    @PostMapping
    public Result addAttach(@RequestBody AttachDto attachDto) {
        return attachService.create(attachDto);
    }

    @PutMapping("/{id}")
    public Result updateAttach(@PathVariable Long id, @RequestBody AttachDto attachDto) {
        return attachService.update(attachDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteAttach(@PathVariable Long id) {
        return attachService.delete(id);
    }

}
