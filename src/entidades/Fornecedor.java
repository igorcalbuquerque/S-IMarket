package entidades;

public class Fornecedor {
    private int codigo;
    private String nome;
    private String cnpj;
    private Endereco endereco;
    public Fornecedor(int codigo,String nome,Endereco endereco){
        setCodigo(codigo);
        setNome(nome);
        this.endereco = endereco;
    }
    public int getCodigo(){return this.codigo;}
    public void setCodigo(int codigo){this.codigo = codigo;}
    public String getNome(){return this.nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getCnpj(){return this.cnpj;}
    public void setCnpj(String cnpj){this.cnpj = cnpj;}

    @Override
    public String toString(){
        return "Codigo : "+getCodigo()+"\nNome : "+getNome()+"\nCNPJ : "+getCnpj()+"\n"+endereco.toString();
    }
}
