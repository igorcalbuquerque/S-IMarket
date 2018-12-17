package GUI;

import dados.RepositorioPessoa;
import fachada.Fachada;
import fachada.interfaces.IFachadaAssociado;
import fachada.interfaces.IFachadaGerente;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.SIMarket;
import negocio.entidades.Endereco;
import negocio.entidades.Funcionario;
import negocio.entidades.abstratas.Pessoa;
import negocio.excecao.CpfJaExisteException;
import negocio.excecao.RgJaExisteException;
import negocio.excecao.UsuarioOuSenhaInvalidoException;
import negocio.interfaces.INegocioFuncionario;
import sun.plugin.javascript.navig.Anchor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControlerTelaLogin implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private TextField entradaLogin;
    @FXML
    private TextField entradaSenha;
    @FXML
    private AnchorPane telaLogin;

    @FXML
    public void logar(){
        try{
            IFachadaGerente fachadaGerente = Fachada.getInstance();

            fachadaGerente.adicionarFuncionario("IGOR","5555","1234561",new Endereco("","","","","",""),true,"123456");
            fachadaGerente.adicionarFuncionario("Sau","4545","23456",new Endereco("","","","","",""),true,"123456");
            fachadaGerente.adicionarFuncionario("bolsonaro","1717","171717",new Endereco("","","","","",""),false,"123456");
            fachadaGerente.adicionarFuncionario("lula","1313","131313",new Endereco("","","","","",""),false,"123456");

            String login = entradaLogin.getText();
            String senha = entradaSenha.getText();
            Fachada fachada = new Fachada();
            Funcionario funcionario = null;
            

            if (login.equals("igor") && senha.equals("123")){
                SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipal.fxml")));

            }
            else if (login.equals("sau") && senha.equals("123456")) {
                SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipal.fxml")));
            }
            else if (login.equals("bolsonaro") && senha.equals("123456")) {
                SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipalAssociado.fxml")));

            }
            else if (login.equals("lula") && senha.equals("123456")) {
                SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipalAssociado.fxml")));
            }

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("ERRO DE LOGIN");
            alert.setHeaderText("");
            alert.setContentText(Fachada.getInstance().listarFuncionarios());

            e.printStackTrace();

            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
