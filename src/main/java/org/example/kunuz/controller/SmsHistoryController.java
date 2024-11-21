package org.example.kunuz.controller;

import org.example.kunuz.dto.SmsHistoryDto;
import org.example.kunuz.model.Result;
import org.example.kunuz.model.SmsHistory;
import org.example.kunuz.service.SmsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smsHistory")
public class SmsHistoryController {

    @Autowired
    SmsHistoryService smsHistoryService;

    @GetMapping
    public List<SmsHistory> getSmsHistory() {
        return smsHistoryService.findAll();
    }

    @GetMapping("/{id}")
    public SmsHistory getSmsHistoryById(@PathVariable Long id) {
        return smsHistoryService.findById(id);
    }

    @PostMapping("/{id}")
    public Result saveSmsHistory(@RequestBody SmsHistoryDto smsHistoryDto) {
        return smsHistoryService.create(smsHistoryDto);
    }

    @PutMapping("/{id}")
    public Result updateSmsHistory(@RequestBody SmsHistoryDto smsHistoryDto, @PathVariable Long id) {
        return smsHistoryService.update(smsHistoryDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteSmsHistoryById(@PathVariable Long id) {
        return smsHistoryService.delete(id);
    }

}
