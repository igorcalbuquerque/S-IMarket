package dados.interfaces;

import negocio.entidades.abstratas.Pessoa;

public interface IRepositorioPessoa {

    void adicionarPessoa(Pessoa pessoa);
    String buscarPorNome(String nome);
    Pessoa buscarPessoaPorRg(String rg );
    Pessoa buscarPessoaPorCpf(String cpf );
    void removerPessoaPorRg(String rg);
    void removerPessoaPorCpf(String cpf);
}
