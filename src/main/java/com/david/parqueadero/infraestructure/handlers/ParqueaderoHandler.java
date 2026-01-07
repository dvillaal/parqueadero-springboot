package com.david.parqueadero.infraestructure.handlers;

import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import com.david.parqueadero.domain.useCases.ObtenerParqueosActivos.ObtenerParqueosActivosUseCase;
import com.david.parqueadero.domain.useCases.RegistrarEntrada.RegistrarEntradaUseCase;
import com.david.parqueadero.domain.useCases.RegistrarSalida.RegistrarSalidaUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParqueaderoHandler {
    private final RegistrarEntradaUseCase registrarEntradaUseCase;
    private final RegistrarSalidaUseCase registrarSalidaUseCase;
    private final ObtenerParqueosActivosUseCase obtenerParqueosActivosUseCase;

    public ParqueaderoHandler(RegistrarEntradaUseCase registrarEntradaUseCase, RegistrarSalidaUseCase registrarSalidaUseCase, ObtenerParqueosActivosUseCase obtenerParqueosActivosUseCase) {
        this.registrarEntradaUseCase = registrarEntradaUseCase;
        this.registrarSalidaUseCase = registrarSalidaUseCase;
        this.obtenerParqueosActivosUseCase = obtenerParqueosActivosUseCase;
    }

    public void registrarEntrada(String placa, TipoVehiculo tipoVehiculo) {
        registrarEntradaUseCase.registrarEntrada(placa, tipoVehiculo);
    }

    public void registrarSalida(String placa) {
        registrarSalidaUseCase.registrarSalida(placa);
    }

    public List<Parqueo> obtenerParqueosActivos() {
        return obtenerParqueosActivosUseCase.obtenerParqueosActivos();
    }
}
