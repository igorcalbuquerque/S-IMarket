package negocio.interfaces;

import negocio.entidades.Secao;
import negocio.excessoes.CodigoJaExisteException;
import negocio.excessoes.SecaoNaoEncontradaException;

public interface INegocioSecao {
    void addSecao(Secao secao) throws CodigoJaExisteException;
    void removeSecao(int codigo) throws SecaoNaoEncontradaException;
    Secao buscarSecao(int codigo) throws SecaoNaoEncontradaException;
    String buscarPorDescricao(String descricao) throws SecaoNaoEncontradaException;
}
