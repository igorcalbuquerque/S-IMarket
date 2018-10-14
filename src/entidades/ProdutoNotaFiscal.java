package entidades;

public class ProdutoNotaFiscal extends ProdutoEstoque {

    private double valorCompra;

    public ProdutoNotaFiscal(Produto produto,double valorCompra,double quant){
        super(produto,quant);
        this.valorCompra = valorCompra;
    }
    public double getTotal(){
        return getQuantidade()*getValorCompra();
    }
    public double getValorCompra(){
        return this.valorCompra;
    }
}
