package entidades;

public class Secao {

    private int codigoProduto;
    private String descricao;

    public Secao(int codigo, String descricao)
    {
        setCodigo(codigo);
        setDescricao(descricao);
    }
    public int getCodigo(){return codigoProduto;}
    public void setCodigo(int novoCodigo){ codigoProduto = novoCodigo;}
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getProximoCodigoProduto()
    {
        return codigoProduto++;
    }

    @Override
    public String toString(){
        return  "Codigo : "+getCodigo() +"\n" + "Descricao : "+getDescricao()+"\n" ;
    }
}
