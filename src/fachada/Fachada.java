package fachada;

import fachada.interfaces.IFachadaAssociado;
import negocio.*;
import negocio.entidades.*;
import negocio.entidades.abstratas.Pessoa;
import negocio.excessoes.*;
import negocio.interfaces.*;
import negocio.validacao.NegocioSecao;

public class Fachada implements IFachadaAssociado {

    private INegocioPessoa negocioCliente;
    private INegocioPessoa negocioFuncionario;
    private INegocioNotaFiscal negocioNotaFiscal;
    private INegocioProduto negocioProduto;
    private INegocioVenda negocioVenda;
    private INegocioFornecedor negocioFornecedor;
    private INegocioSecao negocioSecao;
    private static Fachada fachada;

    public Fachada(){
        this.negocioCliente = new NegocioCliente();
        this.negocioFuncionario = new NegocioFuncionario();
        this.negocioNotaFiscal = new NegocioNotaFiscal();
        this.negocioProduto = new NegocioProduto();
        this.negocioVenda = new NegocioVenda();
        this.negocioFornecedor = new NegocioFornecedor();
        this.negocioSecao = new NegocioSecao();
    }
    public static Fachada getInstance(){
        if (fachada == null){fachada = new Fachada();}
        return fachada;
    }
    @Override
    public void adicionarCliente(String nome, String rg, String cpf, Endereco endereco,String telefone, String email)
            throws CpfJaExisteException, RgJaExisteException {
        Cliente cliente = new Cliente(nome,rg,cpf,endereco,telefone,email);
        negocioCliente.adicionarPessoa(cliente);
    }
    @Override
    public Pessoa buscarClientePorCpf(String cpf) throws CpfNaoEncontrado {
        Pessoa cliente = negocioCliente.buscarPessoaPorCpf(cpf);
        return cliente;
    }
    @Override
    public Pessoa buscarcClientePorRg(String rg) throws RgNaoEncontrado {
        Pessoa cliente = negocioCliente.buscarPessoaPorRg(rg);
        return cliente;
    }
    @Override
    public String buscarClientePorNome(String nome) throws PessoaNaoEncotradaException {
        return negocioCliente.buscarPorNome(nome);
    }
    @Override
    public void removerClientePorRg(String rg) throws RgNaoEncontrado {
        negocioCliente.removerPessoaPorRg(rg);
    }
    @Override
    public void removerClientePorCpf(String cpf) throws CpfNaoEncontrado {
        negocioCliente.removerPessoaPorCpf(cpf);
    }
    @Override
    public void adicionarNotas(int numero, int serie, Data dataEmissao, Data dataPagamento, Fornecedor fornecedor)
            throws NotaJaExisteException {

    }
    @Override
    public void removerNota(int numero, int codigoFornecedor) throws NenhumaNotaEcontradaException,FornecedorNaoEncontradoException {
        negocioNotaFiscal.removerNota(numero,negocioFornecedor.buscarFornecedor(codigoFornecedor));
    }
    @Override
    public String listarNotasPorEntrada(Data data) throws NenhumaNotaEcontradaException, DataInvalidaException {
        return negocioNotaFiscal.listarNotasPorEntrada(data);
    }
    @Override
    public String listarNotasPorEmissao(Data data) throws NenhumaNotaEcontradaException, DataInvalidaException {
        return negocioNotaFiscal.listarNotasPorEmissao(data);
    }
    @Override
    public String listarNotasPorNumero(int numero) throws NenhumaNotaEcontradaException {
        return negocioNotaFiscal.listarNotasPorNumero(numero);
    }
    @Override
    public String listarNotasPorFornecedor(Fornecedor fornecedor, Data dataInicial, Data dataFinal)
            throws NenhumaNotaEcontradaException, DataInvalidaException {
        return negocioNotaFiscal.listarNotasPorFornecedor(fornecedor,dataInicial,dataFinal);
    }
    @Override
    public NotaFiscal buscarNota(int numero, int codigoFornecedor) throws NotaNaoEncontradaException, FornecedorNaoEncontradoException {
        return negocioNotaFiscal.buscarNota(numero,negocioFornecedor.buscarFornecedor(codigoFornecedor));
    }
    @Override
    public void adicionarProduto(int codigo, String codigoBarra, String descricao, double valorCompra, double valorVenda, int codigoSecao)
            throws CodigoJaExisteException, SecaoNaoEncontradaException {
        Produto produto = new Produto(codigo,codigoBarra,descricao,valorCompra,valorVenda,negocioSecao.buscarSecao(codigoSecao));
        negocioProduto.adicionarProduto(produto);
    }
    @Override
    public Produto buscarProdutoPorCodigo(int codigo) throws ProdutoNaoEncontradoException {
        return negocioProduto.buscarProdutoPorCodigo(codigo);
    }
    @Override
    public Produto buscarProdutoPorCodigoDeBarras(String codigoBarra) throws ProdutoNaoEncontradoException {
        return negocioProduto.buscarPorCodigoDeBarras(codigoBarra);
    }
    @Override
    public void removerProdutoPorCodigoInterno(int codigo) throws ProdutoNaoEncontradoException {
        negocioProduto.removerPorCodigoInterno(codigo);
    }
    @Override
    public void adicionarVenda(Venda venda) {
        negocioVenda.adicionarVenda(venda);
    }
    @Override
    public void removerVenda(int codigo) throws VendaNaoEncotradaException {
        negocioVenda.removerVenda(codigo);
    }
    @Override
    public Venda buscarVenda(int codigo) throws VendaNaoEncotradaException {
        return negocioVenda.buscarVenda(codigo);
    }
    @Override
    public String relatorioVenda(Data dataInicial, Data dataFinal) throws DataInvalidaException, RelatorioVazioException {
        return negocioVenda.relatorioVenda(dataInicial,dataFinal);
    }
    @Override
    public String relatorioVenda(Cliente cliente, Data dataInicial, Data dataFinal) throws DataInvalidaException, RelatorioVazioException {
        return negocioVenda.relatorioVenda(cliente,dataInicial,dataFinal);
    }
    @Override
    public String relatorioVenda(Funcionario funcionario, Data dataInicial, Data dataFinal) throws DataInvalidaException, RelatorioVazioException {
        return negocioVenda.relatorioVenda(funcionario,dataInicial,dataFinal);
    }
    @Override
    public String relatorioVenda(Secao secao, Data dataInicial, Data dataFinal) throws DataInvalidaException, RelatorioVazioException {
        return negocioVenda.relatorioVenda(secao,dataInicial,dataFinal);
    }
    @Override
    public String relatorioVenda(Produto produto, Data dataInicial, Data dataFinal) throws DataInvalidaException, RelatorioVazioException {
        return negocioVenda.relatorioVenda(produto,dataInicial,dataFinal);
    }
}
