package entidades;

public class Funcionario extends Pessoa {

    private String cargo;
    private String senha;

    public Funcionario(String nome, String cpf, Endereco endereco, String cargo, String senha) {
        super(nome, cpf, endereco);
        setCargo(cargo);
        setSenha(senha);
    }

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


    @Override
    public String toString()
    {
        return "Funcionario" + "\n" +
                "Nome: " + getNome() + "\n" +
                "CPF: " + getCpf()  + "\n" +
                getEndereco();
    }

}
