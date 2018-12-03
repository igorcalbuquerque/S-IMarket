package negocio.interfaces;

import dados.interfaces.IRepositorioVenda;
import negocio.entidades.*;
import negocio.excessoes.DataInvalidaException;
import negocio.excessoes.VendaNaoEncotradaException;

public interface INegocioVenda {
    void adicionarVenda(Venda venda);
    void removerVenda(int codigo) throws VendaNaoEncotradaException;
    Venda buscarVenda(int codigo) throws VendaNaoEncotradaException;
    String relatorioVenda(Data dataInicial, Data dataFinal) throws DataInvalidaException;
    String relatorioVenda(Cliente cliente, Data dataInicial, Data dataFinal) throws DataInvalidaException;
    String relatorioVenda(Funcionario funcionario, Data dataInicial, Data dataFinal) throws DataInvalidaException;
    String relatorioVenda(Secao secao, Data dataInicial, Data dataFinal) throws DataInvalidaException;
    String relatorioVenda(Produto produto, Data dataInicial, Data dataFinal) throws DataInvalidaException;
}
