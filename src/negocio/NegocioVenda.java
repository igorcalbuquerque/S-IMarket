package negocio;

import dados.RepositorioVenda;
import dados.interfaces.IRepositorioVenda;
import negocio.entidades.*;
import negocio.excessoes.DataInvalidaException;
import negocio.excessoes.VendaNaoEncotradaException;
import negocio.interfaces.INegocioVenda;

public class NegocioVenda implements INegocioVenda {
    private IRepositorioVenda repositorioVenda;
    public NegocioVenda(){this.repositorioVenda = new RepositorioVenda(); }
    @Override
    public void adicionarVenda(Venda venda) {

    }
    @Override
    public void removerVenda(int codigo) throws VendaNaoEncotradaException {

    }
    @Override
    public Venda buscarVenda(int codigo) throws VendaNaoEncotradaException {
        return null;
    }
    @Override
    public String relatorioVenda(Data dataInicial, Data dataFinal) throws DataInvalidaException {
        return null;
    }
    @Override
    public String relatorioVenda(Cliente cliente, Data dataInicial, Data dataFinal) throws DataInvalidaException {
        return null;
    }
    @Override
    public String relatorioVenda(Funcionario funcionario, Data dataInicial, Data dataFinal) throws DataInvalidaException {
        return null;
    }
    @Override
    public String relatorioVenda(Secao secao, Data dataInicial, Data dataFinal) throws DataInvalidaException {
        return null;
    }
    @Override
    public String relatorioVenda(Produto produto, Data dataInicial, Data dataFinal) throws DataInvalidaException {
        return null;
    }
}
