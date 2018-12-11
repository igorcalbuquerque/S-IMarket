package negocio.interfaces;

import negocio.entidades.Fornecedor;
import negocio.excessoes.CnpjJaExisteException;
import negocio.excessoes.CodigoJaExisteException;
import negocio.excessoes.FornecedorNaoEncontradoException;

public interface INegocioFornecedor {
    Fornecedor buscarFornecedor(int codigo) throws FornecedorNaoEncontradoException;
    Fornecedor buscarFornecedor(String cnpj) throws FornecedorNaoEncontradoException;
    void adicionarFornecedor(Fornecedor fornecedor) throws CnpjJaExisteException, CodigoJaExisteException;
    void removerFornecedor(int codigo) throws FornecedorNaoEncontradoException;
    void removerFornecedor(String cnpj) throws FornecedorNaoEncontradoException;
}
