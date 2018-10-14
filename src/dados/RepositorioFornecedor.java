package dados;

import entidades.Fornecedor;
import java.util.ArrayList;

public class RepositorioFornecedor {
    private ArrayList<Fornecedor> fornecedores;
    public RepositorioFornecedor(){
        this.fornecedores = new ArrayList<Fornecedor>();
    }
    public Fornecedor buscarFornecedor(int codigo){
        for(Fornecedor fornecedor:this.fornecedores){
            if(fornecedor.getCodigo() == codigo){
                return fornecedor;
            }
        }
        return null;
    }
    public void adicionarFornecedor(Fornecedor fornecedor){
        fornecedores.add(fornecedor);
    }
    public void removerFornecedor(int codigo){
        Fornecedor fornecedor = buscarFornecedor(codigo);
        if(fornecedor!= null){
            fornecedores.remove(fornecedor);
        }
        else{
            System.out.println("Fornecedor nao encontrado!!!");
        }
    }
    public String listarFornecedor(){
        String lista = "";
        for(Fornecedor fornecedor:this.fornecedores){
            lista+=fornecedor.toString();
        }
        return lista;
    }
}
