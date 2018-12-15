package negocio.interfaces;

import negocio.entidades.*;
import negocio.excecao.DataInvalidaException;
import negocio.excecao.RelatorioVazioException;
import negocio.excecao.VendaNaoEncotradaException;

public interface INegocioVenda {
    void adicionarVenda(Venda venda);
    void removerVenda(int codigo) throws VendaNaoEncotradaException;
    Venda buscarVenda(int codigo) throws VendaNaoEncotradaException;
    String relatorioVenda(Data dataInicial, Data dataFinal) throws DataInvalidaException, RelatorioVazioException;
    String relatorioVenda(Cliente cliente, Data dataInicial, Data dataFinal) throws DataInvalidaException,RelatorioVazioException;
    String relatorioVenda(Funcionario funcionario, Data dataInicial, Data dataFinal) throws DataInvalidaException,RelatorioVazioException;
    String relatorioVenda(Secao secao, Data dataInicial, Data dataFinal) throws DataInvalidaException,RelatorioVazioException;
    String relatorioVenda(Produto produto, Data dataInicial, Data dataFinal) throws DataInvalidaException,RelatorioVazioException;
}
