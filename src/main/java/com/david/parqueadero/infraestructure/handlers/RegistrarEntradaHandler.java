package com.david.parqueadero.infraestructure.handlers;

import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import com.david.parqueadero.domain.useCases.RegistrarEntrada.RegistrarEntradaUseCase;
import org.springframework.stereotype.Component;

@Component
public class RegistrarEntradaHandler {
    private final RegistrarEntradaUseCase registrarEntradaUseCase;

    public RegistrarEntradaHandler(RegistrarEntradaUseCase registrarEntradaUseCase) {
        this.registrarEntradaUseCase = registrarEntradaUseCase;
    }

    public void handle(String placa, TipoVehiculo tipoVehiculo) {
        registrarEntradaUseCase.registrarEntrada(placa, tipoVehiculo);
    }
}
