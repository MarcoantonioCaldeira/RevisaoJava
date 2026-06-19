package org.example.observer.impl;

import org.example.acoes.ResultadoPagamento;
import org.example.observer.ObservadorPagamento;

public class AuditoriaObservador implements ObservadorPagamento {
    @Override
    public void aoProcessar(ResultadoPagamento resultado) {
        System.out.println("[AUDITORIA] Registrando transação "
                + resultado.getTransacaoId()
                + " no valor de R$" + resultado.getValorFinal());
    }
}