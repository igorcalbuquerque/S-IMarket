/**
 *
 *
 *
 * @author Saú Cesar
 */
package dados;

import java.util.ArrayList;

import entidades.*;

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
    public String relatorioVenda(Data dataInicial,Data dataFinal){

        double total = 0;
        String relatorio = "";
        for(Carrinho c: vendas){

            if(c.getData().equals(dataInicial) || c.getData().eDepois(dataInicial) &&
               c.getData().eAntes(dataFinal)||c.getData().equals(dataFinal)) {

                relatorio += c.toString();
                total += c.getValorTotal();

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
        for(Carrinho c: vendas){

            if(c.getCliente()!=null){

                if(c.getCliente().getCpf().equals(cliente.getCpf())){

                    if(c.getData().equals(dataInicial) || c.getData().eDepois(dataInicial) &&
                       c.getData().eAntes(dataFinal)||c.getData().equals(dataFinal)) {

                        relatorio += c.toString();
                        total += c.getValorTotal();

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

        for(Carrinho c: vendas){
            if(c.getUsuario().getCpf().equals(funcionario.getCpf())){

                if(c.getData().equals(dataInicial) || c.getData().eDepois(dataInicial) &&
                   c.getData().eAntes(dataFinal)||c.getData().equals(dataFinal)) {

                    relatorio += c.toString();
                    total += c.getValorTotal();

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

        for(Carrinho c: vendas){

            for(ProdutoVenda produtoVenda:c.getCarrinho()){

                if(produtoVenda.getProduto().getSecao().getCodigo() == secao.getCodigo()){

                    if(c.getData().equals(dataInicial) || c.getData().equals(dataFinal) ||
                            c.getData().eDepois(dataInicial) || c.getData().eAntes(dataFinal)) {

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

        for(Carrinho c: vendas){

            for(ProdutoVenda produtoVenda:c.getCarrinho()){

                if(produtoVenda.getProduto().getCodigoProduto() == produto.getCodigoProduto()){

                    if(c.getData().equals(dataInicial) || c.getData().eDepois(dataInicial) &&
                       c.getData().eAntes(dataFinal)||c.getData().equals(dataFinal)) {

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
