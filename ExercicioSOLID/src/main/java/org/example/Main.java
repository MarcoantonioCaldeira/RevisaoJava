package org.example;

import org.example.acoes.ProcessadorPagamento;
import org.example.acoes.ResultadoPagamento;
import org.example.acoes.ValidarPagamento;
import org.example.observer.ObservadorPagamento;
import org.example.observer.impl.AuditoriaObservador;
import org.example.observer.impl.EmailObservador;
import org.example.observer.impl.LogObservador;
import org.example.pagamentos.ValidadorPagamento;
import org.example.pagamentos.impl.PagamentoBoleto;
import org.example.pagamentos.impl.PagamentoCartaoCredito;
import org.example.pagamentos.impl.PagamentoPix;
import org.example.taxas.Impl.TaxaBoleto;
import org.example.taxas.Impl.TaxaCartao;
import org.example.taxas.Impl.TaxaPix;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //observadores reutilizaveis. Nessa parte do codigo é criada uma lista com três observadores reutilizaveis dentro
        List<ObservadorPagamento> observadores = Arrays.asList( //declaração do tipo da lista
                new LogObservador(),
                new EmailObservador(),
                new AuditoriaObservador()
        );
        //Criamos todos os objetos na mesma lista porque todos tem o mesmo tipo que é ObservadorPagamento, mas o real comportamento vai ser decidido em runtime. Esse é o conceito de polimorfismo

        //Processameto dos pagamentos
        ProcessadorPagamento processadorPagamento = new ProcessadorPagamento(
                new PagamentoCartaoCredito(new TaxaCartao()),
                new ValidarPagamento(),
                observadores
        );
        ResultadoPagamento r1 = processadorPagamento.executar(1000.0);
        System.out.println("Resultado: " + r1);

        System.out.println("\n===== PAGAMENTO PIX =====");
        ProcessadorPagamento processadorPix = new ProcessadorPagamento(
                new PagamentoPix(new TaxaPix()),
                new ValidarPagamento(),
                observadores
        );
        ResultadoPagamento r2 = processadorPix.executar(500.0);
        System.out.println("Resultado: " + r2);

        // ===== Pagamento 3 — Boleto =====
        System.out.println("\n===== PAGAMENTO BOLETO =====");
        ProcessadorPagamento processadorBoleto = new ProcessadorPagamento(
                new PagamentoBoleto(new TaxaBoleto()),
                new ValidarPagamento(),
                observadores
        );
        ResultadoPagamento r3 = processadorBoleto.executar(300.0);
        System.out.println("Resultado: " + r3);

        // ===== Pagamento 4 — Inválido (valor negativo) =====
        System.out.println("\n===== PAGAMENTO INVÁLIDO =====");
        ResultadoPagamento r4 = processadorPix.executar(-100.0);
        System.out.println("Resultado: " + r4);


    }
}