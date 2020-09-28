package com.hm.backend.unit.service;

import com.hm.backend.Utils;
import com.hm.backend.dao.Sector;
import com.hm.backend.dto.InvolvementDto;
import com.hm.backend.exception.IncorrectFormDataException;
import com.hm.backend.service.ValidationService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTests {

    @Test
    public void whenInvolvementDtoHasBlankUsername_thenThrowException() {
        InvolvementDto involvementDto = new InvolvementDto("", true, new ArrayList<>());

        ValidationService service = new ValidationService();
        assertThatThrownBy(() -> service.validate(involvementDto))
            .isInstanceOf(IncorrectFormDataException.class)
            .hasMessage("Users must enter a name!");
    }

    @Test
    public void whenInvolvementDtoHasUsername_thenDoNotThrowException() throws IncorrectFormDataException {
        InvolvementDto involvementDto = new InvolvementDto(
            "some-name",
            true,
            Arrays.asList(1L)
        );

        ValidationService service = new ValidationService();
        service.validate(involvementDto);
    }

    @Test
    public void whenInvolvementDtoHasFalseIsAgreed_thenThrowException() {
        InvolvementDto involvementDto = new InvolvementDto(
            "some-name",
            false,
            Arrays.asList(1L)
        );

        ValidationService service = new ValidationService();
        assertThatThrownBy(() -> service.validate(involvementDto))
            .isInstanceOf(IncorrectFormDataException.class)
            .hasMessage("Users must agree to the ToS!");
    }

    @Test
    public void whenInvolvementDtoHasTrueIsAgreed_thenDoNotThrowException() throws IncorrectFormDataException {
        InvolvementDto involvementDto = new InvolvementDto(
            "some-name",
            true,
            Arrays.asList(1L)
        );

        ValidationService service = new ValidationService();
        service.validate(involvementDto);
    }

    @Test
    public void whenInvolvementDtoHasZeroSector_thenThrowException() {
        InvolvementDto involvementDto = new InvolvementDto(
            "some-name",
            true,
            new ArrayList<>()
        );

        ValidationService service = new ValidationService();
        assertThatThrownBy(() -> service.validate(involvementDto))
            .isInstanceOf(IncorrectFormDataException.class)
            .hasMessage("Users must select at least one sector!");
    }

    @Test
    public void whenInvolvementDtoHasOneOrMoreSector_thenDoNotThrowException() throws IncorrectFormDataException {
        InvolvementDto involvementDto = new InvolvementDto(
            "some-name",
            true,
            Arrays.asList(1L)
        );

        ValidationService service = new ValidationService();
        service.validate(involvementDto);
    }

    @Test
    public void whenAtOneOrSectorHasAtLeastOneChildren_thenThrowException() {
        Sector leafSector = Utils.getLeafSector();
        Sector branchSector = Utils.getBranchSector();
        List<Sector> sectors = Arrays.asList(leafSector, branchSector);

        ValidationService service = new ValidationService();
        assertThatThrownBy(() -> service.validate(sectors))
            .isInstanceOf(IncorrectFormDataException.class)
            .hasMessage("Air is not a selectable sector!");
    }

    @Test
    public void whenAllSectorsHasZeroChildren_thenDoNotThrowException() throws IncorrectFormDataException {
        Sector leafSector = Utils.getLeafSector();
        List<Sector> sectors = Arrays.asList(leafSector, leafSector);

        ValidationService service = new ValidationService();
        service.validate(sectors);
    }
}
