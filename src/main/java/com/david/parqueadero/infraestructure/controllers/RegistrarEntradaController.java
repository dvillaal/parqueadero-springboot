package com.david.parqueadero.infraestructure.controllers;

import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import com.david.parqueadero.infraestructure.handlers.RegistrarEntradaHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/parqueadero")
public class RegistrarEntradaController {
    private final RegistrarEntradaHandler registrarEntradaHandler;

    public RegistrarEntradaController(RegistrarEntradaHandler registrarEntradaHandler) {
        this.registrarEntradaHandler = registrarEntradaHandler;
    }

    @PostMapping("/entrada")
    public ResponseEntity<Void> registrarEntrada(
            @RequestBody Map<String, String> body
    ) {
        registrarEntradaHandler.handle(body.get("placa"), TipoVehiculo.valueOf(body.get("tipoVehiculo")));
        return ResponseEntity.ok().build();
    }
}
