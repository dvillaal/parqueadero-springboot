package com.david.parqueadero.infraestructure.handlers;

import com.david.parqueadero.domain.useCases.RegistrarSalida.RegistrarSalidaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistrarSalidaHandler {
    private final RegistrarSalidaUseCase registrarSalidaUseCase;

    public void handle(String placa) {
        registrarSalidaUseCase.registrarSalida(placa);
    }
}
