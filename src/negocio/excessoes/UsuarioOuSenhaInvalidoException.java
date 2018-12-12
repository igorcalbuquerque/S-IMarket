package negocio.excessoes;

public class UsuarioOuSenhaInvalidoException extends Exception {
    public UsuarioOuSenhaInvalidoException(){
        super("USUARIO/SENHA INVALIDO(S)!!!");
    }
}
