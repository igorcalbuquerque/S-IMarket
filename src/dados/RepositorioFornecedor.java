/**
 *
 *
 *
 * @author Saú Cesar
 */

package dados;

import dados.interfaces.IRepositorioFornecedor;
import negocio.entidades.Fornecedor;
import java.util.ArrayList;

public class RepositorioFornecedor implements IRepositorioFornecedor {

    private ArrayList<Fornecedor> fornecedores;

    public RepositorioFornecedor(){ this.fornecedores = new ArrayList<Fornecedor>(); }
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
    public void adicionarFornecedor(Fornecedor fornecedor){ fornecedores.add(fornecedor); }
    public void removerFornecedor(int codigo){
        Fornecedor fornecedor = buscarFornecedor(codigo);
        if(fornecedor!= null){ fornecedores.remove(fornecedor); }
    }
    public void removerFornecedor(String cnpj){
        Fornecedor fornecedor = buscarFornecedor(cnpj);
        if(fornecedor!= null){ fornecedores.remove(fornecedor); }
    }
    @Override
    public String toString(){
        String str = "";
        for(Fornecedor fornecedor:this.fornecedores){
            str += fornecedor.toString();
        }
        return str;
    }
}
