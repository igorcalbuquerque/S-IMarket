package negocio;

import dados.RepositorioPessoa;
import dados.interfaces.IRepositorioPessoa;
import negocio.entidades.Funcionario;
import negocio.entidades.abstratas.Pessoa;
import negocio.excessoes.*;
import negocio.interfaces.INegocioFuncionario;

public class NegocioFuncionario implements INegocioFuncionario {

    private IRepositorioPessoa funcionarios;

    public NegocioFuncionario(){this.funcionarios = new RepositorioPessoa();}

    @Override
    public void adicionarFuncionario(Funcionario funcionario) throws CpfJaExisteException, RgJaExisteException {
        if(funcionarios.buscarPessoaPorCpf(funcionario.getCpf()) != null){ throw new CpfJaExisteException(funcionario.getCpf()); }
        else if(funcionarios.buscarPessoaPorRg(funcionario.getRg()) != null){ throw new RgJaExisteException(funcionario.getRg()); }
        else{ funcionarios.adicionarPessoa(funcionario);}
    }
    @Override
    public Funcionario buscarPessoaPorCpf(String cpf) throws CpfNaoEncontrado {
        Pessoa funcionario = funcionarios.buscarPessoaPorCpf(cpf);
        if(funcionario == null){ throw new CpfNaoEncontrado();}
        else{ return (Funcionario)funcionario;}
    }

    @Override
    public Funcionario buscarPessoaPorRg(String rg) throws RgNaoEncontrado {
        Pessoa funcionario = funcionarios.buscarPessoaPorRg(rg);
        if(funcionario == null){ throw new RgNaoEncontrado();}
        else{ return (Funcionario)funcionario;}
    }

    @Override
    public String buscarPorNome(String nome) throws FuncionarioNaoEncontradoException {
        String str = funcionarios.buscarPorNome(nome);
        if(str.equals("")){ throw new FuncionarioNaoEncontradoException(); }
        else{return str;}
    }

    @Override
    public void removerPessoaPorRg(String rg) throws RgNaoEncontrado {
        if(funcionarios.buscarPessoaPorRg(rg) == null){ throw new RgNaoEncontrado(); }
        else{ funcionarios.removerPessoaPorRg(rg);}
    }

    @Override
    public void removerPessoaPorCpf(String cpf) throws CpfNaoEncontrado {
        if(funcionarios.buscarPessoaPorCpf(cpf) == null){ throw new CpfNaoEncontrado(); }
        else{ funcionarios.removerPessoaPorCpf(cpf);}
    }
}
