/**
 *
 *
 *
 * @author Saú Cesar
 */
package entidades;

public class Cliente extends Pessoa {

    private String telefone;
    private String email;

    public Cliente(String nome, String rg,String cpf, Endereco endereco, String telefone, String email) {
        super(nome, rg, cpf, endereco);
        setEmail(email);
        setTelefone(telefone);
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

    public String toString()
    {
        return "NOME: " + getNome() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "RG: " + getRg() + "\n" +
                "TELEFONE: " + getTelefone() + "\n"+
                "E-MAIL: "+ getEmail() + "\n" +
                "ENDEREÇO: " + getEndereco();
    }
}
