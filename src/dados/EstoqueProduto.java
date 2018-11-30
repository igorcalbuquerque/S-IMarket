/**
 *
 *
 *
 * @author Saú Cesar
 */

package dados;

import dados.interfaces.IEstoqueProduto;
import negocio.entidades.*;
import java.util.ArrayList;

public class EstoqueProduto implements IEstoqueProduto {

    private ArrayList<ProdutoEstoque> estoque;

    public EstoqueProduto(){
        estoque = new ArrayList<ProdutoEstoque>();
    }
    public void adicionarProduto(Produto produto){
        ProdutoEstoque produtoEstoque = new ProdutoEstoque(produto,0);
        estoque.add(produtoEstoque);
    }
    public void decrementar(Venda venda){
        for(ProdutoVenda produtoVenda:venda.getCarrinho()){

            for(ProdutoEstoque produtoEstoque:estoque){
                if(produtoVenda.getProduto().getCodigoBarra() == produtoEstoque.getProduto().getCodigoBarra()){
                    produtoEstoque.decrementar(produtoVenda.getQuantidade());
                }
            }
        }
    }
    public void incrementar(int codigo, double quantidade){
        ProdutoEstoque produtoEstoque = buscarProduto(codigo);
        produtoEstoque.incrementar(quantidade);
    }
    public ProdutoEstoque buscarProduto(int codigo){
        ProdutoEstoque produto = null;

        for(ProdutoEstoque produtoEstoque: estoque){
            if (produtoEstoque.getProduto().getCodigoProduto() == codigo){
                produto = produtoEstoque;
                break;
            }
        }
        return produto;
    }
    public ProdutoEstoque buscarProduto(String codigoBarra){
        ProdutoEstoque produto = null;

        for(ProdutoEstoque produtoEstoque: estoque){
            if (produtoEstoque.getProduto().getCodigoBarra().equals(codigoBarra)){
                produto = produtoEstoque;
                break;
            }
        }

        return produto;
    }
    @Override
    public String toString(){
        String str = "";

        for(ProdutoEstoque produtoEstoque:estoque){
            str += produtoEstoque.toString();
        }

        return str;
    }
    //No caso de uma venda ser cancelada e necessario incrementar o estoque novamente
    public void incrementar(Venda venda){

        for(ProdutoVenda produtoVenda:venda.getCarrinho()){
            for(ProdutoEstoque produtoEstoque:this.estoque){
                if(produtoVenda.getProduto().getCodigoProduto() == produtoEstoque.getProduto().getCodigoProduto()){
                    produtoEstoque.incrementar(produtoVenda.getQuantidade());
                }
            }
        }
    }
    public void incrementar(NotaFiscal nota){

        for(ProdutoNotaFiscal produtoNota:nota.getNota()){
            for(ProdutoEstoque produtoEstoque:this.estoque){
                if(produtoNota.getProduto().getCodigoProduto() == produtoEstoque.getProduto().getCodigoProduto()){
                    produtoEstoque.incrementar(produtoNota.getQuantidade());
                }
            }
        }

    }
    //No caso de exclusao de uma Nota e necessario retirar a quantidades do estoque
    public void decrementar(NotaFiscal nota){
        for(ProdutoNotaFiscal produtoNota:nota.getNota()){

            for(ProdutoEstoque produtoEstoque:this.estoque){

                if(produtoNota.getProduto().getCodigoProduto() == produtoEstoque.getProduto().getCodigoProduto()){
                    produtoEstoque.decrementar(produtoNota.getQuantidade());
                }

            }

        }

    }
    public void removerProduto(int codigo){
        ProdutoEstoque produto = this.buscarProduto(codigo);
        if(produto!=null){
            estoque.remove(produto);
        }
    }
}
