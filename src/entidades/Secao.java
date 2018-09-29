package entidades;

public class Secao {

    private int codigoSecao;
    private String descricao;

    public Secao(String descricao)
    {

        setDescricao(descricao);
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getCodigoProduto(){return codigoSecao;}
    public void setCodigoProduto(int novoCodigo){
        codigoSecao = novoCodigo;
    }


    @Override
    public String toString(){
        return "Descricao : "+getDescricao()+"\n" ;
    }
}
