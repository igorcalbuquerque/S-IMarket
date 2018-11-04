/**
 * Validator used to check whether given string is
 * no longer than the specified amount of characters.
 *
 * @author Saú Cesar
 */
package entidades;

public class Fornecedor {
    private int codigo;
    private String nome;
    private String cnpj;
    private Endereco endereco;
    public Fornecedor(int codigo,String nome,String cnpj,Endereco endereco){
        setCodigo(codigo);
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
    @Override
    public String toString(){
        return "Codigo : "+getCodigo()+"\nNome : "+getNome()+"\nCNPJ : "+getCnpj()+"\n"+endereco.toString();
    }
}
