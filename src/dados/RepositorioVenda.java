/**
 *
 *
 *
 * @author Saú Cesar
 */
package dados;

import java.util.ArrayList;

import dados.interfaces.IRepositorioVendas;
import negocio.entidades.Venda;

import negocio.entidades.*;

public class RepositorioVenda implements IRepositorioVendas {

    private ArrayList<Venda> vendas;

    public RepositorioVenda(){ this.vendas = new ArrayList<Venda>(); }
    public void adicionarVenda(Venda venda){ vendas.add(venda); }
    public void removerVenda(int codigo){
        Venda venda = buscarVenda(codigo);
        vendas.remove(venda);
    }
    public Venda buscarVenda(int codigo){
        Venda venda = null;
        for(Venda v: vendas){
            if(v.getCodigo() == codigo ){
                venda = v;
                break;
            }
        }
        return venda;
    }
    public String relatorioVenda(Data dataInicial,Data dataFinal){
        double total = 0;
        String relatorio = "";

        for(Venda v: vendas){
            if(v.getData().equals(dataInicial) || v.getData().eDepois(dataInicial) &&
               v.getData().eAntes(dataFinal) || v.getData().equals(dataFinal)) {

                relatorio += v.toString();
                total += v.getValorTotal();
            }
        }
        if(relatorio.equals("")){
            return "VAZIO!!!";
        }
        relatorio += "\nTOTAL DO DIA : RS "+total;
        return relatorio;
    }
    public String relatorioVenda(Cliente cliente,Data dataInicial,Data dataFinal){
        double total = 0;
        String relatorio = "";
        for(Venda v: vendas){
            if(v.getCliente()!=null){
                if(v.getCliente().equals(cliente)){
                    if(v.getData().equals(dataInicial) || v.getData().eDepois(dataInicial) &&
                       v.getData().eAntes(dataFinal) || v.getData().equals(dataFinal)) {

                        relatorio += v.toString();
                        total += v.getValorTotal();
                    }
                }
            }
        }

        if(relatorio.equals("")){
            return "VAZIO!!!";
        }
        relatorio += "\nTOTAL DO DIA : RS "+total;
        return relatorio;
    }
    public String relatorioVenda(Funcionario funcionario, Data dataInicial, Data dataFinal){

        double total = 0;
        String relatorio = "";

        for(Venda v: vendas){
            if(v.getUsuario().equals(funcionario)){
                if(v.getData().equals(dataInicial) || v.getData().eDepois(dataInicial) &&
                   v.getData().eAntes(dataFinal) || v.getData().equals(dataFinal)) {

                    relatorio += v.toString();
                    total += v.getValorTotal();
                }
            }
        }

        if(relatorio.equals("")){
            return "VAZIO!!!";
        }
        relatorio += "\nTOTAL DO DIA : RS "+total;
        return relatorio;
    }
    public String relatorioVenda(Secao secao, Data dataInicial, Data dataFinal){

        double total = 0;
        String relatorio = "";

        for(Venda v: vendas){
            for(ProdutoVenda produtoVenda:v.getCarrinho()){
                if(produtoVenda.getProduto().getSecao().equals(secao)){
                    if(v.getData().equals(dataInicial) || v.getData().equals(dataFinal) ||
                            v.getData().eDepois(dataInicial) || v.getData().eAntes(dataFinal)) {

                        relatorio += produtoVenda.toString();
                        total += produtoVenda.getTotal();
                    }
                }
            }
        }

        if(relatorio.equals("")){
            return "VAZIO!!!";
        }
        relatorio += "\nTOTAL DO DIA : RS "+total;
        return relatorio;
    }
    public String relatorioVenda(Produto produto, Data dataInicial, Data dataFinal){

        double total = 0;
        String relatorio = "";

        for(Venda v: vendas){
            for(ProdutoVenda produtoVenda:v.getCarrinho()){
                if(produtoVenda.getProduto().getCodigoProduto() == produto.getCodigoProduto()){
                    if(v.getData().equals(dataInicial) || v.getData().eDepois(dataInicial) &&
                       v.getData().eAntes(dataFinal) || v.getData().equals(dataFinal)) {

                        relatorio += produtoVenda.toString();
                        total += produtoVenda.getTotal();
                    }
                }
            }
        }

        if(relatorio.equals("")){
            return "VAZIO!!!";
        }
        relatorio += "\nTOTAL DO DIA : RS "+total;
        return relatorio;

    }
}
