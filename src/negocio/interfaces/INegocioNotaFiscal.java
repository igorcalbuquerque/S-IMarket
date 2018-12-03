package negocio.interfaces;

import negocio.entidades.Data;
import negocio.entidades.Fornecedor;
import negocio.entidades.NotaFiscal;
import negocio.excessoes.*;

public interface INegocioNotaFiscal {
    void adicionarNotas(NotaFiscal nota) throws NotaJaExisteException;
    void removerNota(int numero, Fornecedor fornecedor) throws NenhumaNotaEcontradaException;
    public String listarNotasPorEntrada(Data data) throws NenhumaNotaEcontradaException,DataInvalidaException;
    String listarNotasPorEmissao(Data data) throws NenhumaNotaEcontradaException,DataInvalidaException;
    String listarNotasPorNumero(int numero) throws NenhumaNotaEcontradaException;
    String listarNotasPorFornecedor(Fornecedor fornecedor,Data dataInicial, Data dataFinal)
            throws NenhumaNotaEcontradaException, DataInvalidaException;
    NotaFiscal buscarNota(int numero,Fornecedor fornecedor) throws NotaNaoEncontradaException;
}
