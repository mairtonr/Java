package SistemaUsuarios;

import java.util.HashMap;
import java.util.Map;

public class Autenticacao {
    private Map<String, Usuario> usuarios;

    public Autenticacao() {
        this.usuarios = new HashMap<>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getLogin(), usuario);
        System.out.println("Usuário cadastrado: " + usuario.getNome());
    }

    public Usuario autenticar(String login, String senha) {
        Usuario usuario = usuarios.get(login);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            System.out.println("Usuário autenticado: " + usuario.getNome());
            return usuario;
        }
        System.out.println("Falha na autenticação: Login ou senha incorretos.");
        return null;
    }
}