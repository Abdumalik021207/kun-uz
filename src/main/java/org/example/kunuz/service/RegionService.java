package org.example.kunuz.service;

import org.example.kunuz.dto.RegionDto;
import org.example.kunuz.model.Region;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    RegionRepo regionRepo;

    public List<Region> findAll() {
        return regionRepo.findAll();
    }

    public Region findById(Long id) {
        return regionRepo.findById(id).get();
    }

    public Result create(RegionDto regionDto) {
        Region region = new Region();
        region.setCreatedDate(regionDto.getCreatedDate());
        region.setVisible(regionDto.getVisible());
        region.setOrderNumber(regionDto.getOrderNumber());
        region.setNameUz(regionDto.getNameUz());
        region.setNameRu(regionDto.getNameRu());
        region.setNameEn(regionDto.getNameEn());
        regionRepo.save(region);
        return new Result(true,"Region created successfully");
    }

    public Result update(RegionDto regionDto, Long id) {
        Optional<Region> byId = regionRepo.findById(id);
        if (byId.isPresent()) {
            Region region = byId.get();
            region.setCreatedDate(regionDto.getCreatedDate());
            region.setVisible(regionDto.getVisible());
            region.setOrderNumber(regionDto.getOrderNumber());
            region.setNameUz(regionDto.getNameUz());
            region.setNameRu(regionDto.getNameRu());
            region.setNameEn(regionDto.getNameEn());
            regionRepo.save(region);
            return new Result(true,"Region updated successfully");
        }
        return new Result(false,"Region not found");
    }

    public Result delete(Long id) {
        regionRepo.deleteById(id);
        return new Result(true,"Region deleted successfully");
    }

}
