package org.example.acoes;

import org.example.exceptions.PagamentoInvalidoException;
import org.example.pagamentos.ValidadorPagamento;

public class ValidarPagamento implements ValidadorPagamento {
    @Override
    public void validar(double valor) {
        if(valor <= 0) {
            throw new PagamentoInvalidoException("Valor deve ser positovo: " + valor);
        }
        if(valor > 50000){
            throw new PagamentoInvalidoException("Valor excede o limite permitido: " + valor);
        }
    }
}
