package com.hm.backend.service;

import com.hm.backend.dao.Sector;
import com.hm.backend.repository.SectorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectorService {
    SectorRepository sectorRepo;

    public SectorService(SectorRepository sectorRepo) {
        this.sectorRepo = sectorRepo;
    }

    public Optional<Sector> get(Long id) {
        return sectorRepo.findById(id);
    }
}
