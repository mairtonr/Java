package ControleProdutos;
import GerenciamentoDeProdutos.*;
/**
 * Representa uma saída de produtos do estoque.
 */
public class SaidaEstoque extends MovimentacaoEstoque {
    
    public SaidaEstoque(int idProduto, int quantidade) {
            super(idProduto, quantidade);
        }
    
        @Override
    public String getTipoMovimentacao() {
        return "SAIDA DE ESTOQUE";
    }
}
