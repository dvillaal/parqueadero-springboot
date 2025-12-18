package com.david.parqueadero.infraestructure.controllers;

import com.david.parqueadero.application.services.RegistrarSalidaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parqueos")
public class RegistrarSalidaController {

    private final RegistrarSalidaService registrarSalidaService;

    public RegistrarSalidaController(RegistrarSalidaService registrarSalidaService) {
        this.registrarSalidaService = registrarSalidaService;
    }

    @PostMapping("/salida")
    public ResponseEntity<Void> registrarSalida(
            @RequestParam String placa
    ) {
        registrarSalidaService.registrarSalida(placa);
        return ResponseEntity.ok().build();
    }


    }
}
