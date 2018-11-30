/**
 *
 *
 *
 * @author Igor Albuquerque
 */
package negocio.entidades;

public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;

    public Endereco(String rua,String numero, String bairro, String cidade, String cep, String estado)
    {
        setRua(rua);
        setNumero(numero);
        setBairro(bairro);
        setCidade(cidade);
        setCep(cep);
        setEstado(estado);
    }

    public String getRua()
    {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getNumero(){return numero;}
    public void setNumero(String novoNumero){numero = novoNumero;};
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
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString(){
        String str = "Rua: " + getRua() + "\nNumero: "+getNumero()+ "\nBairro: " + getBairro() + "\nCidade: " + getCidade() +
                     "\nCEP: " + getCep() + "\nESTADO: "  + getEstado()+"\n";
        return str;
    }
}
