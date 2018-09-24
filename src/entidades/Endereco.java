package entidades;

public class Endereco {

    private String rua;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;

    public Endereco(String rua, String bairro, String cidade, String cep, String uf)
    {
        setRua(rua);
        setBairro(bairro);
        setCidade(cidade);
        setCep(cep);
        setUf(uf);
    }

    public String getRua()
    {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getBairro()
    {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString()
    {
        return "Enredeço:" +
                "Rua: " + getRua() + "\n" +
                "Bairro: " + getBairro() + "\n" +
                "Cidade: " + getCidade() + "\n" +
                "CEP: " + getCep() + "\n" +
                "UF: "  + getUf();
    }
}
