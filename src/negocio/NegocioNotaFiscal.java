package negocio;

import dados.RepositorioNota;
import dados.interfaces.IRepositorioNota;
import negocio.entidades.Data;
import negocio.entidades.Fornecedor;
import negocio.entidades.NotaFiscal;
import negocio.excessoes.*;
import negocio.interfaces.INegocioNotaFiscal;
import negocio.validacao.ValidaDados;

public class NegocioNotaFiscal implements INegocioNotaFiscal {

    private IRepositorioNota repositorioNota;

    public NegocioNotaFiscal(){this.repositorioNota = new RepositorioNota();}

    @Override
    public void adicionarNotas(NotaFiscal nota) throws NotaJaExisteException {
        if(repositorioNota.buscarNota(nota.getNumero(),nota.getFornecedor()) != null){ throw new NotaJaExisteException(nota); }
        else{ repositorioNota.adicionarNotas(nota);}
    }
    @Override
    public void removerNota(int numero, Fornecedor fornecedor) throws NenhumaNotaEcontradaException {
        NotaFiscal nota = repositorioNota.buscarNota(numero,fornecedor);
        if(nota == null){ throw new NenhumaNotaEcontradaException();}
        else{ repositorioNota.removerNota(numero,fornecedor);}
    }
    @Override
    public String listarNotasPorEntrada(Data data) throws NenhumaNotaEcontradaException,DataInvalidaException {
        ValidaDados validaDados = ValidaDados.getInstance();
        if(!validaDados.isData(data)){ throw new DataInvalidaException(data.toString()); }
        String str = repositorioNota.listarNotasPorEntrada(data);

        if(str.equals("")){ throw new NenhumaNotaEcontradaException();}
        return str;
    }
    @Override
    public String listarNotasPorEmissao(Data data) throws NenhumaNotaEcontradaException,DataInvalidaException {
        ValidaDados validaDados = ValidaDados.getInstance();
        if(!validaDados.isData(data)){ throw new DataInvalidaException(data.toString()); }
        String str = repositorioNota.listarNotasPorEmissao(data);

        if(str.equals("")){ throw new NenhumaNotaEcontradaException();}
        return str;
    }
    @Override
    public String listarNotasPorNumero(int numero) throws NenhumaNotaEcontradaException {
        String str = repositorioNota.listarNotasPorNumero(numero);
        if(str.equals("")){ throw new NenhumaNotaEcontradaException();}
        return str;
    }
    @Override
    public String listarNotasPorFornecedor(Fornecedor fornecedor, Data dataInicial, Data dataFinal)
    throws NenhumaNotaEcontradaException,DataInvalidaException {
        ValidaDados validaDados = ValidaDados.getInstance();
        if(!validaDados.isData(dataInicial)){ throw new DataInvalidaException(dataInicial.toString());}
        if(!validaDados.isData(dataFinal)){ throw new DataInvalidaException(dataFinal.toString());}

        String str = repositorioNota.listarNotasPorFornecedor(fornecedor,dataInicial,dataFinal);

        if(str.equals("")){ throw new NenhumaNotaEcontradaException();}
        else{ return str;}

    }
    @Override
    public NotaFiscal buscarNota(int numero, Fornecedor fornecedor) throws NotaNaoEncontradaException {
        NotaFiscal nota = repositorioNota.buscarNota(numero,fornecedor);
        if(nota == null){ throw new NotaNaoEncontradaException(numero,fornecedor);}
        else{ return nota;}
    }
}
