package GerenciamentoDeProdutos;
/**
 * Classe abstrata que representa uma movimentação de estoque.
 */
public abstract class MovimentacaoEstoque {
    private int idProduto;
    protected int quantidade;

    public MovimentacaoEstoque(int idProduto, int quantidade) {
        this.setIdProduto(idProduto);
        this.quantidade = quantidade;

    }

    public abstract String getTipoMovimentacao();

    
    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

    public int getIdProduto() {return idProduto;}
    public void setIdProduto(int idProduto) {this.idProduto = idProduto;}


    @Override
    public String toString() {
        return getTipoMovimentacao() + "\nID: " + getIdProduto() + "\nQuantidade: " + quantidade + "\n\n";
    }
}
