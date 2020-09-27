package com.hm.backend.unit.service;

import com.hm.backend.dao.Sector;
import com.hm.backend.repository.SectorRepository;
import com.hm.backend.service.SectorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SectorTests {

    @Mock
    SectorRepository sectorRepo;

    @Test
    public void whenGetMethodCalled_thenRepositoryMethodFindByIdCalled() {
        Sector sector = new Sector("Air");
        doReturn(Optional.of(sector)).when(sectorRepo).findById(eq(1L));

        SectorService service = new SectorService(sectorRepo);
        Sector returnedSector = service.get(1L).get();

        verify(sectorRepo).findById(eq(1L));
        assertEquals(sector.getTitle(), returnedSector.getTitle());
    }
}
