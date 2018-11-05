/**
 *
 *
 *
 * @author Saú Cesar
 */
package dados;

import entidades.Produto;
import java.util.ArrayList;

public class RepositorioProduto {

    private ArrayList<Produto> produtos;

    public RepositorioProduto(){

        this.produtos = new ArrayList<Produto>();
    }
    public void adicionarProduto(Produto produto){
        Produto p = this.buscarProduto(produto.getCodigoProduto());
        if (p != null){
            System.out.println("O CODIGO INFORMADO JA EXISTE!!!");
        }else{
            p = this.buscarPorCodBarra(produto.getCodigoBarra());
            if (p!=null){
                System.out.println("O CODIGO INFORMADO JA EXISTE!!!");
            }
            else{
                produtos.add(produto);
            }
        }

        produtos.add(produto);
    }
    public void removerProduto(int codigo){
        Produto produto = buscarProduto(codigo);
        if(produto!= null){
            produtos.remove(produto);
        }
        else{
            System.out.println("O Produto buscado nao existe!!!");
        }
    }
    public Produto buscarProduto(int codigo){
        for(Produto p: produtos){
            if(p.getCodigoProduto() == codigo){
                return p;
            }
        }
        return null;
    }
    public Produto buscarPorCodBarra(String codigo){
        for(Produto produto : this.produtos){
            if(produto.getCodigoBarra().equals(codigo)){
                return produto;
            }
        }
        System.out.println("Produto nao encontrado!!!");
        return null;
    }
    public String listarProdutos(){
        String lista = "";
        for(Produto produto: produtos){
            lista += produto.toString();
        }
        return lista;
    }
}
