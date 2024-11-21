package org.example.kunuz.service;

import org.example.kunuz.dto.ProfileDto;
import org.example.kunuz.model.Profile;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo profileRepo;

    public List<Profile> findAll() {
        return profileRepo.findAll();
    }

    public Profile findById(Long id) {
        return profileRepo.findById(id).get();
    }

    public Result create(ProfileDto profileDto) {

        boolean exists = profileRepo.existsByEmailAndPhone(profileDto.getEmail(), profileDto.getPhone());
        if (exists) {
            return new Result(false,"Email already exists");
        }

        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setEmail(profileDto.getEmail());
        profile.setPhone(profileDto.getPhone());
        profile.setSurname(profileDto.getSurname());
        profile.setRole(profileDto.getRole());
        profile.setStatus(profileDto.getStatus());
        profile.setVisible(profileDto.getVisible());
        profile.setPhotoId(profileDto.getPhotoId());
        profile.setCreateData(profileDto.getCreateData());
        profileRepo.save(profile);
        return new Result(true,"Profile created successfully");
    }

    public Result update(ProfileDto profileDto, Long id) {
        Optional<Profile> byId = profileRepo.findById(id);
        if (byId.isPresent()) {
            Profile profile = byId.get();
            profile.setName(profileDto.getName());
            profile.setEmail(profileDto.getEmail());
            profile.setPhone(profileDto.getPhone());
            profile.setSurname(profileDto.getSurname());
            profile.setRole(profileDto.getRole());
            profile.setStatus(profileDto.getStatus());
            profile.setVisible(profileDto.getVisible());
            profile.setPhotoId(profileDto.getPhotoId());
            profile.setCreateData(profileDto.getCreateData());
            profileRepo.save(profile);
            return new Result(true,"Profile updated successfully");
        }
        return new Result(false,"Profile not found");
    }

    public Result delete(Long id) {
        profileRepo.deleteById(id);
        return new Result(true,"Profile deleted successfully");
    }

}
