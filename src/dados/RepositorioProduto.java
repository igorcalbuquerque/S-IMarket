package dados;

import entidades.Produto;

import java.util.ArrayList;

public class RepositorioProduto {

    private ArrayList<Produto> produtos;

    public RepositorioProduto(){

        this.produtos = new ArrayList<Produto>();
    }
    public void adicionarProduto(Produto produto){
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
    public String listarProdutos(){
        String lista = "";
        for(Produto produto: produtos){
            lista += produto.toString();
        }
        return lista;
    }
}
