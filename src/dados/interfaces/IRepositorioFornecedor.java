package dados.interfaces;

import negocio.entidades.Fornecedor;

public interface IRepositorioFornecedor {

    Fornecedor buscarFornecedor(int codigo);
    Fornecedor buscarFornecedor(String cnpj);
    void adicionarFornecedor(Fornecedor fornecedor);
    void removerFornecedor(int codigo);
    void removerFornecedor(String cnpj);

}
