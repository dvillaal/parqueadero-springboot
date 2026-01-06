package com.david.parqueadero.infraestructure.handlers;

import com.david.parqueadero.domain.useCases.RegistrarSalida.RegistrarSalidaUseCase;
import org.springframework.stereotype.Component;

@Component
public class RegistrarSalidaHandler {
    private final RegistrarSalidaUseCase registrarSalidaUseCase;

    public RegistrarSalidaHandler(RegistrarSalidaUseCase registrarSalidaUseCase) {
        this.registrarSalidaUseCase = registrarSalidaUseCase;
    }

    public void handle(String placa) {
        registrarSalidaUseCase.registrarSalida(placa);
    }
}
