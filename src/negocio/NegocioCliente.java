package negocio;

import dados.RepositorioPessoa;
import dados.interfaces.IRepositorioPessoa;
import negocio.entidades.Cliente;
import negocio.entidades.abstratas.Pessoa;
import negocio.excessoes.*;
import negocio.interfaces.INegocioCliente;

public class NegocioCliente implements INegocioCliente {

    private IRepositorioPessoa clientes;

    public NegocioCliente(){ this.clientes = new RepositorioPessoa();}
    @Override
    public void adicionarCliente(Cliente cliente) throws CpfJaExisteException,RgJaExisteException{
        if(clientes.buscarPessoaPorCpf(cliente.getCpf()) != null){ throw new CpfJaExisteException(cliente.getCpf()); }
        else if(clientes.buscarPessoaPorRg(cliente.getRg()) != null){ throw new RgJaExisteException(cliente.getRg()); }
        else{ clientes.adicionarPessoa(cliente);}
    }
    @Override
    public Pessoa buscarPessoaPorCpf(String cpf) throws ClienteNaoEncontradoException{
        Pessoa cliente  = clientes.buscarPessoaPorCpf(cpf);
        if(cliente == null){
            throw new ClienteNaoEncontradoException();
        }else{
            return cliente;
        }
    }
    @Override
    public Pessoa buscarPessoaPorRg(String cpf) throws ClienteNaoEncontradoException{
        Pessoa cliente  = clientes.buscarPessoaPorRg(cpf);
        if(cliente == null){ throw new ClienteNaoEncontradoException(); }
        else{ return cliente; }
    }
    @Override
    public String buscarPorNome(String nome) throws ClienteNaoEncontradoException{
        String str = clientes.buscarPorNome(nome);
        if (str.equals("")){
            throw new ClienteNaoEncontradoException();
        }else{
            return str;
        }
    }
    @Override
    public void removerPessoaPorRg(String rg) throws ClienteNaoEncontradoException{
        Pessoa cliente = clientes.buscarPessoaPorRg(rg);
        if(cliente == null){ throw new ClienteNaoEncontradoException(); }
        else { clientes.removerPessoaPorRg(rg);}
    }
    @Override
    public void removerPessoaPorCpf(String cpf) throws ClienteNaoEncontradoException{
        Pessoa cliente = clientes.buscarPessoaPorCpf(cpf);
        if(cliente == null){ throw new ClienteNaoEncontradoException(); }
        else { clientes.removerPessoaPorRg(cpf);}
    }
    @Override
    public String toString(){ return clientes.toString();}
}
