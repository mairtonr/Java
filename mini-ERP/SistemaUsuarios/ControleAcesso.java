package SistemaUsuarios;

public class ControleAcesso {
    public static boolean verificarPermissao(Usuario usuario, String acao) {
        if (usuario == null) {
            System.out.println("Usuário não autenticado.");
            return false;
        }

        switch (acao) {
            case "gerenciarEstoque":
                return usuario.getPerfil() == PerfilUsuario.ADMINISTRADOR || usuario.getPerfil() == PerfilUsuario.GERENTE;
            case "registrarVenda":
                return usuario.getPerfil() == PerfilUsuario.ADMINISTRADOR || usuario.getPerfil() == PerfilUsuario.GERENTE || usuario.getPerfil() == PerfilUsuario.VENDEDOR;
            case "gerarRelatorios":
                return usuario.getPerfil() == PerfilUsuario.ADMINISTRADOR || usuario.getPerfil() == PerfilUsuario.GERENTE;
            default:
                System.out.println("Ação não reconhecida.");
                return false;
        }
    }
}