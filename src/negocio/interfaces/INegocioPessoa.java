package negocio.interfaces;

import negocio.entidades.abstratas.Pessoa;
import negocio.excessoes.*;

public interface INegocioPessoa {
    void adicionarPessoa(Pessoa pessoa) throws CpfJaExisteException, RgJaExisteException;
    Pessoa buscarPessoaPorCpf(String cpf) throws CpfNaoEncontrado;
    Pessoa buscarPessoaPorRg(String cpf) throws RgNaoEncontrado;
    String buscarPorNome(String nome) throws PessoaNaoEncotradaException;
    void removerPessoaPorRg(String rg) throws RgNaoEncontrado;
    void removerPessoaPorCpf(String cpf) throws CpfNaoEncontrado;
}
