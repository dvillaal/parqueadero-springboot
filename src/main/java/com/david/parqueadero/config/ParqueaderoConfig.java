package com.david.parqueadero.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@ConfigurationProperties(prefix = "parqueadero")
public class ParqueaderoConfig {
    private int capacidadCarros;
    private int capacidadMotos;

    private BigDecimal tarifaCarro;
    private BigDecimal tarifaMoto;

    public int getCapacidadCarros() {
        return capacidadCarros;
    }

    public void setCapacidadCarros(int capacidadCarros) {
        this.capacidadCarros = capacidadCarros;
    }

    public int getCapacidadMotos() {
        return capacidadMotos;
    }

    public void setCapacidadMotos(int capacidadMotos) {
        this.capacidadMotos = capacidadMotos;
    }

    public BigDecimal getTarifaCarro() {
        return tarifaCarro;
    }

    public void setTarifaCarro(BigDecimal tarifaCarro) {
        this.tarifaCarro = tarifaCarro;
    }

    public BigDecimal getTarifaMoto() {
        return tarifaMoto;
    }

    public void setTarifaMoto(BigDecimal tarifaMoto) {
        this.tarifaMoto = tarifaMoto;
    }
}
