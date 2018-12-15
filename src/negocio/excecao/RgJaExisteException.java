package negocio.excecao;

public class RgJaExisteException extends Exception {

    public RgJaExisteException(String rg){
        super("O RG: " + rg +" JA ESTA CADASTRADO!!!");
    }
}
