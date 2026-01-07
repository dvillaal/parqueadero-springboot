package com.david.parqueadero.infraestructure.services;

import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import com.david.parqueadero.domain.port.out.ParqueoRepositoryPort;
import com.david.parqueadero.infraestructure.repositories.JpaParqueoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ParqueoService implements ParqueoRepositoryPort {
    private final JpaParqueoRepository jpaParqueoRepository;

    public ParqueoService(JpaParqueoRepository jpaParqueoRepository) {
        this.jpaParqueoRepository = jpaParqueoRepository;
    }

    @Override
    public int contarVehiculosPorTipo(TipoVehiculo tipoVehiculo) {
        return jpaParqueoRepository.countByVehiculoTipo(tipoVehiculo);
    }

    @Override
    public Optional<Parqueo> buscarActivoPorPlaca(String placa) {
        return jpaParqueoRepository.findByVehiculo_PlacaAndHoraSalidaIsNull(placa);
    }

    @Override
    public void guardarParqueo(Parqueo parqueo) {
        jpaParqueoRepository.save(parqueo);
    }

    @Override
    public List<Parqueo> obtenerParqueosActivos() {
        return jpaParqueoRepository.findByHoraSalidaIsNull();
    }
}
