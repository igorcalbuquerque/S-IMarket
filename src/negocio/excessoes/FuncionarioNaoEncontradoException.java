package negocio.excessoes;

public class FuncionarioNaoEncontradoException extends Exception{

    public FuncionarioNaoEncontradoException(){
        super("NAO FOI POSSIVEL ENCONTRAR");
    }
}
