package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.entity.PedidoItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO {

    private String nome;
    private String email;
    private String telefone;
    private String assunto;
    private String mensagem;

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        final StringBuilder sb = new StringBuilder();
        sb.append("Nome: ");
        sb.append(getNome());
        sb.append("\n");
        sb.append("Email: ");
        sb.append(getEmail());
        sb.append("\n");
        sb.append("Telefone: ");
        sb.append(getTelefone());
        sb.append("\n");
        sb.append("Assunto: ");
        sb.append(getAssunto());
        sb.append("\n");
        sb.append("Mensagem: ");
        sb.append(getMensagem());

        return sb.toString();
    }

}