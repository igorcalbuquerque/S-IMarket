/**
 *
 *
 *
 * @author Igor Albuquerque
 */

package dados;

import dados.interfaces.IRepositorioFuncionario;
import negocio.entidades.Funcionario;
import negocio.entidades.abstratas.Pessoa;

public class RepositorioFuncionario extends RepositorioPessoa implements IRepositorioFuncionario {

    public RepositorioFuncionario(){
        super();
    }

    public Funcionario buscarPorLogin(String login){
        for(Pessoa funcionario:this.getPessoas()){
            if(((Funcionario)funcionario).getLogin().equals(login) || ((Funcionario)funcionario).getCpf().equals(login)){
                return (Funcionario)funcionario;
            }
        }
        return null;
    }

    public String relatorioGastos(){
        String str = "";
        double total = 0;
        for(Pessoa funcionario: this.getPessoas()){
            str += "NOME: " + funcionario.getNome() + " CPF: "+funcionario.getCpf() +
                   "SALARIO: R$: " + ((Funcionario)funcionario).getSalario();
        }

        str += "TOTAL: R$ " + total;

        return str;
    }
}