package org.example.kunuz.service;

import org.example.kunuz.dto.SmsHistoryDto;
import org.example.kunuz.model.Result;
import org.example.kunuz.model.SmsHistory;
import org.example.kunuz.repository.SmsHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmsHistoryService {

    @Autowired
    SmsHistoryRepo smsHistoryRepo;

    public List<SmsHistory> findAll() {
        return smsHistoryRepo.findAll();
    }

    public SmsHistory findById(Long id) {
        return smsHistoryRepo.findById(id).get();
    }

    public Result create(SmsHistoryDto smsHistoryDto) {
        SmsHistory smsHistory = new SmsHistory();
        smsHistory.setPhone(smsHistoryDto.getPhone());
        smsHistory.setMessage(smsHistoryDto.getMessage());
        smsHistory.setType(smsHistoryDto.getType());
        smsHistory.setStatus(smsHistoryDto.getStatus());
        smsHistory.setCreatedDate(smsHistoryDto.getCreatedDate());
        smsHistoryRepo.save(smsHistory);
        return new Result(true,"SmsHistory created successfully");
    }

    public Result update(SmsHistoryDto smsHistoryDto, Long id) {
        Optional<SmsHistory> byId = smsHistoryRepo.findById(id);
        if (byId.isPresent()) {
            SmsHistory smsHistory = byId.get();
            smsHistory.setPhone(smsHistoryDto.getPhone());
            smsHistory.setMessage(smsHistoryDto.getMessage());
            smsHistory.setType(smsHistoryDto.getType());
            smsHistory.setStatus(smsHistoryDto.getStatus());
            smsHistory.setCreatedDate(smsHistoryDto.getCreatedDate());
            smsHistoryRepo.save(smsHistory);
            return new Result(true,"SmsHistory updated successfully");
        }
        return new Result(false,"SmsHistory not found");
    }

    public Result delete(Long id) {
        smsHistoryRepo.deleteById(id);
        return new Result(true,"SmsHistory deleted successfully");
    }

}
