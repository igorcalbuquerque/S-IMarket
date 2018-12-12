package negocio.interfaces;

import negocio.entidades.Funcionario;
import negocio.excessoes.FuncionarioNaoEncontradoException;
import negocio.excessoes.UsuarioOuSenhaInvalidoException;

public interface INegocioFuncionario {
    boolean login(String login, String senha) throws UsuarioOuSenhaInvalidoException, FuncionarioNaoEncontradoException;
    void promoverFuncionario(Funcionario funcionario);
    void rebaixarFuncionario(Funcionario funcionario);
}
