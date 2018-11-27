package dados.interfaces;

import negocio.entidades.Produto;

public interface IRepositorioProduto {

    void adicionarProduto(Produto produto);
    void removerProduto(int codigo);
    Produto buscarProduto(int codigo);
    Produto buscarProduto(String codigoBarra);

}
