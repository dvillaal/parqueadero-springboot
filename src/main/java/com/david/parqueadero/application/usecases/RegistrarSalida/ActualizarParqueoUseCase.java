package com.david.parqueadero.application.usecases.RegistrarSalida;

import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.port.out.ParqueoRepositoryPort;

public class ActualizarParqueoUseCase {
    private final ParqueoRepositoryPort parqueoRepositoryPort;

    public ActualizarParqueoUseCase(ParqueoRepositoryPort parqueoRepositoryPort) {
        this.parqueoRepositoryPort = parqueoRepositoryPort;
    }

    public void actualizarParqueo(Parqueo parqueo) {
        parqueoRepositoryPort.guardarParqueo(parqueo);
    }
}