/**
 *
 *
 *
 * @author Igor Albuquerque
 */
package negocio.entidades;

import java.util.ArrayList;

public class Venda {

    private Data data;
    private Cliente cliente;
    private static int codigoDaVenda = 0;
    private int codigo;
    private ArrayList<ProdutoVenda> carrinho;
    private double valorTotal;
    private Funcionario usuario;

    public Venda(Funcionario user){
        this.cliente = null;
        this.data = new Data();
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
        getValorTotal();
    }
    public int getCodigo(){
        return codigo;
    }
    public Data getData(){
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
        String str = "DATA DA VENDA: " + data.toString() + "\nCLIENTE : ";

        if(cliente != null){ str += cliente.getNome()+" CPF: "+cliente.getCpf()+"\n"; }
        else{ str += "N/A"; }

        str += "CODIGO DA VENDA: "+getCodigo() + "\n"+toStringProdutosVenda()+ "\nTotal do Carrinho : R$ " + getValorTotal();

        return str;
    }
    public Cliente getCliente(){return this.cliente;}
    public Funcionario getUsuario(){return this.usuario;}
    public ArrayList<ProdutoVenda> getCarrinho(){return this.carrinho;}
}
