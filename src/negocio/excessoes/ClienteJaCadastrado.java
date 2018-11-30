package negocio.excessoes;

public class ClienteJaCadastrado extends Exception {
    public ClienteJaCadastrado(){
        super("CLIENTE JÀ CADASTRADO!!!");
    }
}
