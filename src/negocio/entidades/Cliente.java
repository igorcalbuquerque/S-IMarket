/**
 *
 *
 *
 * @author Saú Cesar
 */
package negocio.entidades;

import negocio.entidades.abstratas.Pessoa;

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
    @Override
    public String toString() {
        String str = "NOME: " + getNome() + "\nCPF: " + getCpf() + "\nRG: " + getRg() + "\nTELEFONE: " + getTelefone() +
                     "\nE-MAIL: "+ getEmail() + "\nENDEREÇO: " + getEndereco().toString();
        return str;
    }
    @Override
    public double getDesconto(){
        double desconto = 0;
        if(this.getTotalComprado() > 200 ){
            desconto = 0.10;//equivale a 10% de desconto
            this.zerarTotalComprado();
        }
        return desconto;
    }
}