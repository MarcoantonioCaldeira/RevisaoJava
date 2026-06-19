package org.example.observer.impl;

import org.example.acoes.ResultadoPagamento;
import org.example.observer.ObservadorPagamento;

public class EmailObservador implements ObservadorPagamento {
    @Override
    public void aoProcessar(ResultadoPagamento resultado) {
        if (resultado.getSucesso()) {
            System.out.println("[EMAIL] Enviando confirmação para o cliente: "
                    + resultado.getMensagem());
        } else {
            System.out.println("[EMAIL] Enviando aviso de falha: "
                    + resultado.getMensagem());
        }
    }
}
