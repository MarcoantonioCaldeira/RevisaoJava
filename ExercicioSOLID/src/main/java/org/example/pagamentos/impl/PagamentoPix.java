package org.example.pagamentos.impl;

import org.example.acoes.ResultadoPagamento;
import org.example.pagamentos.MetodoPagamento;
import org.example.taxas.Impl.TaxaPix;

public class PagamentoPix implements MetodoPagamento {

    private final TaxaPix taxaPix;

    public PagamentoPix(TaxaPix taxaPix) {
        this.taxaPix = taxaPix;
    }

    @Override
    public ResultadoPagamento processar(double valor) {
        double valorTaxa = taxaPix.calcular(valor);
        String transacaoid = "PIX-" + System.currentTimeMillis();

        return new ResultadoPagamento.Builder(true, "Pix geito com sucesso")
                .transacaoId(transacaoid)
                .valorFinal(valorTaxa)
                .build();
    }
}
