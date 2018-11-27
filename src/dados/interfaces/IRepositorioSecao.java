package dados.interfaces;

import negocio.entidades.Secao;

public interface IRepositorioSecao {
    void addSecao(Secao secao);
    void removeSecao(int codigo);
    Secao buscarSecao(int codigo);
    String buscarPorDescricao(String nome);
}
