package com.david.parqueadero.domain.model;

import java.math.BigDecimal;

public class Parqueadero {
    private final int capacidadMaximaCarros;
    private final int capacidadMaximaMotos;
    private final BigDecimal tarifaCarroPorHora;
    private final BigDecimal tarifaMotoPorHora;

    public Parqueadero(int capacidadMaximaCarros, int capacidadMaximaMotos, BigDecimal tarifaCarroPorHora, BigDecimal tarifaMotoPorHora) {
        this.capacidadMaximaCarros = capacidadMaximaCarros;
        this.capacidadMaximaMotos = capacidadMaximaMotos;
        this.tarifaCarroPorHora = tarifaCarroPorHora;
        this.tarifaMotoPorHora = tarifaMotoPorHora;
    }

    public int getCapacidadMaximaCarros() {
        return capacidadMaximaCarros;
    }

    public int getCapacidadMaximaMotos() {
        return capacidadMaximaMotos;
    }

    public BigDecimal getTarifaCarroPorHora() {
        return tarifaCarroPorHora;
    }

    public BigDecimal getTarifaMotoPorHora() {
        return tarifaMotoPorHora;
    }
}
