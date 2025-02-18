package GerenciamentoDeProdutos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Produto{
    private int idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private int quantidadeProduto;
    private double precoProduto;
    private int estoqueMinimo;

    public Produto(int idProduto, String nomeProduto, String descricaoProuto, int quantidadeProduto,
            double precoProduto, int estoqueMinimo) {
        this.idProduto = idProduto; 
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProuto;
        this.quantidadeProduto = quantidadeProduto;
        this.precoProduto = precoProduto;
        this.estoqueMinimo = estoqueMinimo;
    }

    public void salvarProdutoEmArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("produtos.txt", true))) {
            writer.write(this.idProduto + "," + this.nomeProduto + "," + this.descricaoProduto + ","
                    + this.quantidadeProduto + "," + this.precoProduto + "," + this.estoqueMinimo);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar produto: " + e.getMessage());
        }
    }

    @Override
    public String toString(){
        return "Produto " + idProduto + "\n Nome: " + nomeProduto + "\n Descrição: " + descricaoProduto + "\n Quantidade: " + quantidadeProduto + "\n Preço: " + precoProduto + "\n Estoque: " + estoqueMinimo + "\n";
    }
           
    public int getIdProduto() {return idProduto;}
    public void setIdProduto(int idProduto) {this.idProduto = idProduto;}

    public String getNomeProduto() {return nomeProduto;}
    public void setNomeProduto(String nomeProduto) {this.nomeProduto = nomeProduto;}

    public String getDescricaoProduto() {return descricaoProduto;}
    public void setDescricaoProduto(String descricaoProduto) {this.descricaoProduto = descricaoProduto;}

    public int getQuantidadeProduto() {return quantidadeProduto;}
    public void setQuantidadeProduto(int quantidadeProduto) {this.quantidadeProduto = quantidadeProduto;}

    public double getPrecoProduto() {return precoProduto;}
    public void setPrecoProduto(double precoProduto) {this.precoProduto = precoProduto;}

    public int getEstoqueMinimo() {return estoqueMinimo;}
    public void setEstoqueMinimo(int estoqueMinimo) {this.estoqueMinimo = estoqueMinimo;}

}