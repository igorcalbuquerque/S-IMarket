package negocio.excessoes;

public class DataInvalidaException extends Exception{
    public DataInvalidaException(String str){
        super("A DATA "+str+"NAO E VALIDA!!!");
    }
}
