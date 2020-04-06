package br.com.milvusartis.ecommerce.service.gatway;

public class GatewayPagamento {

    public void confirmaPagamento() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(5000);
        System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));

    }
}
