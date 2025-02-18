import MonitoramentoNiveisProdutos.Estoque;
import GerenciamentoDeProdutos.Produto;
import SistemaUsuarios.Autenticacao;
import SistemaUsuarios.PerfilUsuario;
import SistemaUsuarios.Usuario;
import SistemaVendas.Pedido;
import SistemaVendas.RelatorioVendas;

public class Main {
    public static void main(String[] args) {
        // Criando o sistema de autenticação
        Autenticacao autenticacao = new Autenticacao();

        // Cadastrando usuários
        Usuario admin = new Usuario(1, "Admin", "admin", "admin123", PerfilUsuario.ADMINISTRADOR);
        Usuario gerente = new Usuario(2, "Gerente", "gerente", "gerente123", PerfilUsuario.GERENTE);
        autenticacao.cadastrarUsuario(admin);
        autenticacao.cadastrarUsuario(gerente);

        // Criando o estoque
        Estoque estoque = new Estoque();

        // Adicionando produtos ao estoque
        Produto produto1 = new Produto(1, "Notebook", "Notebook Dell", 10, 3500.00, 5);
        Produto produto2 = new Produto(2, "Mouse", "Mouse sem fio", 50, 120.00, 20);
        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);

        // Criando um pedido
        Pedido pedido1 = new Pedido(1, "João Silva");

        // Adicionando itens ao pedido
        pedido1.adicionarItem(produto1, 2); // 2 notebooks
        pedido1.adicionarItem(produto2, 5); // 5 mouses

        // Finalizando o pedido e atualizando o estoque
        pedido1.finalizarPedido(estoque);

        // Salvando o pedido em arquivo
        pedido1.salvarPedidoEmArquivo();

        // Gerando relatórios
        RelatorioVendas relatorio = new RelatorioVendas();
        relatorio.adicionarPedido(pedido1);
        relatorio.gerarRelatorio();
        estoque.gerarRelatorio();
    }
}