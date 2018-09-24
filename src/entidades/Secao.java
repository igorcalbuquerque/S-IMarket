package entidades;

public class Secao {

    private Produto produto;
    private String descricao;

    public Secao(String descricao)
    {
        setDescricao(descricao);

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return  getDescricao();
    }
}
