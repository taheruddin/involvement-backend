package com.hm.backend.unit.service;

import com.hm.backend.dao.Involvement;
import com.hm.backend.dao.Sector;
import com.hm.backend.dto.InvolvementDto;
import com.hm.backend.exception.IncorrectFormDataException;
import com.hm.backend.repository.InvolvementRepository;
import com.hm.backend.repository.SectorRepository;
import com.hm.backend.service.InvolvementService;
import com.hm.backend.service.ValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
public class InvolvementTests {

    @Mock
    InvolvementRepository involvementRepo;

    @Mock
    SectorRepository sectorRepo;

    @Mock
    ValidationService validationService;

    Sector rootSector, branchSector, leafSector;

    @Test
    public void whenGetMethodCalled_thenRepositoryMethodFindByIdCalled() throws IncorrectFormDataException {
        Involvement involvement = new Involvement("Max", true, new ArrayList<>());
        doReturn(Optional.of(involvement)).when(involvementRepo).findById(1L);

        InvolvementService service = new InvolvementService(involvementRepo, sectorRepo, validationService);
        Involvement returnedInvolvement = service.get(1L);

        verify(involvementRepo).findById(1L);
        assertEquals(involvement.getUsername(), returnedInvolvement.getUsername());
    }

    @Test
    public void whenGetMethodCalledWithNonExistentId_thenRepositoryMethodFindByIdCalledAndThrowException() {
        doReturn(Optional.ofNullable(null)).when(involvementRepo).findById(1L);

        InvolvementService service = new InvolvementService(involvementRepo, sectorRepo, validationService);
        assertThatThrownBy(() -> service.get(1L))
            .isInstanceOf(IncorrectFormDataException.class)
            .hasMessage("No involvement with id=1 exists!");

        verify(involvementRepo).findById(1L);
    }

    @Test
    public void whenCreateMethodCalled_thenRepositoryMethodSaveCalled() throws IncorrectFormDataException {
        reloadSectors();

        Involvement involvement = new Involvement("Max", true, Arrays.asList(leafSector));
        doReturn(involvement).when(involvementRepo).save(any(Involvement.class));

        InvolvementDto involvementDto = new InvolvementDto("Max", true, Arrays.asList(3L));
        doReturn(Arrays.asList(leafSector)).when(sectorRepo).findAllById(Arrays.asList(3L));

        doNothing().when(validationService).validate(any(InvolvementDto.class));
        doNothing().when(validationService).validate(anyList());

        InvolvementService service = new InvolvementService(involvementRepo, sectorRepo, validationService);
        Involvement returnedInvolvement = service.create(involvementDto);

        verify(involvementRepo).save(any(Involvement.class));
        assertEquals(involvement.getUsername(), returnedInvolvement.getUsername());
    }

    @Test
    public void whenCreateMethodCalledValidationOfInvolvementDtoFails_thenThrowException() throws IncorrectFormDataException {
        reloadSectors();

        InvolvementDto involvementDto = new InvolvementDto("Max", true, Arrays.asList(3L));
        doThrow(new IncorrectFormDataException("incorrect")).when(validationService).validate(any(InvolvementDto.class));

        InvolvementService service = new InvolvementService(involvementRepo, sectorRepo, validationService);
        assertThatThrownBy(() -> service.create(involvementDto))
            .isInstanceOf(IncorrectFormDataException.class)
            .hasMessage("incorrect");

        verify(validationService).validate(any(InvolvementDto.class));
        verifyNoInteractions(sectorRepo);
        verifyNoInteractions(involvementRepo);
    }

    @Test
    public void whenCreateMethodCalledValidationOfSectorsIdsFails_thenThrowException() throws IncorrectFormDataException {
        reloadSectors();

        InvolvementDto involvementDto = new InvolvementDto("Max", true, Arrays.asList(3L));
        doNothing().when(validationService).validate(any(InvolvementDto.class));
        doReturn(Arrays.asList(leafSector)).when(sectorRepo).findAllById(Arrays.asList(3L));
        doThrow(new IncorrectFormDataException("incorrect")).when(validationService).validate(anyList());

        InvolvementService service = new InvolvementService(involvementRepo, sectorRepo, validationService);
        assertThatThrownBy(() -> service.create(involvementDto))
            .isInstanceOf(IncorrectFormDataException.class)
            .hasMessage("incorrect");

        verify(validationService).validate(any(InvolvementDto.class));
        verify(sectorRepo).findAllById(eq(Arrays.asList(3L)));
        verifyNoInteractions(involvementRepo);
    }

    @Test
    public void whenUpdateMethodCalled_thenRepositoryMethodSaveCalled() throws IncorrectFormDataException {
        reloadSectors();

        Involvement involvement = new Involvement(9L, "Max", true, Arrays.asList(leafSector));
        doReturn(Optional.of(involvement)).when(involvementRepo).findById(eq(9L));
        doReturn(involvement).when(involvementRepo).save(any(Involvement.class));

        InvolvementDto involvementDto = new InvolvementDto("Max", true, Arrays.asList(3L));
        doReturn(Arrays.asList(leafSector)).when(sectorRepo).findAllById(Arrays.asList(3L));
        doNothing().when(validationService).validate(anyList());

        InvolvementService service = new InvolvementService(involvementRepo, sectorRepo, validationService);
        Involvement returnedInvolvement = service.update(9L, involvementDto);

        verify(involvementRepo).save(any(Involvement.class));
        assertEquals(involvement.getUsername(), returnedInvolvement.getUsername());
    }

    @Test
    public void whenUpdateMethodCalledAndInvolvementRepoReturnedOptionalNull_thenThrownException() {
        reloadSectors();

        InvolvementDto involvementDto = new InvolvementDto("Max", true, Arrays.asList(3L));
        doReturn(Optional.ofNullable(null)).when(involvementRepo).findById(eq(9L));

        InvolvementService service = new InvolvementService(involvementRepo, sectorRepo, validationService);
        assertThatThrownBy(() -> service.update(9L, involvementDto))
            .isInstanceOf(IncorrectFormDataException.class)
            .hasMessage("No involvement with id=9 exists!");

        verify(involvementRepo).findById(9L);
    }

    @Test
    public void whenUpdateMethodCalledAndSectorValidationFailed_thenThrownException() throws IncorrectFormDataException {
        reloadSectors();

        Involvement involvement = new Involvement(9L,"Max", true, Arrays.asList(leafSector));
        doReturn(Optional.of(involvement)).when(involvementRepo).findById(eq(9L));

        InvolvementDto involvementDto = new InvolvementDto("Max", true, Arrays.asList(3L));
        doReturn(Arrays.asList(leafSector)).when(sectorRepo).findAllById(Arrays.asList(3L));
        doThrow(new IncorrectFormDataException("incorrect")).when(validationService).validate(anyList());

        InvolvementService service = new InvolvementService(involvementRepo, sectorRepo, validationService);
        assertThatThrownBy(() -> service.update(9L, involvementDto))
            .isInstanceOf(IncorrectFormDataException.class)
            .hasMessage("incorrect");

        verify(involvementRepo).findById(9L);
        verify(validationService).validate(anyList());
    }

    private void reloadSectors() {
        rootSector = new Sector(1L, "Air", null, null);
        branchSector = new Sector(2L, "Air", rootSector, null);
        leafSector = new Sector(3L, "Air", branchSector, new ArrayList<>());
        rootSector.setChildren(Arrays.asList(branchSector));
        branchSector.setChildren(Arrays.asList(leafSector));
    }
}
