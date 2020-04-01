package br.com.milvusartis.ecommerce.model.bo;


public interface IBO<T, S> {

    public S parseToDTO(T pojo);

    public T parseToPOJO(S dto);

}
