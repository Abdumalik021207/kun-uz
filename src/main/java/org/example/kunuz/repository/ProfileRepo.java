package org.example.kunuz.repository;

import org.example.kunuz.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Long> {

    boolean existsByEmailAndPhone(String email, String phone);

}
