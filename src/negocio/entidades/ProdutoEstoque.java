/**
 *
 *
 *
 * @author Igor Albuquerque
 */
package negocio.entidades;

public class ProdutoEstoque {

    protected Produto produto;
    protected double quantidade;

    public ProdutoEstoque(Produto prod, double quant){
        this.produto = prod;
        this.quantidade = quant;
    }
    public ProdutoEstoque(Produto prod){
        this.produto = prod;
        this.quantidade = 0;
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
    @Override
    public String toString(){
        return produto.toString() + "Quantidade : "+quantidade+"\n";
    }
}
