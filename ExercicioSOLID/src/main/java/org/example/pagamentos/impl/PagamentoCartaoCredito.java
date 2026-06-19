package org.example.pagamentos.impl;

import org.example.acoes.ResultadoPagamento;
import org.example.pagamentos.MetodoPagamento;
import org.example.taxas.Impl.TaxaCartao;

public class PagamentoCartaoCredito implements MetodoPagamento {

    private final TaxaCartao taxaCartao;

    public PagamentoCartaoCredito(TaxaCartao taxaCartao) {
        this.taxaCartao = taxaCartao;
    }

    @Override
    public ResultadoPagamento processar(double valor) {

        double valorComTaxa = taxaCartao.calcular(valor);
        String transacaoId ="CC-" + System.currentTimeMillis();

        return new ResultadoPagamento.Builder(true, "Pagamento gerado")
                .transacaoId(transacaoId)
                .valorFinal(valorComTaxa)
                .build();

    }
}
