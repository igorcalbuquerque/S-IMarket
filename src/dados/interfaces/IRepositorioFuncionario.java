package dados.interfaces;

import negocio.entidades.Funcionario;

public interface IRepositorioFuncionario {

    Funcionario buscarPorLogin(String login);
    String relatorioGastos();
}
