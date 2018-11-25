/**
 *
 *
 *
 * @author Saú Cesar
 */
package negocio.entidades;

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
    @Override
    public String toString(){
        String str = "CODIGO : "+this.getProduto().getCodigoProduto() +" CODIGO BARRA :"+this.getProduto().getCodigoBarra()+" DESCRICAO : "+
                this.getProduto().getDescricao()+" VALOR COMPRA : "+this.valorCompra+" QUANTIDADE : "+this.quantidade+"TOTAL : "+getTotal()+
                "\n";
        return str;
    }
}
