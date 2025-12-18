package com.david.parqueadero.domain.port.out;

import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;

import java.util.Optional;

public interface ParqueoRepositoryPort {
    int contarVehiculosPorTipo(TipoVehiculo tipoVehiculo);

    Optional<Parqueo> buscarActivoPorPlaca(String placa);

    void guardarParqueo(Parqueo parqueo);
}
