package entidades;

public class ProdutoVenda extends ProdutoEstoque{

    private double valorCompra;
    private double valorVenda;

    public ProdutoVenda(Produto produto,double quant){
        super(produto,quant);
        this.valorCompra = produto.getValorCompra();
        this.valorVenda = produto.getValorVenda();
    }
    public void setQuantidade(double quant){
        quantidade = quant;
    }
    public double getTotal(){
        return quantidade*getProduto().getValorVenda();
    }
    public double getValorCompra(){return this.valorCompra;}
    public double getValorVenda(){return this.valorVenda;}
    @Override
    public String toString(){
        return "Codigo Barra: "+produto.getCodigoBarra()+" Descricao : "+produto.getDescricao()+" Quantidade: "+getQuantidade()+
               " Preco : "+produto.getValorVenda()+" Total : RS "+getTotal()+"\n";
    }
}