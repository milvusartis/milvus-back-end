package br.com.milvusartis.ecommerce.model.tipos;

public enum Regra {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private String role;

    private Regra (String role){
        this.role = role;
    }
}
