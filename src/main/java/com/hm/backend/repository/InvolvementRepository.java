package com.hm.backend.repository;

import com.hm.backend.dao.Involvement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvolvementRepository extends JpaRepository<Involvement, Long> {
}
