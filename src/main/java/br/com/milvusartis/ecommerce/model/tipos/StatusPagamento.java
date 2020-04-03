package br.com.milvusartis.ecommerce.model.tipos;

public enum StatusPagamento {
    AGUARDANDO_PAGAMENTO("AGUARDANDO_PAGAMENTO"),
    PAGAMENTO_APROVADO("PAGAMENTO_APROVADO"),
    PAGAMENTO_REPROVADO("PAGAMENTO_REPROVADO");

    private String StatusPagamento;

    private StatusPagamento(String statusPagamento) {
        this.StatusPagamento = statusPagamento;
    }

}