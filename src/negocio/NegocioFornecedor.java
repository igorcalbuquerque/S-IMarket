package negocio;

import dados.RepositorioFornecedor;
import dados.interfaces.IRepositorioFornecedor;
import negocio.entidades.Fornecedor;
import negocio.excessoes.CnpjJaExisteException;
import negocio.excessoes.CodigoJaExisteException;
import negocio.excessoes.FornecedorNaoEncontradoException;
import negocio.interfaces.INegocioFornecedor;

public class NegocioFornecedor implements INegocioFornecedor {

    private IRepositorioFornecedor fornecedores;

    public NegocioFornecedor(){this.fornecedores = new RepositorioFornecedor();}
    @Override
    public Fornecedor buscarFornecedor(int codigo) throws FornecedorNaoEncontradoException {
        Fornecedor fornecedor = fornecedores.buscarFornecedor(codigo);
        if(fornecedor == null){ throw new FornecedorNaoEncontradoException(); }
        else{ return fornecedor; }
    }
    @Override
    public Fornecedor buscarFornecedor(String cnpj) throws FornecedorNaoEncontradoException {
        Fornecedor fornecedor = fornecedores.buscarFornecedor(cnpj);
        if(fornecedor == null){ throw new FornecedorNaoEncontradoException(); }
        else{ return fornecedor; }
    }
    @Override
    public void adicionarFornecedor(Fornecedor fornecedor) throws CnpjJaExisteException, CodigoJaExisteException{
        if(fornecedores.buscarFornecedor(fornecedor.getCnpj()) != null){ throw new CnpjJaExisteException(fornecedor.getCnpj());}
        if(fornecedores.buscarFornecedor(fornecedor.getCodigo()) != null){ throw new CodigoJaExisteException(fornecedor.getCodigo());}
        else{ fornecedores.adicionarFornecedor(fornecedor);}
    }
    @Override
    public void removerFornecedor(int codigo) throws FornecedorNaoEncontradoException {
        if (fornecedores.buscarFornecedor(codigo) == null){ throw new FornecedorNaoEncontradoException();}
        else{ fornecedores.removerFornecedor(codigo);}
    }
    @Override
    public void removerFornecedor(String cnpj) throws FornecedorNaoEncontradoException {
        if (fornecedores.buscarFornecedor(cnpj) == null){ throw new FornecedorNaoEncontradoException();}
        else{ fornecedores.removerFornecedor(cnpj);}
    }
}
