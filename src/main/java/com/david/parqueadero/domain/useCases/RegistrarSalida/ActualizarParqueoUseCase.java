package com.david.parqueadero.domain.useCases.RegistrarSalida;

import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.port.out.ParqueoRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class ActualizarParqueoUseCase {
    private final ParqueoRepositoryPort parqueoRepositoryPort;

    public ActualizarParqueoUseCase(ParqueoRepositoryPort parqueoRepositoryPort) {
        this.parqueoRepositoryPort = parqueoRepositoryPort;
    }

    public void actualizarParqueo(Parqueo parqueo) {
        parqueoRepositoryPort.guardarParqueo(parqueo);
    }
}