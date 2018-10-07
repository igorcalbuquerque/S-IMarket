package dados;

import entidades.Funcionario;
import entidades.Pessoa;

public class RepositorioFuncionario extends RepositorioPessoa {

    public RepositorioFuncionario(){
        super();
    }
    public String listarFucionarios(){
        String lista = "";
        for(Pessoa funcionario:pessoas){
            lista += "===========================================\n";
            lista+= ((Funcionario)funcionario).toString();
        }
        return  lista;
    }
}