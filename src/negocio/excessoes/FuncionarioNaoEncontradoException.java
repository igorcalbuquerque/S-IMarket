package negocio.excessoes;

public class FuncionarioNaoEncontradoException extends Exception{

    public FuncionarioNaoEncontradoException(){
        super("O FUNCIONARIO BUSCADO NAO EXISTE!!!");
    }
}
