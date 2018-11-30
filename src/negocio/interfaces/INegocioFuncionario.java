package negocio.interfaces;

import negocio.entidades.Funcionario;
import negocio.excessoes.*;

public interface INegocioFuncionario {
    void adicionarFuncionario(Funcionario funcionario) throws CpfJaExisteException, RgJaExisteException;
    Funcionario buscarPessoaPorCpf(String cpf) throws FuncionarioNaoEncontradoException;
    Funcionario buscarPessoaPorRg(String cpf) throws FuncionarioNaoEncontradoException;
    String buscarPorNome(String nome) throws FuncionarioNaoEncontradoException;
    void removerPessoaPorRg(String rg) throws FuncionarioNaoEncontradoException;
    void removerPessoaPorCpf(String cpf) throws FuncionarioNaoEncontradoException;
}
