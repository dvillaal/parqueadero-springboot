package com.david.parqueadero.domain.useCases.ObtenerParqueosActivos;

import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.port.out.ParqueoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObtenerParqueosActivosUseCase {
    private final ParqueoRepositoryPort parqueoRepositoryPort;

    public ObtenerParqueosActivosUseCase(ParqueoRepositoryPort parqueoRepositoryPort) {
        this.parqueoRepositoryPort = parqueoRepositoryPort;
    }

    public List<Parqueo> obtenerParqueosActivos() {
        return parqueoRepositoryPort.obtenerParqueosActivos();
    }
}
