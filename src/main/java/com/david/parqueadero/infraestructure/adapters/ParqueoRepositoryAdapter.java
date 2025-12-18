package com.david.parqueadero.infraestructure.adapters;

import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import com.david.parqueadero.domain.port.out.ParqueoRepositoryPort;
import com.david.parqueadero.infraestructure.repositories.JpaParqueoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ParqueoRepositoryAdapter implements ParqueoRepositoryPort {
    private final JpaParqueoRepository jpaRepository;

    public ParqueoRepositoryAdapter(JpaParqueoRepository jpaParqueoRepository) {
        this.jpaRepository = jpaParqueoRepository;
    }

    @Override
    public int contarVehiculosPorTipo(TipoVehiculo tipoVehiculo) {
        return jpaRepository.contarVehiculosPorTipo(tipoVehiculo);
    }

    @Override
    public Optional<Parqueo> buscarActivoPorPlaca(String placa) {
        return jpaRepository.buscarActivoPorPlaca(placa);
    }

    @Override
    public void guardarParqueo(Parqueo parqueo) {
        jpaRepository.save(parqueo);
    }
}
