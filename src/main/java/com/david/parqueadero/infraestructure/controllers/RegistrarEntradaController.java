package com.david.parqueadero.infraestructure.controllers;

import com.david.parqueadero.application.services.RegistrarEntradaService;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parqueos")
public class RegistrarEntradaController {
    private final RegistrarEntradaService registrarEntradaService;

    public RegistrarEntradaController(RegistrarEntradaController registrarSalidaService, RegistrarEntradaService registrarEntradaService) {
        this.registrarEntradaService = registrarEntradaService;
    }

    @PostMapping("/entrada")
    public ResponseEntity<Void> registrarEntrada(
            @RequestParam String placa,
            @RequestParam TipoVehiculo tipoVehiculo
    ) {
        registrarEntradaService.registrarEntrada(placa, tipoVehiculo);
        return ResponseEntity.ok().build();
    }
}
