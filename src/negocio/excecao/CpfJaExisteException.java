package negocio.excecao;

public class CpfJaExisteException extends Exception{

    public CpfJaExisteException(String cpf){
        super("O CPF: "+cpf+" JA ESTA CADASTRADO");
    }
}
