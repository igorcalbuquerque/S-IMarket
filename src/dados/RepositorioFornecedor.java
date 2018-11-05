/**
 *
 *
 *
 * @author Saú Cesar
 */

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
    public Fornecedor buscarFornecedor(String cnpj){
        for(Fornecedor fornecedor:fornecedores){
            if(fornecedor.getCnpj().equals(cnpj)){
                return fornecedor;
            }
        }
        return null;
    }
    public void adicionarFornecedor(Fornecedor fornecedor){
        Fornecedor f = buscarFornecedor(fornecedor.getCodigo());
        if(f != null){
            System.out.println("O CODIGO INFORMADO JA EXISTE!!!");
        }else{
            f = buscarFornecedor(fornecedor.getCnpj());
            if (f!=null){
                System.out.println("O CNPJ INFORMADO JA EXISTE!!!");
            }
            else{
                fornecedores.add(fornecedor);
            }
        }
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
    public void removerFornecedor(String cnpj){
        Fornecedor fornecedor = buscarFornecedor(cnpj);
        if(fornecedor!= null){
            fornecedores.remove(fornecedor);
        }
        else{
            System.out.println("Fornecedor nao encontrado!!!");
        }
    }
    public String listarFornecedores(){
        String lista = "";
        for(Fornecedor fornecedor:this.fornecedores){
            lista+=fornecedor.toString();
        }
        return lista;
    }
}
