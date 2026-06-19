package org.example.taxas.Impl;

import org.example.taxas.CalculadoraTaxa;

public class TaxaCartao implements CalculadoraTaxa {
    @Override
    public double calcular(double valorBase) {
        return valorBase * 1.03;
    }
}
