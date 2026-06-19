package org.example.acoes;

public class ResultadoPagamento {

    private final Boolean sucesso; //obraigatorio
    private final String transacaoId;
    private final double valorFinal;
    private final String mensagem; //obrigatorio

    private ResultadoPagamento(Builder builder) {
        this.sucesso = builder.sucesso;
        this.transacaoId = builder.transacaoId;
        this.valorFinal = builder.valorFinal;
        this.mensagem = builder.mensagem;
    }

    public Boolean getSucesso() {
        return sucesso;
    }

    public String getTransacaoId() {
        return transacaoId;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "ResultadoPagamento{" +
                "sucesso=" + sucesso +
                ", transacaoId='" + transacaoId + '\'' +
                ", valorFinal=" + valorFinal +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }

    public static class Builder {

        private final Boolean sucesso;
        private String transacaoId = ""; //Não obrigatorios com um valor pradrão definido
        private double valorFinal = 0.0; //Valor pradrão definido
        private final String mensagem;

        public Builder(Boolean sucesso, String mensagem){
            this.sucesso = sucesso;
            this.mensagem = mensagem;
        }

        public Builder transacaoId(String transacaoId){
            this.transacaoId = transacaoId;
            return this;
        }

        public Builder valorFinal(double valorFinal){
            this.valorFinal = valorFinal;
            return this;
        }

        public ResultadoPagamento build() {
            return new ResultadoPagamento(this);
        }
    }
}
