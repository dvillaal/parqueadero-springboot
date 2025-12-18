package com.david.parqueadero.application.usecases.RegistrarEntrada;

import com.david.parqueadero.domain.model.Parqueadero;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import com.david.parqueadero.domain.port.out.ParqueoRepositoryPort;

public class RevisarDisponibilidadUseCase {
    private final ParqueoRepositoryPort parqueoRepositoryPort;
    private final Parqueadero parqueadero;

    public RevisarDisponibilidadUseCase(ParqueoRepositoryPort parqueoRepositoryPort, Parqueadero parqueadero) {
        this.parqueoRepositoryPort = parqueoRepositoryPort;
        this.parqueadero = parqueadero;
    }

    public void revisarDisponibilidad(TipoVehiculo tipo) {
        int ocupados = parqueoRepositoryPort.contarVehiculosPorTipo(tipo);
        int capacidadMaxima;

        if (tipo == TipoVehiculo.CARRO) {
            capacidadMaxima = parqueadero.getCapacidadMaximaCarros();
        } else {
            capacidadMaxima = parqueadero.getCapacidadMaximaMotos();
        }

        if (ocupados >= capacidadMaxima) {
            throw new IllegalStateException("No hay disponibilidad para el tipo de vehículo: " + tipo);
        }
    }
}
