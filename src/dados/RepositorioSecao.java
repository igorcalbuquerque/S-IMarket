/**
 * Validator used to check whether given string is
 * no longer than the specified amount of characters.
 *
 * @author Igor Albuquerque
 */
package dados;

import entidades.Secao;
import java.util.ArrayList;

public class RepositorioSecao {

    private ArrayList<Secao> secoes;

    public RepositorioSecao(){
        secoes = new ArrayList<Secao>();
    }
    public void addSecao(Secao secao){
        secoes.add(secao);
    }
    public void removeSecao(int codigo){
        Secao secao = buscarSecao(codigo);
        if(secao !=null){
            secoes.remove(secao);
        }
        else{
            System.out.println("A Secao informada NAO existe!!!");
        }
    }
    public Secao buscarSecao(int codigo){
        for(Secao s:secoes){
            if(s.getCodigo() == codigo){
                return s;
            }
        }
        return null;
    }
    public String listarSecoes(){
        String lista = "";
        for(Secao s:secoes){
            lista+= s.toString();
        }
        return lista;
    }
}
