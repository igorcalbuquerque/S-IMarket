package entidades;

public class Secao {

    private static int codigo = 0;
    private String descricao;

    public Secao(String descricao)
    {
        setCodigo(getProximoCodigo());
        setDescricao(descricao);
    }
    public int getCodigo()
    {return codigo;
    }
    public void setCodigo(int novoCodigo)
    {
        this.codigo = novoCodigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getProximoCodigo()
    {
        return ++this.codigo;
    }

    @Override
    public String toString(){
        return  "Codigo : "+getCodigo() +"\n" + "Descricao : "+getDescricao()+"\n" ;
    }
}
