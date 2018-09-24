package entidades;

public class Produto {

    private static int codigoProduto = 1;
    private String descricao;
    private double valorCompra;
    private double valorVenda;


    public Produto(String descricao, double valorCompra, double valorVenda)
    {
        setDescricao(descricao);
        setValorCompra(valorCompra);
        setValorVenda(valorVenda);

    }

    public String getDescricao()
    {
        return descricao;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
    public double getValorCompra()
    {
        return valorCompra;
    }
    public void setValorCompra(double valorCompra)
    {
        this.valorCompra = valorCompra;
    }
    public double getValorVenda()
    {
        return valorVenda;
    }
    public void setValorVenda(double valorVenda)
    {
        this.valorVenda = valorVenda;
    }
    public static int getProximoCodigoProduto()
    {
        return codigoProduto++;
    }
    //


    @Override
    public String toString(){
        return "PRODUTO:" +
               "Código do Produto: " + getProximoCodigoProduto() + "\n" +
               "Descrição: " + getDescricao() + "\n" +
               "Valor Compra: " + getValorCompra() + "\n" +
               "Valor Venda: " + getValorVenda();

    }
}
