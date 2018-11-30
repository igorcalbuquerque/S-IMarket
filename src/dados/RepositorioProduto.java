/**
 *
 *
 *
 * @author Saú Cesar
 */
package dados;

import dados.interfaces.IRepositorioProduto;
import negocio.entidades.Produto;
import java.util.ArrayList;

public class RepositorioProduto implements IRepositorioProduto {

    private ArrayList<Produto> produtos;

    public RepositorioProduto(){ this.produtos = new ArrayList<Produto>(); }
    public void adicionarProduto(Produto produto){ produtos.add(produto); }
    public void removerProduto(int codigo){
        Produto produto = buscarProduto(codigo);
        produtos.remove(produto);
    }
    public Produto buscarProduto(int codigo){
        Produto produto = null;
        for(Produto p: produtos){
            if(p.getCodigoProduto() == codigo){
                produto = p;
                break;
            }
        }
        return produto;
    }
    public Produto buscarProduto(String codigoBarra){
        Produto produto = null;
        for(Produto p: produtos){
            if(p.getCodigoBarra().equals(codigoBarra)){
                produto = p;
                break;
            }
        }
        return produto;
    }
    @Override
    public String toString(){
        String str = "";
        for(Produto produto: produtos){
            str += produto.toString();
        }
        return str;
    }
}
