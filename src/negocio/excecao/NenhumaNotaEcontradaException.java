package negocio.excecao;

public class NenhumaNotaEcontradaException extends Exception {

    public NenhumaNotaEcontradaException(){
        super("NAO FOI POSSIVEL ENCONTRAR NENHUMA NOTA!!!");
    }
}
