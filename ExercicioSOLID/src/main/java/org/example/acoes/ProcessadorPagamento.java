package org.example.acoes;

import org.example.exceptions.PagamentoInvalidoException;
import org.example.observer.ObservadorPagamento;
import org.example.pagamentos.MetodoPagamento;
import org.example.pagamentos.ValidadorPagamento;

import java.util.List;

public class ProcessadorPagamento {

    private final MetodoPagamento metodoPagamento;

    private final ValidadorPagamento validadorPagamento;

    private final List<ObservadorPagamento> observadores;

    public ProcessadorPagamento(MetodoPagamento metodoPagamento, ValidadorPagamento validadorPagamento, List<ObservadorPagamento> observadores ){
        this.metodoPagamento = metodoPagamento;
        this.validadorPagamento = validadorPagamento;
        this.observadores = observadores;
    }


    public ResultadoPagamento executar(double valor) {
        ResultadoPagamento resultadoPagamento;

        try {
            validadorPagamento.validar(valor); //Primeiro vou validar o pagamento

            resultadoPagamento = metodoPagamento.processar(valor); //Apos a validação vira o processamento

        } catch (PagamentoInvalidoException e) { //Se der erro ira cair na excessão personalizada

            resultadoPagamento = new ResultadoPagamento.Builder(false, e.getMessage())
                    .build();
        }

        //Notifica a todos os observadores (sucesso ou falha)
        for (ObservadorPagamento observador : observadores) {
            observador.aoProcessar(resultadoPagamento);
        }

        return resultadoPagamento;
    }

}
