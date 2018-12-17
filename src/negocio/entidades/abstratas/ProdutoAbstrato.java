package negocio.entidades.abstratas;

import negocio.entidades.Produto;

public abstract class ProdutoAbstrato {

    private Produto produto;
    private double quantidade;

    public ProdutoAbstrato(Produto produto,double quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public Produto getProduto(){
        return produto;
    }
    public double getQuantidade(){
        return quantidade;
    }
    public void decrementar(double quant){
        quantidade -= quant;
    }
    public void incrementar(double quant){
        quantidade += quant;
    }
    public String getDescricao(){return produto.getDescricao();}
    public String getCodigoBarra(){return produto.getCodigoBarra();}
    @Override
    public String toString(){
        return "CODIGO: " + produto.getCodigoProduto() + " DESCRICAO: "+produto.getDescricao() + " Quantidade : " + quantidade + "\n";
    }
}
