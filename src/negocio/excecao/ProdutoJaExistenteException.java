package negocio.excecao;

public class ProdutoJaExistenteException extends Exception {
    public ProdutoJaExistenteException(){
        super("PRODUTO JÁ CADASTRADO!");
    }
}
