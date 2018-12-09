package negocio.excessoes;

public class RelatorioVazioException extends Exception {
    public RelatorioVazioException(){
        super("NAO EXISTEM INFORMACOES");
    }
}
