package negocio.excecao;

public class ClienteJaCadastrado extends Exception {
    public ClienteJaCadastrado(){
        super("CLIENTE JÀ CADASTRADO!!!");
    }
}
