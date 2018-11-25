/**
 *
 *
 *
 * @author Igor Albuquerque
 */

package dados;

import negocio.entidades.Funcionario;
import negocio.entidades.Pessoa;

public class RepositorioFuncionario extends RepositorioPessoa {

    public RepositorioFuncionario(){
        super();
    }
    public String listarFucionarios(){
        String lista = "";
        for(Pessoa funcionario:pessoas){
            lista += "==========================================\n";
            lista+= ((Funcionario)funcionario).toString();
        }
        return  lista;
    }
    public Funcionario buscarPorLogin(String login){
        for(Pessoa funcionario:this.pessoas){
            if(((Funcionario)funcionario).getLogin().equals(login) || ((Funcionario)funcionario).getCpf().equals(login)){
                return (Funcionario)funcionario;
            }
        }
        return null;
    }
}