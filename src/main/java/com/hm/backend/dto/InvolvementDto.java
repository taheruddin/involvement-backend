package com.hm.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvolvementDto {
    private String username;
    private Boolean isAgreed;
    private List<Long> sectors;
}
