package negocio;

import dados.RepositorioVenda;
import dados.interfaces.IRepositorioVenda;
import negocio.entidades.*;
import negocio.excessoes.DataInvalidaException;
import negocio.excessoes.RelatorioVazioException;
import negocio.excessoes.VendaNaoEncotradaException;
import negocio.interfaces.INegocioVenda;
import negocio.validacao.ValidaDados;

public class NegocioVenda implements INegocioVenda {
    private IRepositorioVenda repositorioVenda;
    public NegocioVenda(){this.repositorioVenda = new RepositorioVenda(); }
    @Override
    public void adicionarVenda(Venda venda) {
        if(venda.getCliente() != null){
            venda.getCliente().adicionarValorComprado(venda.getValorTotal());
        }
        repositorioVenda.adicionarVenda(venda);
    }
    @Override
    public void removerVenda(int codigo) throws VendaNaoEncotradaException {
        Venda v = this.buscarVenda(codigo);
        if(v != null){ repositorioVenda.removerVenda(codigo); }
        else{ throw new VendaNaoEncotradaException(codigo); }
    }
    @Override
    public Venda buscarVenda(int codigo) throws VendaNaoEncotradaException {
        Venda v = this.buscarVenda(codigo);
        if(v == null){ throw new VendaNaoEncotradaException(codigo);}
        return v;
    }
    @Override
    public String relatorioVenda(Data dataInicial, Data dataFinal) throws DataInvalidaException, RelatorioVazioException {
        ValidaDados validaDados = ValidaDados.getInstance();
        if(!validaDados.isData(dataInicial)){ throw new DataInvalidaException(dataInicial.toString()); }
        if(!validaDados.isData(dataFinal)){ throw new DataInvalidaException(dataInicial.toString());}
        else{
            String str = repositorioVenda.relatorioVenda(dataInicial,dataFinal);
            if(str.equals("")){ throw new RelatorioVazioException();}
            return str;
        }
    }
    @Override
    public String relatorioVenda(Cliente cliente, Data dataInicial, Data dataFinal) throws DataInvalidaException,RelatorioVazioException{
        ValidaDados validaDados = ValidaDados.getInstance();
        if(!validaDados.isData(dataInicial)){ throw new DataInvalidaException(dataInicial.toString()); }
        if(!validaDados.isData(dataFinal)){ throw new DataInvalidaException(dataInicial.toString());}
        else{
            String str = repositorioVenda.relatorioVenda(cliente,dataInicial,dataFinal);
            if(str.equals("")){ throw new RelatorioVazioException();}
            return str;
        }
    }
    @Override
    public String relatorioVenda(Funcionario funcionario, Data dataInicial, Data dataFinal) throws DataInvalidaException,RelatorioVazioException{
        ValidaDados validaDados = ValidaDados.getInstance();
        if(!validaDados.isData(dataInicial)){ throw new DataInvalidaException(dataInicial.toString()); }
        if(!validaDados.isData(dataFinal)){ throw new DataInvalidaException(dataInicial.toString());}
        else{
            String str = repositorioVenda.relatorioVenda(funcionario,dataInicial,dataFinal);
            if(str.equals("")){ throw new RelatorioVazioException();}
            return str;
        }
    }
    @Override
    public String relatorioVenda(Secao secao, Data dataInicial, Data dataFinal) throws DataInvalidaException,RelatorioVazioException {
        ValidaDados validaDados = ValidaDados.getInstance();
        if(!validaDados.isData(dataInicial)){ throw new DataInvalidaException(dataInicial.toString()); }
        if(!validaDados.isData(dataFinal)){ throw new DataInvalidaException(dataInicial.toString());}
        else{
            String str = repositorioVenda.relatorioVenda(secao,dataInicial,dataFinal);
            if(str.equals("")){ throw new RelatorioVazioException();}
            return str;
        }
    }
    @Override
    public String relatorioVenda(Produto produto, Data dataInicial, Data dataFinal) throws DataInvalidaException,RelatorioVazioException {
        ValidaDados validaDados = ValidaDados.getInstance();
        if(!validaDados.isData(dataInicial)){ throw new DataInvalidaException(dataInicial.toString()); }
        if(!validaDados.isData(dataFinal)){ throw new DataInvalidaException(dataInicial.toString());}
        else{
            String str = repositorioVenda.relatorioVenda(produto,dataInicial,dataFinal);
            if(str.equals("")){ throw new RelatorioVazioException();}
            return str;
        }
    }
}
