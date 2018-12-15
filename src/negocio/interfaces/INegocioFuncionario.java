package negocio.interfaces;

import negocio.entidades.Funcionario;
import negocio.excecao.UsuarioOuSenhaInvalidoException;

public interface INegocioFuncionario {
    boolean login(String login, String senha) throws UsuarioOuSenhaInvalidoException;
    void promoverFuncionario(Funcionario funcionario);
    void rebaixarFuncionario(Funcionario funcionario);
}
