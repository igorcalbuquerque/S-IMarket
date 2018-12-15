package negocio.interfaces;

import negocio.entidades.Produto;
import negocio.excecao.*;

public interface INegocioProduto {
    void adicionarProduto(Produto produto) throws CodigoJaExisteException;
    Produto buscarProdutoPorCodigo(int codigo) throws ProdutoNaoEncontradoException;
    Produto buscarPorCodigoDeBarras(String codigo) throws ProdutoNaoEncontradoException;
    void removerPorCodigoInterno(int codigo) throws ProdutoNaoEncontradoException;
}
