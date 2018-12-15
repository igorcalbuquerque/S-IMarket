package negocio;

import dados.RepositorioPessoa;
import dados.interfaces.IRepositorioPessoa;
import negocio.entidades.abstratas.Pessoa;
import negocio.excecao.*;
import negocio.interfaces.INegocioPessoa;

public class NegocioCliente implements INegocioPessoa {

    private IRepositorioPessoa clientes;

    public NegocioCliente(){ this.clientes = new RepositorioPessoa();}

    @Override
    public void adicionarPessoa(Pessoa cliente) throws CpfJaExisteException, RgJaExisteException {
        if(clientes.buscarPessoaPorCpf(cliente.getCpf()) != null){ throw new CpfJaExisteException(cliente.getCpf()); }
        else if(clientes.buscarPessoaPorRg(cliente.getRg()) != null){ throw new RgJaExisteException(cliente.getRg());}
        else clientes.adicionarPessoa(cliente);
    }
    @Override
    public Pessoa buscarPessoaPorCpf(String cpf) throws CpfNaoEncontrado{
        Pessoa cliente  = clientes.buscarPessoaPorCpf(cpf);
        if(cliente == null){ throw new CpfNaoEncontrado(); }
        else{ return cliente; }
    }
    @Override
    public Pessoa buscarPessoaPorRg(String cpf) throws RgNaoEncontrado {
        Pessoa cliente  = clientes.buscarPessoaPorRg(cpf);
        if(cliente == null){ throw new RgNaoEncontrado(); }
        else{ return cliente; }
    }
    @Override
    public String buscarPorNome(String nome) throws PessoaNaoEncotradaException{
        String str = clientes.buscarPorNome(nome);
        if (str.equals("")){ throw new PessoaNaoEncotradaException(); }
        else{ return str; }
    }
    @Override
    public void removerPessoaPorRg(String rg) throws RgNaoEncontrado {
        Pessoa cliente = clientes.buscarPessoaPorRg(rg);
        if(cliente == null){ throw new RgNaoEncontrado(); }
        else { clientes.removerPessoaPorRg(rg);}
    }
    @Override
    public void removerPessoaPorCpf(String cpf) throws CpfNaoEncontrado{
        Pessoa cliente = clientes.buscarPessoaPorCpf(cpf);
        if(cliente == null){ throw new CpfNaoEncontrado(); }
        else { clientes.removerPessoaPorRg(cpf);}
    }
    @Override
    public String toString(){ return clientes.toString();}
}
