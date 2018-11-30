package negocio.interfaces;

import negocio.entidades.Cliente;
import negocio.entidades.abstratas.Pessoa;
import negocio.excessoes.*;

public interface INegocioCliente {
    void adicionarCliente(Cliente cliente) throws CpfJaExisteException, RgJaExisteException;
    Pessoa buscarPessoaPorCpf(String cpf) throws ClienteNaoEncontradoException;
    Pessoa buscarPessoaPorRg(String cpf) throws ClienteNaoEncontradoException;
    String buscarPorNome(String nome) throws ClienteNaoEncontradoException;
    void removerPessoaPorRg(String rg) throws ClienteNaoEncontradoException;
    void removerPessoaPorCpf(String cpf) throws ClienteNaoEncontradoException;
}
