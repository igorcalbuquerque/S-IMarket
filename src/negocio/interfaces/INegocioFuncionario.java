package negocio.interfaces;

import negocio.entidades.Funcionario;
import negocio.excessoes.*;

public interface INegocioFuncionario {
    void adicionarFuncionario(Funcionario funcionario) throws CpfJaExisteException, RgJaExisteException;
    Funcionario buscarPessoaPorCpf(String cpf) throws CpfNaoEncontrado;
    Funcionario buscarPessoaPorRg(String cpf) throws RgNaoEncontrado;
    String buscarPorNome(String nome) throws FuncionarioNaoEncontradoException;
    void removerPessoaPorRg(String rg) throws RgNaoEncontrado;
    void removerPessoaPorCpf(String cpf) throws CpfNaoEncontrado;
}
