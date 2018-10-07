package entidades;

public class ProdutoEstoque {

    private Produto produto;
    private double quantidade;

    public ProdutoEstoque(Produto prod, double quant){
        produto = prod;
       quantidade = quant;
    }
    public ProdutoEstoque(Produto prod){
        produto = prod;
        quantidade = 0;
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
        return produto.toString() + " Quantidade : "+quantidade;
    }
}
