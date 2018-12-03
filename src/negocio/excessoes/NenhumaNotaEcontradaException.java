package negocio.excessoes;

public class NenhumaNotaEcontradaException extends Exception {

    public NenhumaNotaEcontradaException(){
        super("NAO FOI POSSIVEL ENCONTRAR NENHUMA NOTA!!!");
    }
}
