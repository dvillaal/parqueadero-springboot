package com.david.parqueadero.infraestructure.handlers;

import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import com.david.parqueadero.domain.useCases.RegistrarEntrada.RegistrarEntradaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistrarEntradaHandler {
    private final RegistrarEntradaUseCase registrarEntradaUseCase;

    public void handle(String placa, TipoVehiculo tipoVehiculo) {
        registrarEntradaUseCase.registrarEntrada(placa, tipoVehiculo);
    }
}
