/**
 *
 *
 *
 * @author Igor Albuquerque
 */
package dados;

import dados.interfaces.IRepositorioSecao;
import negocio.entidades.Secao;
import java.util.ArrayList;

public class RepositorioSecao implements IRepositorioSecao {

    private ArrayList<Secao> secoes;

    public RepositorioSecao(){ secoes = new ArrayList<Secao>(); }
    public void addSecao(Secao secao){ secoes.add(secao); }
    public void removeSecao(int codigo){
        Secao secao = buscarSecao(codigo);
        secoes.remove(secao);
    }
    public Secao buscarSecao(int codigo){
        Secao secao = null;
        for(Secao s:secoes){
            if(s.getCodigo() == codigo){
                secao = s;
                break;
            }
        }
        return secao;
    }
    public String buscarPorDescricao(String descricao){
        String str = "";

        for(Secao secao:this.secoes){
            if(secao.getDescricao().contains(descricao)){
                str += secao.toString();
            }
        }
        return str;
    }
    @Override
    public String toString(){
        String str = "";
        for(Secao s:secoes){
            str += s.toString();
        }
        return str;
    }

}
