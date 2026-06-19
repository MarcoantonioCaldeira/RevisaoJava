package org.example.observer.impl;

import org.example.acoes.ResultadoPagamento;

public class LogObservador implements org.example.observer.ObservadorPagamento {
    @Override
    public void aoProcessar(ResultadoPagamento resultado) {
        System.out.println("[LOG] Pagmento processando: "
        + resultado.getTransacaoId()
        + " | Sucesso: " + resultado.getSucesso());
    }
}
