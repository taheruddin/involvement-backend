package com.hm.backend.integration;

import com.hm.backend.dao.Sector;
import com.hm.backend.repository.InvolvementRepository;
import com.hm.backend.repository.SectorRepository;
import com.hm.backend.service.SectorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SectorRepositoryTest {

    @Autowired
    private SectorService sectorService;

    @Autowired
    private SectorRepository sectorRepo;

    @Autowired
    private InvolvementRepository involvementRepo;

    @Test
    void whenAskedForAllSectors_thenAllSectorsAreReturned() {
        List<Sector> all = sectorRepo.findAll();
        assertEquals(80, all.size());
    }

    @Test
    void whenAskedForRootSector_thenReturnedRootSelector() {
        Optional<Sector> root = sectorService.get(1L);
        assertEquals("ROOT", root.get().getTitle());
    }
}
