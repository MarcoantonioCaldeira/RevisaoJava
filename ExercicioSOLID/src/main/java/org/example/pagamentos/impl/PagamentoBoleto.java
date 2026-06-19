package org.example.pagamentos.impl;

import org.example.acoes.ResultadoPagamento;
import org.example.pagamentos.MetodoPagamento;
import org.example.taxas.Impl.TaxaBoleto;

public class PagamentoBoleto implements MetodoPagamento {

    private final TaxaBoleto taxaBoleto;

    public PagamentoBoleto(TaxaBoleto taxaBoleto) {
        this.taxaBoleto = taxaBoleto;
    }

    @Override
    public ResultadoPagamento processar(double valor) {
        double valorComTaxa = taxaBoleto.calcular(valor);
        String transacaoId = "BOL-" + System.currentTimeMillis();

        return new ResultadoPagamento.Builder(true, "Boleto gerado")
                .transacaoId(transacaoId)
                .valorFinal(valorComTaxa)
                .build();
    }
}
