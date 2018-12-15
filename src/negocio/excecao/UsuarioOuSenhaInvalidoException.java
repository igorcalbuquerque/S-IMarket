package negocio.excecao;

public class UsuarioOuSenhaInvalidoException extends Exception {
    public UsuarioOuSenhaInvalidoException(){
        super("USUARIO/SENHA INVALIDO(S)!!!");
    }
}
