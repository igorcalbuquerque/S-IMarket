package negocio.excecao;

import negocio.entidades.Fornecedor;

public class NotaNaoEncontradaException extends Exception {
    public NotaNaoEncontradaException(int numero, Fornecedor fornecedor){
        super("NAO FOI POSSIVEL ENCONTRAR A NOTA NUMERO: " + numero +
              "\n=========== FORNECEDOR =============\n"+fornecedor.informacoesBasicas()+"\nNAO EXISTE");
    }
}
