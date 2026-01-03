package com.david.parqueadero.infraestructure.controllers;

import com.david.parqueadero.infraestructure.handlers.RegistrarSalidaHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/parqueadero")
public class RegistrarSalidaController {

    private final RegistrarSalidaHandler registrarSalidaHandler;

    public RegistrarSalidaController(RegistrarSalidaHandler registrarSalidaHandler) {
        this.registrarSalidaHandler = registrarSalidaHandler;
    }

    @PostMapping("/salida")
    public ResponseEntity<Void> registrarSalida(
            @RequestBody Map<String, String> body
    ) {
        registrarSalidaHandler.handle(body.get("placa"));
        return ResponseEntity.ok().build();
    }
}
