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
}
