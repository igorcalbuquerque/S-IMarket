package entidades;

import java.util.ArrayList;
import java.util.Calendar;

public class Carrinho {
    private Calendar data;
    private Cliente cliente;
    private static int codigoDaVenda = 0;
    private int codigo;
    private ArrayList<ProdutoVenda> carrinho;
    private double valorTotal;
    private Funcionario usuario;

    public Carrinho(Funcionario user){
        this.cliente = null;
        this.data = Calendar.getInstance();
        this.codigo = getProximoCodigoDaVenda();
        this.carrinho = new ArrayList<ProdutoVenda>();
        this.valorTotal = 0;
        this.usuario = user;
    }
    public void atribuirCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public void removerCliente(){
        this.cliente = null;
    }
    public int getProximoCodigoDaVenda(){ return codigoDaVenda++; }

    public void adicionarItem(Produto produto, double quantidade){
        ProdutoVenda produtoVenda = new ProdutoVenda(produto, quantidade);
        carrinho.add(produtoVenda);
        getValorTotal();
    }
    public void removerItem(String codigo){
        for(ProdutoVenda pv:carrinho){
            if(pv.getProduto().getCodigoBarra().equals(codigo)){
                carrinho.remove(pv);
                break;
            }
        }
    }
    public int getCodigo(){
        return codigo;
    }
    public Calendar getData(){
        return  data;
    }
    private String toStringProdutosVenda(){
        String produtos = "";
        for(ProdutoVenda p:carrinho){
            produtos += p.toString();
        }
        return produtos;
    }
    public ProdutoVenda buscarProduto(String codigo){
        for(ProdutoVenda produtoVenda:this.carrinho){
            if(produtoVenda.getProduto().getCodigoBarra().equals(codigo)){
                return produtoVenda;
            }
        }
        System.out.println("Produto nao Encotrado!!!");
        return null;
    }
    public double getValorTotal(){
        this.valorTotal = 0;
        for(ProdutoVenda p:carrinho){
            valorTotal+= p.getTotal();
        }
        return valorTotal;
    }
    public String listarItens(){
        String lista = "";
        for(ProdutoVenda produtoVenda:this.carrinho){
            lista += produtoVenda.toString();
        }
        lista += "TOTAL : "+getValorTotal();
        return lista;
    }
    @Override
    public String toString(){
        if(cliente != null){
            return data.toString()+"\n"+cliente.toString()+"CODIGO DA VENDA:"+getCodigo()+toStringProdutosVenda()+
                    "\n"+"Total do Carrinho : RS "+getValorTotal();
        }
        else{
            return data.toString()+"\n"+"CODIGO DA VENDA:"+getCodigo()+toStringProdutosVenda();
        }
    }
    public ArrayList<ProdutoVenda> getCarrinho(){
        return carrinho;
    }
}
