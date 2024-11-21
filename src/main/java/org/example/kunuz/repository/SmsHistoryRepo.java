package org.example.kunuz.repository;

import org.example.kunuz.model.SmsHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsHistoryRepo extends JpaRepository<SmsHistory, Long> {
    boolean existsByPhoneNumber(String phoneNumber);
}
