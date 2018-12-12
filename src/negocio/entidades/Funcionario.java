/**
 *
 *
 * @author Igor Albuquerque
 */
package negocio.entidades;

import negocio.entidades.abstratas.Pessoa;
import negocio.entidades.interfaces.IAutenticavel;

public class Funcionario extends Pessoa implements IAutenticavel {

    private boolean gerente;
    private double salario;
    private String login;
    private String senha;

    public Funcionario(String nome, String rg,String cpf, Endereco endereco, boolean gerente, String login, String senha){
        super(nome, rg,cpf, endereco);

        setLogin(login);
        setCargo(gerente);
        setSenha(senha);
    }
    public Funcionario(String nome, String rg,String cpf, Endereco endereco, boolean gerente,String senha) {
        super(nome, rg,cpf, endereco);
        setLogin(cpf);
        setCargo(gerente);
        setSenha(senha);
    }
    public double getSalario(){return this.salario;}
    public void setSalario(double salario){this.salario = salario;}
    public boolean isGerente()
    {
        return gerente;
    }
    public void setCargo(boolean gerente)
    {
        this.gerente = gerente;
    }
    public String getSenha()
    {
        return senha;
    }
    public void setSenha(String senha)
    {
        this.senha = senha;
    }
    public String getLogin(){return this.login;}
    public void setLogin(String login){this.login = login;}
    private String getCargo() {
        if (gerente) { return "Gerente"; }
        else { return "Associado"; }
    }
    @Override
    public double getDesconto(){
        double desconto = 0;
        if(this.getTotalComprado() > 200 ){
            desconto = 0.20;// equivale a 20% de desconto
            this.zerarTotalComprado();
        }
        return desconto;
    }
    @Override
    public String toString() {
        String str = "NOME: " + getNome() + "\nRG : " + getRg()+"\nCPF: " + getCpf()  +
                     "\nCARGO: " + getCargo() + "\nSALARIO: R$ "+getSalario() + "\n"+ getEndereco().toString();
        return str;
    }

    @Override
    public boolean logar(String login, String senha) {
        if(this.login.equals(login) || this.login.equals(this.getCpf()) && this.senha.equals(senha)){return true;}
        else{ return false; }
    }
}
