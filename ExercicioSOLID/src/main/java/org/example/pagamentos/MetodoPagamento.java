package org.example.pagamentos;

import org.example.acoes.ResultadoPagamento;

public interface MetodoPagamento {

    ResultadoPagamento processar(double valor);
}
