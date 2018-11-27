package dados.interfaces;

import negocio.entidades.*;

public interface IRepositorioVendas {

    void adicionarVenda(Venda venda);
    void removerVenda(int codigo);
    Venda buscarVenda(int codigo);
    String relatorioVenda(Data dataInicial, Data dataFinal);
    String relatorioVenda(Cliente cliente, Data dataInicial, Data dataFinal);
    String relatorioVenda(Funcionario funcionario, Data dataInicial, Data dataFinal);
    String relatorioVenda(Secao secao, Data dataInicial, Data dataFinal);
    String relatorioVenda(Produto produto, Data dataInicial, Data dataFinal);
}
