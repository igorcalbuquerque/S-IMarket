package entidades;

public class ProdutoVenda {
    private Produto produto;
    private double quantidade;
    public ProdutoVenda(Double quant,Produto p){
        setQuantidade(quant);
        setProduto(p);
    }
    public double getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(double quant){
        quantidade = quant;
    }
    public Produto getProduto(){
        return produto;
    }
    public void setProduto(Produto p ){
        produto = p;
    }
    public void setProdutoVenda(Produto novoProduto) {
        produto= novoProduto;
    }

    @Override
    public String toString()
    {
        return "Produto: " + getProduto() + "\n" +
                "Quantidade: " + getQuantidade();
    }
}