package negocio;

import dados.RepositorioPessoa;
import negocio.entidades.Funcionario;
import negocio.entidades.abstratas.Pessoa;
import negocio.excessoes.*;
import negocio.interfaces.INegocioFuncionario;

public class NegocioFuncionario implements INegocioFuncionario {

    private RepositorioPessoa funcionarios;

    public NegocioFuncionario(){this.funcionarios = new RepositorioPessoa();}

    @Override
    public void adicionarFuncionario(Funcionario funcionario) throws CpfJaExisteException, RgJaExisteException {
        if(funcionarios.buscarPessoaPorCpf(funcionario.getCpf()) != null){ throw new CpfJaExisteException(funcionario.getCpf()); }
        else if(funcionarios.buscarPessoaPorRg(funcionario.getRg()) != null){ throw new RgJaExisteException(funcionario.getRg()); }
        else{ funcionarios.adicionarPessoa(funcionario);}
    }
    @Override
    public Funcionario buscarPessoaPorCpf(String cpf) throws FuncionarioNaoEncontradoException {
        Pessoa funcionario = funcionarios.buscarPessoaPorCpf(cpf);
        if(funcionario == null){ throw new FuncionarioNaoEncontradoException();}
        else{ return (Funcionario) funcionario;}
    }

    @Override
    public Funcionario buscarPessoaPorRg(String cpf) throws FuncionarioNaoEncontradoException {
        return null;
    }

    @Override
    public String buscarPorNome(String nome) throws FuncionarioNaoEncontradoException {
        return null;
    }

    @Override
    public void removerPessoaPorRg(String rg) throws FuncionarioNaoEncontradoException {

    }

    @Override
    public void removerPessoaPorCpf(String cpf) throws FuncionarioNaoEncontradoException {

    }
}
