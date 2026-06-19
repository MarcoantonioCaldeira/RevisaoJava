package org.example.taxas.Impl;

import org.example.taxas.CalculadoraTaxa;

public class TaxaBoleto implements CalculadoraTaxa {
    @Override
    public double calcular(double valorBase) {
        return valorBase + 2.50;
    }
}
