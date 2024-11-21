package org.example.kunuz.repository;

import org.example.kunuz.model.EmailHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailHistoryRepo extends JpaRepository<EmailHistory, Long> {
}
