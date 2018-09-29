package entidades;

public class Carrinho {

    private int codigoDaVenda = 1;
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public Carrinho(Produto produto, int quantidade)
    {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = produto.getValorVenda() * quantidade;
    }

    public int getProximoCodigoDaVenda(){ return codigoDaVenda++; }
}
