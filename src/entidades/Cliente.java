package entidades;

public class Cliente extends Pessoa {

    private String telefone;
    private String email;

    public Cliente(String nome, String rg,String cpf, Endereco endereco) {
        super(nome, rg, cpf, endereco);
    }

    public String getTelefone()
    {
        return telefone;
    }
    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
}
