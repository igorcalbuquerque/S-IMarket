/**
 *
 *
 *
 * @author Igor Albuquerque
 */
package dados;

import java.util.ArrayList;
import entidades.Pessoa;

public abstract class RepositorioPessoa {

    protected ArrayList<Pessoa> pessoas;

    public RepositorioPessoa(){
        this.pessoas = new ArrayList<Pessoa>();
    }
    public void adicionarPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }
    public Pessoa buscarPessoaPorRg(String rg ){
        for(Pessoa pessoa: pessoas){
            if(pessoa.getRg().equals(rg)){
                return pessoa;
            }
        }
        return null;
    }
    public Pessoa buscarPessoaPorCpf(String cpf ){
        for(Pessoa pessoa: pessoas){
            if(pessoa.getCpf().equals(cpf)){
                return pessoa;
            }
        }
        return null;
    }
    public void removerPessoaPorRg(String rg){

        Pessoa pessoa = buscarPessoaPorRg(rg);
        if(pessoa != null){
            pessoas.remove(pessoa);
        }
        else{
            System.out.println("Nao Existe o Cadastro Buscado!!!");
        }

    }
    public void removerPessoaCpf(String cpf){

        Pessoa pessoa = buscarPessoaPorCpf(cpf);
        if(pessoa != null){
            pessoas.remove(pessoa);
            System.out.println("Removido Com Sucesso!!!");
        }
        else{
            System.out.println("Nao Existe o Cadastro Buscado!!!");
        }

    }
}
