/**
 *
 *
 *
 * @author Igor Albuquerque
 */
package negocio.entidades;

import negocio.entidades.abstratas.ProdutoAbstrato;

public class ProdutoVenda extends ProdutoAbstrato {

    private double valorCompra;
    private double valorVenda;

    public ProdutoVenda(Produto produto,double quant){
        super(produto,quant);
        this.valorCompra = produto.getValorCompra();
        this.valorVenda = produto.getValorVenda();
    }
    public double getTotal(){ return this.getQuantidade()*getValorVenda(); }
    public double getValorCompra(){return this.valorCompra;}
    public double getValorVenda(){return this.valorVenda;}
    @Override
    public String toString(){
        return "Codigo Barra: " + getProduto().getCodigoBarra() + " Descricao : " + getProduto().getDescricao() +
               " Quantidade: "+getQuantidade() + " Preco : "+getValorVenda() + " Total : RS "+getTotal()+"\n";
    }
}