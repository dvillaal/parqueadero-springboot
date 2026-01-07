package com.david.parqueadero.infraestructure.controllers;

import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import com.david.parqueadero.infraestructure.handlers.ParqueaderoHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/parqueadero")
public class ParqueaderoController {
    private final ParqueaderoHandler parqueaderoHandler;

    public ParqueaderoController(ParqueaderoHandler parqueaderoHandler) {
        this.parqueaderoHandler = parqueaderoHandler;
    }

    @PostMapping("/entrada")
    public ResponseEntity<Void> registrarEntrada(
            @RequestBody Map<String, String> body
    ) {
        parqueaderoHandler.registrarEntrada(body.get("placa"), TipoVehiculo.valueOf(body.get("tipoVehiculo")));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/salida")
    public ResponseEntity<Void> registrarSalida(
            @RequestBody Map<String, String> body
    ) {
        parqueaderoHandler.registrarSalida(body.get("placa"));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/activos")
    public ResponseEntity<?> obtenerParqueosActivos() {
        return ResponseEntity.ok(parqueaderoHandler.obtenerParqueosActivos());
    }
}
