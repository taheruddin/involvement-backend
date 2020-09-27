package com.hm.backend.controller;

import com.hm.backend.dao.Involvement;
import com.hm.backend.dto.InvolvementDto;
import com.hm.backend.exception.IncorrectFormDataException;
import com.hm.backend.service.InvolvementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/involvements")
public class InvolvementController {
    private InvolvementService involvementService;

    InvolvementController(InvolvementService involvementService) {
        this.involvementService = involvementService;
    }

    @GetMapping("")
    public List<Involvement> getAll() {
        return involvementService.getAll();
    }

    @GetMapping("/{id}")
    public Involvement getAll(@PathVariable Long id) throws IncorrectFormDataException {
        return involvementService.get(id);
    }

    @PostMapping("")
    public Involvement create(@RequestBody InvolvementDto involvementDto) throws IncorrectFormDataException {
        return involvementService.create(involvementDto);
    }

    @PutMapping("/{id}")
    public Involvement updateSectors(@PathVariable final Long id, @RequestBody final InvolvementDto involvementDto) throws IncorrectFormDataException {
        return involvementService.update(id, involvementDto);
    }
}
