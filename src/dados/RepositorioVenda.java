package dados;

import java.util.ArrayList;
import java.util.Calendar;

import entidades.Carrinho;

public class RepositorioVenda {
    private ArrayList<Carrinho> vendas;

    public RepositorioVenda(){
        this.vendas = new ArrayList<Carrinho>();
    }
    public void adicionarVenda(Carrinho carrinho){
        vendas.add(carrinho);
    }
    public void removerVenda(int codigo){
        Carrinho carrinho = buscarCarrinho(codigo);
        if(carrinho != null){
            vendas.remove(carrinho);
            System.out.println("A COMPRA FOI REMOVIDA!!!");
        }
        else{
            System.out.println("A COMPRA BUSCADA NAO EXISTE!!!");
        }
    }
    public Carrinho buscarCarrinho(int codigo){
        for(Carrinho c: vendas){
            if(c.getCodigo() == codigo ){
                return c;
            }
        }
        return null;
    }
    public String relatorioVendaDia(int dia, int mes,int ano){
        String diaSolicitado = dia+"-"+mes+"-"+ano;
        double total = 0;
        String relatorio = "";
        for(Carrinho c: vendas){
            String diaCarrinho = c.getData().DAY_OF_MONTH+"-"+c.getData().MONTH+"-"+c.getData().YEAR;
            if(diaSolicitado.equals(diaCarrinho)){
                relatorio += c.toString();
                total += c.getValorTotal();
            }
        }
        relatorio += "TOTAL DO DIA : RS "+total;
        return relatorio;
    }
}
