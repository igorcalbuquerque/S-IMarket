package negocio.excecao;

import negocio.entidades.NotaFiscal;

public class NotaJaExisteException extends Exception{
    public NotaJaExisteException(NotaFiscal nota){
        super("A NOTA FISCAL NUMERO: " + nota.getNumero() + " SERIE: " + nota.getSerie() +
              "\n=========== FORNECEDOR =============\n" + nota.getFornecedor().informacoesBasicas());
    }
}
