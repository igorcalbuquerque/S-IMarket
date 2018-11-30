/**
 *
 *
 *
 * @author Saú Cesar
 */
package negocio.entidades;

import negocio.entidades.abstratas.ProdutoAbstrato;

public class ProdutoNotaFiscal extends ProdutoAbstrato {

    private double valorCompra;
    private double total;

    public ProdutoNotaFiscal(Produto produto,double valorCompra,double quant){
        super(produto,quant);
        this.valorCompra = valorCompra;
        this.total = valorCompra*quant;
    }
    public double getValorCompra(){
        return this.valorCompra;
    }
    public void setValorCompra(double valorCompra){
        this.valorCompra = valorCompra;
        this.total = valorCompra*this.getQuantidade();
    }
    public double getTotal(){ return total; }
    public void setTotal(double total){
        this.total = total;
        this.valorCompra = total/this.getQuantidade();
    }

    @Override
    public String toString(){
        String str = "CODIGO : " + this.getProduto().getCodigoProduto() + " CODIGO BARRA :" + this.getProduto().getCodigoBarra() +
                     " DESCRICAO : " + this.getProduto().getDescricao() + " VALOR COMPRA : " + this.valorCompra +
                     " QUANTIDADE : " + this.getQuantidade() + "TOTAL : " + getTotal() + "\n";
        return str;
    }
}
