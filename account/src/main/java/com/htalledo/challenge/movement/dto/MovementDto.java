package com.htalledo.challenge.movement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovementDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 29893893L;

    private Long id;
    private Date date;
    private String movementType;
    private Double value;

    private Long accountId;
}
