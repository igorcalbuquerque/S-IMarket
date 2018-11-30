package negocio.excessoes;

public class ProdutoNaoEncontradoException extends Exception {
    public ProdutoNaoEncontradoException(){
        super("PRODUTO NÃO ENCONTRADO!!!");
    }
}
