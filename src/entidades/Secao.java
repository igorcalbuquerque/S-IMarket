package entidades;

public class Secao {

    private int codigo;
    private String descricao;

    public Secao(int codigo, String descricao)
    {
        setCodigo(codigo);
        setDescricao(descricao);
    }
    public int getCodigo(){return codigo;}
    public void setCodigo(int novoCodigo){ codigo = novoCodigo;}
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return  "Codigo : "+getCodigo() +"\n" + "Descricao : "+getDescricao()+"\n" ;
    }
}
