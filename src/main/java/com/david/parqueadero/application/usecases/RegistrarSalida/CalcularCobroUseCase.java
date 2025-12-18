package com.david.parqueadero.application.usecases.RegistrarSalida;

import com.david.parqueadero.domain.model.Parqueadero;
import com.david.parqueadero.domain.model.Parqueo;
import com.david.parqueadero.domain.model.enums.TipoVehiculo;

import java.math.BigDecimal;

public class CalcularCobroUseCase {
    private final Parqueadero parqueadero;

    public CalcularCobroUseCase(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public BigDecimal calcularCobro(Parqueo parqueo, long horasEstacionamiento) {
        BigDecimal cobro;
        if (parqueo.getVehiculo().getTipo() == TipoVehiculo.CARRO) {
            cobro = parqueadero.getTarifaCarroPorHora().multiply(BigDecimal.valueOf(horasEstacionamiento));
        } else {
            cobro = parqueadero.getTarifaMotoPorHora().multiply(BigDecimal.valueOf(horasEstacionamiento));
        }
        return cobro;
    }
}
