package negocio;

import dados.RepositorioProduto;
import dados.interfaces.IRepositorioProduto;
import negocio.entidades.Produto;
import negocio.excessoes.*;
import negocio.interfaces.INegocioProduto;

public class NegocioProduto implements INegocioProduto {

    private IRepositorioProduto produtos;

    public NegocioProduto(){
        this.produtos = new RepositorioProduto();
    }
    @Override
    public void adicionarProduto(Produto produto) throws CodigoJaExisteException{
        if(produtos.buscarProduto(produto.getCodigoProduto()) != null){throw new CodigoJaExisteException(produto.getCodigoProduto());}
        if(produtos.buscarProduto(produto.getCodigoBarra()) != null){ throw new CodigoJaExisteException(produto.getCodigoProduto()); }
        else { produtos.adicionarProduto(produto); }
    }
    @Override
    public Produto buscarProdutoPorCodigo(int codigo) throws ProdutoNaoEncontradoException {

        Produto produto = produtos.buscarProduto(codigo);

        if (produto == null){
            throw new ProdutoNaoEncontradoException();
        }
        else{
            return produto;
        }
    }
    @Override
    public Produto buscarPorCodigoDeBarras(String codigo) throws ProdutoNaoEncontradoException {
        Produto produto = produtos.buscarProduto(codigo);

        if(produto == null){
            throw new ProdutoNaoEncontradoException();
        }
        else {
            return produto;
        }
    }
    @Override
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