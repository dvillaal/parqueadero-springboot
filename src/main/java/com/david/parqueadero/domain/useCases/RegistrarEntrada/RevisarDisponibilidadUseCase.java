package com.david.parqueadero.domain.useCases.RegistrarEntrada;

import com.david.parqueadero.application.config.ParqueaderoConfig;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import com.david.parqueadero.domain.port.out.ParqueoRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class RevisarDisponibilidadUseCase {
    private final ParqueoRepositoryPort parqueoRepositoryPort;
    private final ParqueaderoConfig config;

    public RevisarDisponibilidadUseCase(ParqueoRepositoryPort parqueoRepositoryPort, ParqueaderoConfig config) {
        this.parqueoRepositoryPort = parqueoRepositoryPort;
        this.config = config;
    }

    public void revisarDisponibilidad(TipoVehiculo tipo) {
        int ocupados = parqueoRepositoryPort.contarVehiculosPorTipo(tipo);
        int capacidadMaxima;

        if (tipo == TipoVehiculo.CARRO) {
            capacidadMaxima = config.getCapacidadCarros();
        } else {
            capacidadMaxima = config.getCapacidadMotos();
        }

        if (ocupados >= capacidadMaxima) {
            throw new IllegalStateException("No hay disponibilidad para el tipo de vehículo: " + tipo);
        }
    }
}
