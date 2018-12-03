package negocio.excessoes;

public class CodigoJaExisteException extends Exception {
    public CodigoJaExisteException(String codigoBarra){
        super("O CODIGO " + codigoBarra + " JA ESTA CADASTRADO!!!");
    }
    public CodigoJaExisteException(int codigo){
        super("O CODIGO " + codigo + " JA ESTA CADASTRADO!!!");
    }
}
