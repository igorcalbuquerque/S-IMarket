package entidades;

import java.util.Calendar;
import java.util.ArrayList;

public class NotaFiscal {
    private int numero;
    private int serie;
    private String dataEmissao;
    private Calendar dataEntrada;
    private Fornecedor fornecedor;
    private ArrayList<ProdutoVenda> nota;
    public NotaFiscal(int numero, int serie,String dataEmissao,Fornecedor fornecedor){
        this.numero = numero;
        this.serie = serie;
        this.dataEmissao = dataEmissao;
        this.dataEntrada = Calendar.getInstance();
        this.fornecedor = fornecedor;
        this.nota = new ArrayList<ProdutoVenda>();
    }
    public void adicionarProduto(Produto produto,double valorCompra,double valorVenda, double quantidade){
        ProdutoVenda produtoVenda = new ProdutoVenda(produto,valorCompra,valorVenda,quantidade);
        nota.add(produtoVenda);
    }
    public void removerProduto(int codigo){
        ProdutoVenda produtoVenda = buscarProduto(codigo);
        if(produtoVenda !=null){
            nota.remove(produtoVenda);
        }else{
            System.out.println("Produto nao contido nesta nota!!!");
        }
    }
    private ProdutoVenda buscarProduto(int codigo){
        for(ProdutoVenda produtoVenda:this.nota){
            if(produtoVenda.getProduto().getCodigoProduto() == codigo||produtoVenda.getProduto().getCodigoBarra() == codigo){
                return produtoVenda;
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
    public ArrayList<ProdutoVenda> getNota(){return this.nota;}
    public String getDataEmissao(){return this.dataEmissao;}
    public void setDataEmissao(String data){this.dataEmissao = data;}
    public Calendar getDataEntrada(){return this.dataEntrada;}
    public double getTotal(){
        double total = 0;
        for(ProdutoVenda produtoVenda:this.nota){
            total += produtoVenda.getTotal();
        }
        return total;
    }
    public String toString(){
        String str = "Numero : "+getNumero()+"Serie : "+getSerie()+"\nData de Emissao :"+getDataEmissao()+"\n"+
               fornecedor.toString();
        double total = 0;

        for(ProdutoVenda produtoVenda:this.nota){
            str += produtoVenda.toString();
            total += produtoVenda.getTotal();
        }
        str += "\nTOTAL : "+total;
        return str;
    }
    public String toStringBasico(){
        return "Numero : "+getNumero()+"Serie : "+getSerie()+"\nData de Emissao :"+getDataEmissao()+
                "Data de Entrada : "+getDataEntrada().DAY_OF_MONTH+" - "+getDataEntrada().MONTH+" - "+
                getDataEntrada().YEAR+"\nTotal da Nota :"+getTotal()+"\n";
    }
}