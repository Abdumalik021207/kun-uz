package org.example.kunuz.controller;

import org.example.kunuz.dto.EmailHistoryDto;
import org.example.kunuz.model.EmailHistory;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.EmailHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emailhistory")
public class EmailHistoryController {

    @Autowired
    EmailHistoryService emailHistoryService;

    @GetMapping
    public List<EmailHistory> getEmailHistory() {
        return emailHistoryService.findAll();
    }

    @GetMapping("/{id}")
    public EmailHistory getById(@PathVariable Long id) {
        return emailHistoryService.findById(id);
    }

    @PostMapping
    public Result createEmailHistory(@RequestBody EmailHistoryDto emailHistory) {
        return emailHistoryService.create(emailHistory);
    }

    @PutMapping("/{id}")
    public Result updateEmailHistory(@PathVariable Long id, @RequestBody EmailHistoryDto emailHistory) {
        return emailHistoryService.update(emailHistory, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteEmailHistory(@PathVariable Long id) {
        return emailHistoryService.delete(id);
    }

}
