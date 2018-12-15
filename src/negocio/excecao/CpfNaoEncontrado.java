package negocio.excecao;

public class CpfNaoEncontrado extends Exception {
    public CpfNaoEncontrado(){
        super("CPF NÃO ENCONTRADO!!!");
    }
}
