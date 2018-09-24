package entidades;

public class Produto {

    private int codigoProduto = 0;
    private String descricao;
    private double valorCompra;
    private double valorVenda;


    public Produto(String descricao, double valorCompra, double valorVenda)
    {
        setDescricao(descricao);
        setValorCompra(valorCompra);
        setValorVenda(valorVenda);
        if (this.codigoProduto == 0)
        {
            this.codigoProduto = 1;
        }
        else
        {
            this.codigoProduto++;
        }
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
    public int getCodigoProduto()
    {
        return codigoProduto;
    }


    @Override
    public String toString(){
        return "PRODUTO:" +
               "Código do Produto: " + getCodigoProduto() + "\n" +
               "Descrição: " + getDescricao() + "\n" +
               "Valor Compra: " + getValorCompra() + "\n" +
               "Valor Venda: " + getValorVenda();

    }
}
