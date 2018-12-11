package negocio;

import dados.RepositorioPessoa;
import dados.interfaces.IRepositorioPessoa;
import negocio.entidades.Funcionario;
import negocio.entidades.abstratas.Pessoa;
import negocio.excessoes.*;
import negocio.interfaces.INegocioPessoa;

public class NegocioFuncionario implements INegocioPessoa {

    private IRepositorioPessoa funcionarios;

    public NegocioFuncionario(){this.funcionarios = new RepositorioPessoa();}

    @Override
    public void adicionarPessoa(Pessoa funcionario) throws CpfJaExisteException, RgJaExisteException {
        if(funcionarios.buscarPessoaPorCpf(funcionario.getCpf()) != null){ throw new CpfJaExisteException(funcionario.getCpf()); }
        else if(funcionarios.buscarPessoaPorRg(funcionario.getRg()) != null){ throw new RgJaExisteException(funcionario.getRg()); }
        else{ funcionarios.adicionarPessoa(funcionario);}
    }
    @Override
    public Pessoa buscarPessoaPorCpf(String cpf) throws CpfNaoEncontrado {
        Pessoa funcionario = funcionarios.buscarPessoaPorCpf(cpf);
        if(funcionario == null){ throw new CpfNaoEncontrado();}
        else{ return funcionario;}
    }
    @Override
    public Pessoa buscarPessoaPorRg(String rg) throws RgNaoEncontrado {
        Pessoa funcionario = funcionarios.buscarPessoaPorRg(rg);
        if(funcionario == null){ throw new RgNaoEncontrado();}
        else{ return funcionario;}
    }
    @Override
    public String buscarPorNome(String nome) throws PessoaNaoEncotradaException {
        String str = funcionarios.buscarPorNome(nome);
        if(str.equals("")){ throw new PessoaNaoEncotradaException(); }
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
    public void promoverFuncionario(Funcionario funcionario){funcionario.setCargo(true);}
    public void rebaixarFuncionario(Funcionario funcionario){funcionario.setCargo(false);}
}
