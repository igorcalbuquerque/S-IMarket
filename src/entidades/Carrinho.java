package entidades;

import java.util.ArrayList;

public class Carrinho {

    private static int codigoDaVenda = 0;
    private ArrayList<ProdutoVenda> carrinho;
    private double valorTotal;

    public Carrinho(){
        codigoDaVenda = getProximoCodigoDaVenda();
        this.carrinho = new ArrayList<ProdutoVenda>();
    }
    public int getProximoCodigoDaVenda(){ return codigoDaVenda++; }

    public void adicionarItem(Produto produto, double quantidade){
        ProdutoVenda produtoVenda = new ProdutoVenda(quantidade,produto);
        carrinho.add(produtoVenda);
    }
    public void removerItem(int codigo){
        for(ProdutoVenda pv:carrinho){
            if(pv.getProduto().getCodigoProduto()==codigo){
                carrinho.remove(pv);
                break;
            }
        }
    }
}
