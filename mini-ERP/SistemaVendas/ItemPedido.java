package SistemaVendas;

import GerenciamentoDeProdutos.Produto;

public class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return produto.getNomeProduto() + " - Quantidade: " + quantidade + " - Valor Unitário: R$ " + produto.getPrecoProduto();
    }
}