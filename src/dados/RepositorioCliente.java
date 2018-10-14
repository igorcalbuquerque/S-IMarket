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
