package com.hm.backend.service;

import com.hm.backend.dao.Sector;
import com.hm.backend.dto.InvolvementDto;
import com.hm.backend.exception.IncorrectFormDataException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationService {

    public void validate(final InvolvementDto involvementDto) throws IncorrectFormDataException {
        if (!involvementDto.getIsAgreed())
            throw new IncorrectFormDataException("Users must agree to the ToS!");
        if (involvementDto.getUsername().length() == 0)
            throw new IncorrectFormDataException("Users must enter a name!");
        if (involvementDto.getSectors().size() == 0)
            throw new IncorrectFormDataException("Users must select at least one sector!");
    }

    public void validate(final List<Sector> sectors) throws IncorrectFormDataException {
        final IncorrectFormDataException incorrectException = sectors.stream()
            .filter(sector -> sector.getChildren().size() > 0)
            .findFirst()
            .map(sector -> new IncorrectFormDataException(sector.getTitle() + " is not a selectable sector!"))
            .orElseGet(() -> null);

        if (incorrectException != null) throw incorrectException;
    }
}
