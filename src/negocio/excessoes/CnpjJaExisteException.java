package negocio.excessoes;

public class CnpjJaExisteException extends Exception {

    public CnpjJaExisteException(String cnpj){
        super("O CPNJ " +cnpj+" JA ESTA CADASTRADO!!!");
    }
}
