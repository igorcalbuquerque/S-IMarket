package dados.interfaces;

import negocio.entidades.Data;
import negocio.entidades.Fornecedor;
import negocio.entidades.NotaFiscal;

public interface IRepositorioNota {

    void adicionarNotas(NotaFiscal nota);
    void removerNota(int numero,Fornecedor fornecedor);
    String listarNotasPorEntrada(Data data);
    String listarNotasPorEmissao(Data data);
    String listarNotasPorNumero(int numero);
    String listarNotasPorFornecedor(Fornecedor fornecedor,Data dataInicial, Data dataFinal);
    NotaFiscal buscarNota(int numero,Fornecedor fornecedor);
}
