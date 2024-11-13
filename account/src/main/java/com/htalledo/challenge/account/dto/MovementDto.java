package com.htalledo.challenge.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

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
    @NonNull
    private String movementType;
    @NonNull
    private Double value;

    private Long accountId;
}
