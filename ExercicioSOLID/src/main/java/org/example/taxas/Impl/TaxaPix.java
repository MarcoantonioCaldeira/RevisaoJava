package org.example.taxas.Impl;

import org.example.taxas.CalculadoraTaxa;

public class TaxaPix implements CalculadoraTaxa {
    @Override
    public double calcular(double valorBase) {
        return valorBase;
    }
}
