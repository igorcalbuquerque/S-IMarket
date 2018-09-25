package entidades;

public abstract class Pessoa {

    private String nome;
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
