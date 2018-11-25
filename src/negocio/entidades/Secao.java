/**
 *
 *
 *
 * @author Saú Cesar
 */

package negocio.entidades;

public class Secao {

    private static int codigoAutomatico = 0;
    private int codigo;
    private String descricao;

    public Secao(int codigo, String descricao)
    {
        setCodigo(codigo);
        setDescricao(descricao);
    }
    public Secao(String descricao){
        codigoAutomatico++;
        setCodigo(codigoAutomatico);
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
        return  "Codigo : "+getCodigo() + " Descricao : "+getDescricao()+"\n" ;
    }
}
