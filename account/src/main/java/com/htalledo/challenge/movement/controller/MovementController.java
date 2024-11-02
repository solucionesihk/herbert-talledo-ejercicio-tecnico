package com.htalledo.challenge.movement.controller;

import com.htalledo.challenge.movement.dto.MovementDto;
import com.htalledo.challenge.movement.service.MovementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimientos")
public class MovementController {

    private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @PostMapping
    public ResponseEntity<Object> registrarMovimiento(@RequestBody MovementDto movementDto) throws Exception {
        try {
            MovementDto newMovement = movementService.registerMovement(movementDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(newMovement);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocurrió un error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementDto> obtenerMovimiento(@PathVariable Long id) {
        MovementDto movementDto = movementService.getMovementById(id);
        return ResponseEntity.ok(movementDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable Long id) {
        movementService.deleteMovement(id);
        return ResponseEntity.noContent().build();
    }
}

