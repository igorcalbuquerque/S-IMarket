/**
 *
 *
 *
 * @author Saú Cesar
 */
package negocio.entidades;

public class Fornecedor {

    private static int codidoAutomatico = 0;
    private int codigo;
    private String nome;
    private String cnpj;
    private Endereco endereco;

    public Fornecedor(String nome,String cnpj,Endereco endereco){
        codidoAutomatico++;
        setCodigo(codidoAutomatico);
        setCnpj(cnpj);
        setNome(nome);
        this.endereco = endereco;
    }
    public int getCodigo(){return this.codigo;}
    public void setCodigo(int codigo){this.codigo = codigo;}
    public String getNome(){return this.nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getCnpj(){return this.cnpj;}
    public void setCnpj(String cnpj){this.cnpj = cnpj;}
    public Endereco getEndereco(){return this.endereco;}
    public void setEndereco(Endereco endereco){this.endereco = endereco;}
    public boolean equals(Fornecedor fornecedor){
        if(fornecedor != null && this.codigo == fornecedor.getCodigo()){ return true; }
        else{ return false; }
    }
    @Override
    public String toString(){
        return "Codigo : "+getCodigo()+" Nome : "+getNome()+" CNPJ : "+getCnpj()+"\n"+endereco.toString();
    }
    public String informacoesBasicas(){
        return "Codigo : "+getCodigo()+" Nome : "+getNome() + "\n";
    }
}
