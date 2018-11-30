package negocio;

import dados.RepositorioProduto;
import dados.interfaces.IRepositorioProduto;
import negocio.entidades.Produto;
import negocio.excessoes.ProdutoNaoEncontradoException;

public class NegocioProduto {

    private IRepositorioProduto produtos;

    public NegocioProduto(){
        this.produtos = new RepositorioProduto();
    }
    public Produto buscarProdutoPorCodigo(int codigo) throws ProdutoNaoEncontradoException {

        Produto produto = produtos.buscarProduto(codigo);

        if (produto == null){
            throw new ProdutoNaoEncontradoException();
        }
        else{
            return produto;
        }
    }

    public Produto buscarPorCodigoDeBarras(String codigo) throws ProdutoNaoEncontradoException {
        Produto produto = produtos.buscarProduto(codigo);

        if(produto == null){
            throw new ProdutoNaoEncontradoException();
        }
        else {
            return produto;
        }
    }

    public void removerPorCodigoInterno(int codigo) throws ProdutoNaoEncontradoException{
        Produto produto = produtos.removerProduto(codigo);
        if (produto == null){
            throw new ProdutoNaoEncontradoException();
        }
        else {
            produtos.removerProduto(codigo);
        }
    }


    @Override
    public String toString() {
        return produtos.toString();
    }
}