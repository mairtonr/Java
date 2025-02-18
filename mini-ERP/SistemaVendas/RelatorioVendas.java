package SistemaVendas;

import java.util.ArrayList;
import java.util.List;

public class RelatorioVendas {
    private List<Pedido> pedidos;

    public RelatorioVendas() {
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void gerarRelatorio() {
        System.out.println("---- Relatório de Vendas ----");
        double totalVendas = 0.0;
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
            totalVendas += pedido.getValorTotal();
        }
        System.out.println("Total de Vendas: R$ " + totalVendas);
    }
}