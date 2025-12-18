package com.david.parqueadero.infraestructure.repositories;

import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaParqueoRepository extends JpaRepository<Parqueo, UUID> {
    Optional<Parqueo> buscarActivoPorPlaca(String placa);

    int contarVehiculosPorTipo(TipoVehiculo tipoVehiculo);
}
