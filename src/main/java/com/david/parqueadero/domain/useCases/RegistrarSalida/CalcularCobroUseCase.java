package com.david.parqueadero.domain.useCases.RegistrarSalida;

import com.david.parqueadero.config.ParqueaderoConfig;
import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalcularCobroUseCase {
    private final ParqueaderoConfig config;

    public CalcularCobroUseCase(ParqueaderoConfig config) {
        this.config = config;
    }

    public BigDecimal calcularCobro(Parqueo parqueo, long horasEstacionamiento) {
        BigDecimal cobro;
        if (parqueo.getVehiculo().getTipo() == TipoVehiculo.CARRO) {
            cobro = config.getTarifaCarro().multiply(BigDecimal.valueOf(horasEstacionamiento));
        } else {
            cobro = config.getTarifaMoto().multiply(BigDecimal.valueOf(horasEstacionamiento));
        }
        return cobro;
    }
}
