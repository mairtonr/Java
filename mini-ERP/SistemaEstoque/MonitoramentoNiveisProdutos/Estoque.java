
package MonitoramentoNiveisProdutos;

import ControleProdutos.EntradaEstoque;
import ControleProdutos.SaidaEstoque;
import GerenciamentoDeProdutos.MovimentacaoEstoque;
import GerenciamentoDeProdutos.Produto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.ArrayList;
import java.util.List;
/**
 * Classe responsável pelo gerenciamento do estoque e suas movimentações.
 */
public class Estoque {

    private List<Produto> produtos = new ArrayList<>();
    private List<MovimentacaoEstoque> movimentacoes = new ArrayList<>();
    
    /**
     * Adiciona um novo produto ao estoque.
     * @param produto Objeto Produto a ser adicionado
     */

    public void adicionarProduto(Produto produto) {
        if (produto.getQuantidadeProduto() < 0 || produto.getPrecoProduto() < 0) {
            System.out.println("Erro: Dados inválidos para o produto.");
            return;
        }
        produtos.add(produto);
        produto.salvarProdutoEmArquivo();
        System.out.println("Produto adicionado: " + produto.getNomeProduto() + "\n");
    }

    public Produto getProdutoPorId(int idProduto) {
        for (Produto p : produtos) {
            if (p.getIdProduto() == idProduto) {
                return p;
            }
        }
        System.out.println("Produto com ID " + idProduto + " não encontrado.");
        return null;
    }
    

    public void removerProduto(int idProduto){
        Produto produtoParaRemover = null;
            
        for (Produto p : produtos){
            if (p.getIdProduto() == idProduto) {
                produtoParaRemover = p;
                }
            }

            if (produtoParaRemover != null) {
                // Remover o produto da lista
                produtos.remove(produtoParaRemover);
                System.out.println("Produto " + produtoParaRemover.getNomeProduto() + " removido do estoque.");
    
                // Atualizar o arquivo com a remoção
                atualizarArquivoProdutos();
            } else {
                System.out.println("Produto não encontrado.");
            }
        }

    private void atualizarArquivoProdutos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("produtos.txt"))) {
            // Regravar todos os produtos restantes no arquivo
            for (Produto p : produtos) {
                writer.write(p.getIdProduto() + "," + p.getNomeProduto() + "," + p.getDescricaoProduto() + ","
                        + p.getQuantidadeProduto() + "," + p.getPrecoProduto() + "," + p.getEstoqueMinimo());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o arquivo de produtos: " + e.getMessage());
        }
    }

    /**
     * Registra uma movimentação no estoque, seja entrada ou saída.
     * @param movimentacao Objeto de movimentação de estoque
     */
    public void registrarMovimentacao(MovimentacaoEstoque movimentacao) {
        if (movimentacao.getQuantidade() <= 0) {
            System.out.println("Erro: Quantidade inválida para movimentação.");
            return;
        }

        for (Produto p : produtos) {
            if (p.getIdProduto() == movimentacao.getIdProduto()) {
                if (movimentacao instanceof EntradaEstoque) {
                    p.setQuantidadeProduto(p.getQuantidadeProduto() + movimentacao.getQuantidade());
                } else if (movimentacao instanceof SaidaEstoque) {
                    if (p.getQuantidadeProduto() >= movimentacao.getQuantidade()) {
                        p.setQuantidadeProduto(p.getQuantidadeProduto() - movimentacao.getQuantidade());
                    } else {
                        System.out.println("Erro: Estoque insuficiente para " + p.getNomeProduto());
                        return;
                    }
                }
                movimentacoes.add(movimentacao);
                System.out.println("Movimentação registrada: " + movimentacao.getTipoMovimentacao() + " de " + movimentacao.getQuantidade() + " unidades de " + p.getNomeProduto());
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }
    /**
     * Gera um relatório dos produtos cadastrados no estoque.
     */
    public void gerarRelatorio() {
        System.out.println("---- Relatório de Estoque ----\n");
        for (Produto p : produtos) {
            System.out.println(p);
        }
        
        System.out.println("---- Relatório de Movimentações ----");
        for (MovimentacaoEstoque m : movimentacoes){
            System.out.println(m);
        }

    }

    public void verificarEstoqueMinimo() {
        for (Produto p : produtos) {
            if (p.getQuantidadeProduto() < p.getEstoqueMinimo()) {
                System.out.println("ALERTA: Estoque mínimo atingido para o produto " + p.getNomeProduto());
            }
        }
    }
}
