package com.hm.backend.controller;

import com.hm.backend.dao.Sector;
import com.hm.backend.repository.SectorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/sectors")
public class SectorController {
    SectorRepository sectorRepo;

    SectorController(SectorRepository sectorRepo) {
        this.sectorRepo = sectorRepo;
    }

    @GetMapping("/{id}")
    public Optional<Sector> get(@PathVariable  Long id) {
        return sectorRepo.findById(id);
    }
}
