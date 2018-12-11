package negocio.excessoes;

public class FornecedorNaoEncontradoException extends Exception {
    public FornecedorNaoEncontradoException(){
        super("NAO FOI POSSIVEL ENCONTRAR O FORNECEDOR BUSCADO!!!");
    }
}
