package negocio;

import dados.RepositorioPessoa;
import dados.interfaces.IRepositorioPessoa;
import negocio.entidades.Cliente;
import negocio.entidades.abstratas.Pessoa;
import negocio.excessoes.*;

public class NegocioCliente {

    private IRepositorioPessoa clientes;

    public NegocioCliente(){ this.clientes = new RepositorioPessoa();}
    public void adicionarCliente(Cliente cliente) throws Exception{
        if(clientes.buscarPessoaPorCpf(cliente.getCpf()) != null){ throw new CpfJaExisteException(cliente.getCpf()); }
        else if(clientes.buscarPessoaPorRg(cliente.getRg()) != null){ throw new RgJaExisteException(cliente.getRg()); }
        else{ clientes.adicionarPessoa(cliente);}
    }
    public Pessoa buscarPessoaPorCpf(String cpf) throws Exception{
        Pessoa cliente  = clientes.buscarPessoaPorCpf(cpf);
        if(cliente == null){
            throw new ClienteNaoEncontradoException();
        }else{
            return cliente;
        }
    }
    public Pessoa buscarPessoaPorRg(String cpf) throws Exception{
        Pessoa cliente  = clientes.buscarPessoaPorRg(cpf);
        if(cliente == null){ throw new ClienteNaoEncontradoException(); }
        else{ return cliente; }
    }
    public String buscarPorNome(String nome) throws Exception{
        String str = clientes.buscarPorNome(nome);
        if (str.equals("")){
            throw new ClienteNaoEncontradoException();
        }else{
            return str;
        }
    }
    public void removerPessoaPorRg(String rg) throws Exception{
        Pessoa cliente = clientes.buscarPessoaPorRg(rg);
        if(cliente == null){ throw new ClienteNaoEncontradoException(); }
        else { clientes.removerPessoaPorRg(rg);}
    }
    public void removerPessoaPorCpf(String cpf) throws Exception{
        Pessoa cliente = clientes.buscarPessoaPorCpf(cpf);
        if(cliente == null){ throw new ClienteNaoEncontradoException(); }
        else { clientes.removerPessoaPorRg(cpf);}
    }
    @Override
    public String toString(){ return clientes.toString();}
}
