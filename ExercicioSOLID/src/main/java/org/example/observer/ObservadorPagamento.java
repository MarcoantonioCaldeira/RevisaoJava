package org.example.observer;

import org.example.acoes.ResultadoPagamento;

public interface ObservadorPagamento {
    void aoProcessar(ResultadoPagamento resultado);
}
