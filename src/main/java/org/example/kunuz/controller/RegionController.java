package org.example.kunuz.controller;

import org.example.kunuz.dto.RegionDto;
import org.example.kunuz.model.Region;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    RegionService regionService;

    @GetMapping
    public List<Region> getRegions() {
        return regionService.findAll();
    }

    @GetMapping("/{id}")
    public Region getRegion(@PathVariable Long id) {
        return regionService.findById(id);
    }

    @PostMapping
    public Result addRegion(@RequestBody RegionDto regionDto) {
        return regionService.create(regionDto);
    }

    @PutMapping("/{id}")
    public Result updateRegion(@PathVariable Long id, @RequestBody RegionDto regionDto) {
        return regionService.update(regionDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteRegion(@PathVariable Long id) {
        return regionService.delete(id);
    }

}
