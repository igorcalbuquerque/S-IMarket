package negocio.excessoes;

public class FuncionarioJaCadastrado extends Exception {
    public FuncionarioJaCadastrado(){
        super("FUNCIONARIO JÁ CADASTRADO!!!");
    }
}
