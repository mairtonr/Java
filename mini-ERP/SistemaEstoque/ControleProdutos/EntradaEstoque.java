package ControleProdutos;
import GerenciamentoDeProdutos.*;
/**
 * Representa uma entrada de produtos no estoque.
 */
public class EntradaEstoque extends MovimentacaoEstoque {

    public EntradaEstoque(int idProduto, int quantidade) {
        super(idProduto, quantidade);
    }
    
    @Override
    public String getTipoMovimentacao() {
        return "ENTRADA DE ESTOQUE";
    }
}
