package fachada.interfaces;

import negocio.entidades.Endereco;
import negocio.entidades.abstratas.Pessoa;
import negocio.excessoes.*;

public interface IFachadaGerente {
    void adicionarFuncionario(String nome, String rg, String cpf, Endereco endereco, boolean gerente, String login, String senha)
            throws CpfJaExisteException, RgJaExisteException;
    void adicionarFuncionario(String nome, String rg,String cpf, Endereco endereco, boolean gerente,String senha)
            throws CpfJaExisteException, RgJaExisteException;
    Pessoa buscarFuncionarioPorCpf(String cpf) throws CpfNaoEncontrado;
    Pessoa buscarFuncionarioPorRg(String rg) throws RgNaoEncontrado;
    String buscarFuncionarioPorNome(String nome) throws PessoaNaoEncotradaException;
    void removerFuncionarioPorRg(String rg) throws RgNaoEncontrado;
    void removerFuncionarioPorCpf(String cpf) throws CpfNaoEncontrado;
}
