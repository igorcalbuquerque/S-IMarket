package negocio;

import dados.RepositorioSecao;
import dados.interfaces.IRepositorioSecao;
import negocio.entidades.Secao;
import negocio.excecao.CodigoJaExisteException;
import negocio.excecao.SecaoNaoEncontradaException;
import negocio.interfaces.INegocioSecao;

public class NegocioSecao implements INegocioSecao {

    private IRepositorioSecao secoes;

    public NegocioSecao(){this.secoes = new RepositorioSecao();}
    @Override
    public void addSecao(Secao secao) throws CodigoJaExisteException {
        if(secoes.buscarSecao(secao.getCodigo()) != null){ throw new CodigoJaExisteException(secao.getCodigo());}
        else{ secoes.addSecao(secao);}
    }
    @Override
    public void removeSecao(int codigo) throws SecaoNaoEncontradaException {
        if(secoes.buscarSecao(codigo) == null){throw new SecaoNaoEncontradaException();}
        else{ secoes.removeSecao(codigo);}
    }
    @Override
    public Secao buscarSecao(int codigo) throws SecaoNaoEncontradaException {
        Secao secao = secoes.buscarSecao(codigo);
        if(secao == null){throw new SecaoNaoEncontradaException();}
        else{return secao;}
    }
    @Override
    public String buscarPorDescricao(String descricao) throws SecaoNaoEncontradaException {
        String str = secoes.buscarPorDescricao(descricao);
        if(str.equals("")){throw new SecaoNaoEncontradaException();}
        else{return str;}
    }
}
