/**
 *
 *
 *
 * @author Igor Albuquerque
 */
package dados;

import java.util.ArrayList;

import dados.interfaces.IRepositorioPessoa;
import negocio.entidades.abstratas.Pessoa;

public class RepositorioPessoa implements IRepositorioPessoa {

    private ArrayList<Pessoa> pessoas;

    public ArrayList<Pessoa> getPessoas(){return pessoas;}
    public RepositorioPessoa(){
        this.pessoas = new ArrayList<Pessoa>();
    }
    public void adicionarPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }
    public String buscarPorNome(String nome){
        String str = "";

        for(Pessoa pessoa:this.pessoas){
            if(pessoa.getNome().contains(nome)){
                str += pessoa.toString();
            }
        }
        return str;
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
    }
    public void removerPessoaPorCpf(String cpf){
        Pessoa pessoa = buscarPessoaPorCpf(cpf);
        if(pessoa != null){
            pessoas.remove(pessoa);
        }
    }
    @Override
    public String toString(){
        String str = "";
        for(Pessoa pessoa:this.pessoas){
            str += "==========================================\n";
            str += pessoa.toString();
        }
        str += "==========================================\n";

        return str;
    }
}
