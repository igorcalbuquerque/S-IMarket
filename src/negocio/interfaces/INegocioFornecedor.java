package negocio.interfaces;

import negocio.entidades.Fornecedor;
import negocio.excecao.CnpjJaExisteException;
import negocio.excecao.CodigoJaExisteException;
import negocio.excecao.FornecedorNaoEncontradoException;

public interface INegocioFornecedor {
    Fornecedor buscarFornecedor(int codigo) throws FornecedorNaoEncontradoException;
    Fornecedor buscarFornecedor(String cnpj) throws FornecedorNaoEncontradoException;
    void adicionarFornecedor(Fornecedor fornecedor) throws CnpjJaExisteException, CodigoJaExisteException;
    void removerFornecedor(int codigo) throws FornecedorNaoEncontradoException;
    void removerFornecedor(String cnpj) throws FornecedorNaoEncontradoException;
}
