package fachada.interfaces;

import negocio.entidades.*;
import negocio.entidades.abstratas.Pessoa;
import negocio.excessoes.*;

public interface IFachadaAssociado {
    boolean login(String login,String senha) throws UsuarioOuSenhaInvalidoException, FuncionarioNaoEncontradoException;
    void adicionarCliente(String nome, String rg, String cpf, Endereco endereco,String telefone, String email)
            throws CpfJaExisteException, RgJaExisteException;
    Pessoa buscarClientePorCpf(String cpf) throws CpfNaoEncontrado;
    Pessoa buscarcClientePorRg(String rg) throws RgNaoEncontrado;
    String buscarClientePorNome(String nome) throws PessoaNaoEncotradaException;
    void removerClientePorRg(String rg) throws RgNaoEncontrado;
    void removerClientePorCpf(String cpf) throws CpfNaoEncontrado;
    void adicionarNotas(int numero, int serie, Data dataEmissao, Data dataPagamento, Fornecedor fornecedor)
            throws NotaJaExisteException;
    void removerNota(int numero, int codigoFornecedor) throws NenhumaNotaEcontradaException,FornecedorNaoEncontradoException;
    String listarNotasPorEntrada(Data data) throws NenhumaNotaEcontradaException,DataInvalidaException;
    String listarNotasPorEmissao(Data data) throws NenhumaNotaEcontradaException,DataInvalidaException;
    String listarNotasPorNumero(int numero) throws NenhumaNotaEcontradaException;
    String listarNotasPorFornecedor(Fornecedor fornecedor, Data dataInicial, Data dataFinal)
            throws NenhumaNotaEcontradaException,DataInvalidaException;
    NotaFiscal buscarNota(int numero, int codigoFornecedor) throws NotaNaoEncontradaException, FornecedorNaoEncontradoException;
    void adicionarProduto(int codigo,String codigoBarra,String descricao, double valorCompra, double valorVenda, int codigoSecao)
            throws CodigoJaExisteException, SecaoNaoEncontradaException;
    Produto buscarProdutoPorCodigo(int codigo) throws ProdutoNaoEncontradoException;
    Produto buscarProdutoPorCodigoDeBarras(String codigo) throws ProdutoNaoEncontradoException;
    void removerProdutoPorCodigoInterno(int codigo) throws ProdutoNaoEncontradoException;
    void adicionarVenda(Venda venda);
    void removerVenda(int codigo) throws VendaNaoEncotradaException;
    Venda buscarVenda(int codigo) throws VendaNaoEncotradaException;
    String relatorioVenda(Data dataInicial, Data dataFinal) throws DataInvalidaException, RelatorioVazioException;
    String relatorioVenda(Cliente cliente, Data dataInicial, Data dataFinal) throws DataInvalidaException,RelatorioVazioException;
    String relatorioVenda(Funcionario funcionario, Data dataInicial, Data dataFinal) throws DataInvalidaException,RelatorioVazioException;
    String relatorioVenda(Secao secao, Data dataInicial, Data dataFinal) throws DataInvalidaException,RelatorioVazioException;
    String relatorioVenda(Produto produto, Data dataInicial, Data dataFinal) throws DataInvalidaException,RelatorioVazioException;
}
