package org.example.kunuz.service;

import org.example.kunuz.dto.AttachDto;
import org.example.kunuz.model.Attach;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.AttachRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachService {

    @Autowired
    AttachRepo attachRepo;

    public List<Attach> findAll() {
        return attachRepo.findAll();
    }

    public Attach findById(Long id) {
        return attachRepo.findById(id).get();
    }

    public Result create(AttachDto attachDto) {
        Attach attach = new Attach();
        attach.setCreatedDate(attachDto.getCreatedDate());
        attach.setSize(attachDto.getSize());
        attach.setPath(attachDto.getPath());
        attach.setExtension(attachDto.getExtension());
        attach.setOriginalName(attachDto.getOriginalName());
        attachRepo.save(attach);
        return new Result(true,"Attach created successfully");
    }

    public Result update(AttachDto attachDto, Long id) {
        Optional<Attach> byId = attachRepo.findById(id);
        if (byId.isPresent()) {
            Attach attach = byId.get();
            attach.setSize(attachDto.getSize());
            attach.setPath(attachDto.getPath());
            attach.setExtension(attachDto.getExtension());
            attach.setOriginalName(attachDto.getOriginalName());
            attach.setCreatedDate(attachDto.getCreatedDate());
            attachRepo.save(attach);
            return new Result(true,"Attach updated successfully");
        }
        return new Result(false,"Attach not found");
    }

    public Result delete(Long id) {
        attachRepo.deleteById(id);
        return new Result(true,"Attach deleted successfully");
    }

}
