package entidades;

public class ProdutoVenda {

    private Produto produto;
    private double quantidade;
    private double valorCompra;
    private double valorVenda;

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
    public double getTotal(){
        return quantidade*getProduto().getValorVenda();
    }
    public double getValorCompra(){return valorCompra;}
    public void setValorCompra(double valorCompra){this.valorCompra = valorCompra;}
    public double getValorVenda(){return valorVenda;}
    public void getValorVenda(double ValorVenda){this.valorVenda = ValorVenda;}

    @Override
    public String toString()
    {
        return "Produto: " + getProduto().toString() + " Quantidade: " + getQuantidade()+" valorCompra : "+produto.getValorCompra()+
                " Total : RS "+getTotal()+"\n";
    }
}