/**
 *
 *
 * @author Saú Cesar
 */
package negocio.entidades;

import java.util.Calendar;
import java.util.ArrayList;

public class NotaFiscal {

    private int numero;
    private int serie;
    private Data dataEmissao;
    private Data dataEntrada;
    private Data dataPagamento;
    private Fornecedor fornecedor;
    private ArrayList<ProdutoNotaFiscal> nota;

    public NotaFiscal(int numero, int serie,Data dataEmissao,Data dataPagamento,Fornecedor fornecedor){
        this.numero = numero;
        this.serie = serie;
        this.dataEmissao = dataEmissao;
        this.dataEntrada = new Data();
        this.dataPagamento = dataPagamento;
        this.fornecedor = fornecedor;
        this.nota = new ArrayList<ProdutoNotaFiscal>();
    }
    public void adicionarProduto(Produto produto,double valorCompra, double quantidade){
        ProdutoNotaFiscal produtoNotaFiscal = new ProdutoNotaFiscal(produto,valorCompra,quantidade);
        nota.add(produtoNotaFiscal);
    }
    public void removerProduto(int codigo){
        ProdutoNotaFiscal produtoVenda = buscarProduto(codigo);
        if(produtoVenda !=null){
            nota.remove(produtoVenda);
        }
    }
    private ProdutoNotaFiscal buscarProduto(int codigo){
        for(ProdutoNotaFiscal produto:this.nota){
            if(produto.getProduto().getCodigoProduto() == codigo){
                return produto;
            }
        }
        return null;
    }
    private ProdutoNotaFiscal buscarProduto(String codigo){
        for(ProdutoNotaFiscal produto:this.nota){
            if(produto.getProduto().getCodigoBarra().equals(codigo)){
                return produto;
            }
        }
        return null;
    }
    public int getNumero(){return this.numero;}
    public void setNumero(int numero){this.numero = numero;}
    public int getSerie(){return this.serie;}
    public void setSerie(int serie){this.serie = serie;}
    public Fornecedor getFornecedor(){return this.fornecedor;}
    public void setFornecedor(Fornecedor fornecedor){this.fornecedor = fornecedor;}
    public ArrayList<ProdutoNotaFiscal> getNota(){return this.nota;}
    public Data getDataEmissao(){return this.dataEmissao;}
    public void setDataEmissao(Data data){this.dataEmissao = data;}
    public Data getDataEntrada(){return this.dataEntrada;}
    public double getTotal(){
        double total = 0;
        for(ProdutoNotaFiscal produto:this.nota){
            total += produto.getTotal();
        }
        return total;
    }
    @Override
    public String toString(){
        String str = "Numero : " + getNumero() + "Serie : "+getSerie() + "\nData de Emissao : " + getDataEmissao() +
                     "\nData de Entrada : " + dataEntrada.toString() + "\nVencimento: " + dataPagamento.toString() +
                     "\n" + fornecedor.toString();

        double total = 0;

        for(ProdutoNotaFiscal produto:this.nota){
            str += produto.toString();
            total += produto.getTotal();
        }
        str += "\nTOTAL DA NOTA : " + total;
        return str;
    }
    public String toStringBasico(){
        return "Numero: "+getNumero() + " Serie: "+getSerie() + "\nData de Emissao :" + getDataEmissao().toString()+
               " Data de Entrada : " + dataEntrada.toString() + " Vencimento: "+dataPagamento.toString() + "\n" +
                fornecedor.informacoesBasicas() + "Total da Nota :"+getTotal()+"\n";
    }
}