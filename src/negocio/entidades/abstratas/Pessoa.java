/**
 *
 *
 *
 * @author Igor Albuquerque
 */
package negocio.entidades.abstratas;

import negocio.entidades.Endereco;

public abstract class Pessoa {

    private String nome;
    private String rg;
    private String cpf;
    private Endereco endereco;
    private double totalComprado;

    public Pessoa(String nome, String rg,String cpf, Endereco endereco) {
        setNome(nome);
        setRg(rg);
        setCpf(cpf);
        this.endereco = endereco;
        this.totalComprado = 0;
    }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getRg(){return this.rg;}
    public void setRg(String rg){this.rg = rg;}
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco end){this.endereco = end;}
    public abstract double getDesconto();
    public void adicionarValorComprado(double valor){ this.totalComprado += valor;}
    public double getTotalComprado(){return this.totalComprado;}
    public void zerarTotalComprado(){this.totalComprado = 0;}
}
