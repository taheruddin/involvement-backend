package com.hm.backend.repository;

import com.hm.backend.dao.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector, Long> {
    Sector findFirstByTitle(String title);
}
