/**
 *
 *
 *
 * @author Igor Albuquerque
 */
package entidades;

public abstract class Pessoa {

    protected String nome;
    protected String rg;
    protected String cpf;
    protected Endereco endereco;

    public Pessoa(String nome, String rg,String cpf, Endereco endereco)
    {
        setNome(nome);
        setRg(rg);
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
