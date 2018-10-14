package entidades;

public class Funcionario extends Pessoa {

    private String cargo;
    private String login;
    private String senha;

    public Funcionario(String nome, String rg,String cpf, Endereco endereco, String cargo, String login, String senha){
        super(nome, rg,cpf, endereco);
        setLogin(login);
        setCargo(cargo);
        setSenha(senha);
    }
    public Funcionario(String nome, String rg,String cpf, Endereco endereco, String cargo,String senha) {
        super(nome, rg,cpf, endereco);
        setLogin(cpf);
        setCargo(cargo);
        setSenha(senha);
    }
    public String getRg(){return this.rg;}
    public void setRg(String rg){this.rg = rg;}
    public String getCargo()
    {
        return cargo;
    }
    public void setCargo(String cargo)
    {
        this.cargo = cargo;
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

    @Override
    public String toString()
    {
        return "Nome: " + getNome() + "\nRG : "+getRg()+"\nCPF: " + getCpf()  + "\n"+getEndereco().toString();
    }
}
