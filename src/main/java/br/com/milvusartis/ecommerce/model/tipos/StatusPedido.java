package br.com.milvusartis.ecommerce.model.tipos;

public enum StatusPedido {
    PEDIDO_REALIZADO("PEDIDO_REALIZADO"),
    PAGAMENTO_CONFIRMADO("PAGAMENTO_CONFIRMADO"),
    PEDIDO_ENVIADO("PEDIDO_ENVIADO"),
    PEDIDO_ENTREGUE("PEDIDO_ENTREGUE");

    private String descricao;

    private StatusPedido(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

