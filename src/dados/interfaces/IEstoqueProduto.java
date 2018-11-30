package dados.interfaces;

import negocio.entidades.NotaFiscal;
import negocio.entidades.Produto;
import negocio.entidades.ProdutoEstoque;
import negocio.entidades.Venda;

public interface IEstoqueProduto {

    void adicionarProduto(Produto produto);
    void decrementar(Venda venda);
    void decrementar(NotaFiscal nota);
    void incrementar(NotaFiscal nota);
    void incrementar(int codigo, double quantidade);
    void incrementar(Venda venda);
    ProdutoEstoque buscarProduto(int codigo);
    ProdutoEstoque buscarProduto(String codigoBarra);
    void removerProduto(int codigo);
}
