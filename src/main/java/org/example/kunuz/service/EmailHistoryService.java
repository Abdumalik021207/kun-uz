package org.example.kunuz.service;

import org.example.kunuz.dto.EmailHistoryDto;
import org.example.kunuz.model.EmailHistory;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.EmailHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailHistoryService {

    @Autowired
    EmailHistoryRepo emailHistoryRepo;

    public List<EmailHistory> findAll() {
        return emailHistoryRepo.findAll();
    }

    public EmailHistory findById(Long id) {
        return emailHistoryRepo.findById(id).get();
    }

    public Result create(EmailHistoryDto emailHistoryDto) {
        EmailHistory emailHistory = new EmailHistory();
        emailHistory.setCreatedDate(emailHistoryDto.getCreatedDate());
        emailHistory.setEmail(emailHistoryDto.getEmail());
        emailHistory.setMessage(emailHistoryDto.getMessage());
        emailHistoryRepo.save(emailHistory);
        return new Result(true, "Email History created successfully");
    }

    public Result update(EmailHistoryDto emailHistoryDto, Long id) {
        Optional<EmailHistory> byId = emailHistoryRepo.findById(id);
        if (byId.isPresent()) {
            EmailHistory emailHistory = byId.get();
            emailHistory.setEmail(emailHistoryDto.getEmail());
            emailHistory.setMessage(emailHistoryDto.getMessage());
            emailHistory.setCreatedDate(emailHistoryDto.getCreatedDate());
            emailHistoryRepo.save(emailHistory);
            return new Result(true, "Email History updated successfully");
        }
        return new Result(false, "Email History not found");
    }

    public Result delete(Long id) {
        emailHistoryRepo.deleteById(id);
        return new Result(true, "EmailHistory deleted sucessfully");
    }

}
