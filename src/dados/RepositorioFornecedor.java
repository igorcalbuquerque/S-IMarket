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
}
