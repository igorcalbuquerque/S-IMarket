package negocio.excessoes;

public class VendaNaoEncotradaException extends Exception{
    public VendaNaoEncotradaException(int numero){
        super("NAO FOI POSSIVEL ENCONTRAR A VENDA NUMERO " + numero);
    }
}
