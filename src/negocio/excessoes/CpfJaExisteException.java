package negocio.excessoes;

public class CpfJaExisteException extends Exception{

    public CpfJaExisteException(String cpf){
        super("O CPF: "+cpf+" JA ESTA CADASTRADO");
    }
}
