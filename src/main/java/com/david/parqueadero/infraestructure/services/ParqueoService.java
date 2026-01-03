package com.david.parqueadero.infraestructure.services;

import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import com.david.parqueadero.domain.port.out.ParqueoRepositoryPort;
import com.david.parqueadero.infraestructure.repositories.JpaParqueoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ParqueoService implements ParqueoRepositoryPort {
    private final JpaParqueoRepository jpaRepository;

    public ParqueoService(JpaParqueoRepository jpaParqueoRepository) {
        this.jpaRepository = jpaParqueoRepository;
    }

    @Override
    public int contarVehiculosPorTipo(TipoVehiculo tipoVehiculo) {
        return jpaRepository.countByVehiculoTipo(tipoVehiculo);
    }

    @Override
    public Optional<Parqueo> buscarActivoPorPlaca(String placa) {
        return jpaRepository.findByVehiculo_PlacaAndHoraSalidaIsNull(placa);
    }

    @Override
    public void guardarParqueo(Parqueo parqueo) {
        jpaRepository.save(parqueo);
    }
}
