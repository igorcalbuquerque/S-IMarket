package entidades;

public abstract class Pessoa {

    private String nome;
    private String rg;
    private String cpf;
    private Endereco endereco;

    public Pessoa(String nome, String cpf, Endereco endereco)
    {
        setNome(nome);
        setCpf(cpf);
        this.endereco = endereco;
    }

    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public String getRg(){return this.rg;}
    public void setRg(String rg){this.rg = rg;}
    public String getCpf()
    {
        return cpf;
    }
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public Endereco getEndereco()
    {
        return endereco;
    }
}
