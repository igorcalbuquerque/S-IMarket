/**
 *
 *
 *
 * @author Saú Cesar
 */
package negocio.entidades;

public class    Produto {

    private static int codigoAutomatico = 0;
    private boolean ativo;
    private int codigoProduto;
    private String codigoBarra;
    private String descricao;
    private double valorCompra;
    private double valorVenda;
    private Secao secao;

    public Produto(int codigo,String codigoBarra,String descricao, double valorCompra, double valorVenda, Secao secao){
        setAtivo(true);
        setCodigoProduto(codigo);
        setCodigoBarra(codigoBarra);
        setDescricao(descricao);
        setValorCompra(valorCompra);
        setValorVenda(valorVenda);
        setSecao(secao);
    }

    public Produto(String codigoBarra,String descricao,double valorCompra ,double valorVenda, Secao secao){
        codigoAutomatico++;
        setAtivo(true);
        setCodigoBarra(codigoBarra);
        setCodigoProduto(codigoAutomatico);
        setDescricao(descricao);
        setValorCompra(valorCompra);
        setValorVenda(valorVenda);
        setSecao(secao);
    }
    public boolean getAtivo(){return this.ativo;}
    public void setAtivo(boolean status){this.ativo = status;}
    public int getCodigoProduto(){return codigoProduto;}
    public void setCodigoProduto(int novoCodigo){
        codigoProduto = novoCodigo;
    }
    public String getCodigoBarra(){return this.codigoBarra;}
    public void setCodigoBarra(String novoCodigo){this.codigoBarra = novoCodigo;}
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
    public Secao getSecao()
    {
        return secao;
    }
    public void setSecao(Secao secao)
    {
        this.secao = secao;
    }
    public boolean equals(Produto produto){
        if(produto != null && this.codigoProduto == produto.getCodigoProduto()){ return true; }
        else { return false; }
    }
    private String getStatus(){
        if(ativo){ return "ATIVO"; }
        else{ return "INATIVO"; }
    }
    @Override
    public String toString(){
        return "STATUS: "+getStatus() + "\nCódigo Interno: " + getCodigoProduto()+"\nCódigo Barra: " + getCodigoBarra() +
               "\nDescrição: "+getDescricao() + "\nValor Compra: "+getValorCompra()+"\nValor Venda: " + getValorVenda() +
               "\nSeção: "+getSecao().getDescricao()+"\n";
    }
}
