/**
 * Validator used to check whether given string is
 * no longer than the specified amount of characters.
 *
 * @author Igor Albuquerque
 */
package dados;

import entidades.*;

public class RepositorioCliente extends RepositorioPessoa {
    public RepositorioCliente(){
        super();
    }
    public String listarClientes(){
        String lista = "";
        for(Pessoa cliente:pessoas){
            lista+=  ((Cliente)cliente).toString();
        }
        return lista;
    }

}
