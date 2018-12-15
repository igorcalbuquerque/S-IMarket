package negocio.excecao;

public class PessoaNaoEncotradaException extends Exception {
    public PessoaNaoEncotradaException(){
        super("NAO FOI POSSIVEL ENCONTRAR O CADASTRO");
    }
}
