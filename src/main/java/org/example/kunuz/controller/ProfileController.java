package org.example.kunuz.controller;

import org.example.kunuz.dto.ProfileDto;
import org.example.kunuz.model.Profile;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping
    public List<Profile> getProfiles() {
        return profileService.findAll();
    }

    @GetMapping("/{id}")
    public Profile getProfiles(@PathVariable Long id) {
        return profileService.findById(id);
    }

    @PostMapping
    public Result addProfile(@RequestBody ProfileDto profileDto) {
        return profileService.create(profileDto);
    }

    @PutMapping("/{id}")
    public Result updateProfile(@PathVariable Long id, @RequestBody ProfileDto profileDto) {
        return profileService.update(profileDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteProfile(@PathVariable Long id) {
        return profileService.delete(id);
    }

}
