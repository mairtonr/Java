package SistemaVendas;

import GerenciamentoDeProdutos.*;
import MonitoramentoNiveisProdutos.Estoque;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ControleProdutos.SaidaEstoque;

public class Pedido {
    
    private int idPedido;
    private String cliente;
    private List<ItemPedido> itens;
    private double valorTotal;

    public Pedido(int idPedido, String cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);
        valorTotal += produto.getPrecoProduto() * quantidade;
    }

    public void salvarPedidoEmArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pedidos.txt", true))) {
            // Salva os dados do pedido
            writer.write("Pedido ID: " + idPedido + ", Cliente: " + cliente + ", Valor Total: R$ " + valorTotal);
            writer.newLine();

            // Salva os itens do pedido
            writer.write("Itens:");
            writer.newLine();
            for (ItemPedido item : itens) {
                writer.write("- " + item.getProduto().getNomeProduto() + ", Quantidade: " + item.getQuantidade() + ", Valor Unitário: R$ " + item.getProduto().getPrecoProduto());
                writer.newLine();
            }

            writer.write("-------------------------");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar pedido: " + e.getMessage());
        }
    }

    public void finalizarPedido(Estoque estoque) {
        for (ItemPedido item : itens) {
            SaidaEstoque saida = new SaidaEstoque(item.getProduto().getIdProduto(), item.getQuantidade());
            estoque.registrarMovimentacao(saida);
        }
        System.out.println("Pedido finalizado com sucesso!");
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() { // deixe esse metodo menos robusto
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido ID: ").append(idPedido).append("\n");
        sb.append("Cliente: ").append(cliente).append("\n");
        sb.append("Itens:\n");
        for (ItemPedido item : itens) {
            sb.append(item).append("\n");
        }
        sb.append("Valor Total: R$ ").append(valorTotal).append("\n");
        return sb.toString();
    }
}
