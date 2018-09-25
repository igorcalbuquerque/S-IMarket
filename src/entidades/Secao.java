package entidades;

public class Secao {

    private static int codigoProduto = 1;
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
    public static int getProximoCodigoProduto()
    {
        return codigoProduto++;
    }

    @Override
    public String toString(){
        return  getDescricao();
    }
}
