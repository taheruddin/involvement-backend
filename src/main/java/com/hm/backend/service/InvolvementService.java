package com.hm.backend.service;

import com.hm.backend.dao.Involvement;
import com.hm.backend.dao.Sector;
import com.hm.backend.dto.InvolvementDto;
import com.hm.backend.exception.IncorrectFormDataException;
import com.hm.backend.repository.InvolvementRepository;
import com.hm.backend.repository.SectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvolvementService {
    private InvolvementRepository involvementRepo;
    private SectorRepository sectorRepo;
    private ValidationService validationService;

    public InvolvementService(
        InvolvementRepository involvementRepo,
        SectorRepository sectorRepo,
        ValidationService validationService
    ) {
        this.involvementRepo = involvementRepo;
        this.sectorRepo = sectorRepo;
        this.validationService = validationService;
    }

    public List<Involvement> getAll() {
        return involvementRepo.findAll();
    }

    public Involvement get(final Long id) throws IncorrectFormDataException {
        return involvementRepo.findById(id).orElseThrow(() ->
            new IncorrectFormDataException("No involvement with id=" + id + " exists!")
        );
    }

    public Involvement create(final InvolvementDto involvementDto) throws IncorrectFormDataException {
        validationService.validate(involvementDto);

        final List<Sector> sectors = sectorRepo.findAllById(involvementDto.getSectors());
        validationService.validate(sectors);

        return involvementRepo.save(new Involvement(
            involvementDto.getUsername(),
            true,
            sectors
        ));
    }

    public Involvement update(final Long id, final InvolvementDto involvementDto) throws IncorrectFormDataException {
        final List<Long> sectorsIds = involvementDto.getSectors();
        if (sectorsIds.size() == 0)
            throw new IncorrectFormDataException("Users must select at least one sector!");

        Involvement involvement = involvementRepo.findById(id)
            .orElseThrow(() -> new IncorrectFormDataException("No involvement with id=" + id + " exists!"));

        final List<Sector> sectors = sectorRepo.findAllById(sectorsIds);
        validationService.validate(sectors);

        involvement.setUsername(involvementDto.getUsername());
        involvement.setSectors(sectors);
        return involvementRepo.save(involvement);
    }

}
