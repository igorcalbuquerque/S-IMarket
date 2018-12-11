package negocio.excessoes;

public class SecaoNaoEncontradaException extends Exception {
    public SecaoNaoEncontradaException(){
        super("NAO FOI POSSIVEL ENCONTRAR A SECAO BUSCADA!!!");
    }
}
