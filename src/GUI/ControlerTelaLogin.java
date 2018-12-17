package GUI;

import fachada.Fachada;
import fachada.interfaces.IFachadaGerente;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import main.SIMarket;
import negocio.entidades.Endereco;
import negocio.entidades.Funcionario;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlerTelaLogin implements Initializable {

    @FXML
    private TextField entradaLogin;
    @FXML
    private TextField entradaSenha;

    @FXML
    public void logar(){
        try{
            IFachadaGerente fachadaGerente = Fachada.getInstance();

            fachadaGerente.adicionarFuncionario("IGOR","5555","12345",new Endereco("","","","","",""),true,"123");
            fachadaGerente.adicionarFuncionario("Sau","4545","23456",new Endereco("","","","","",""),true,"123");
            fachadaGerente.adicionarFuncionario("bolsonaro","1717","171717",new Endereco("","","","","",""),false,"123");
            fachadaGerente.adicionarFuncionario("lula","1313","131313",new Endereco("","","","","",""),false,"123");

            String login = entradaLogin.getText();
            String senha = entradaSenha.getText();
            Fachada fachada = Fachada.getInstance();

            fachada.login(login,senha);

            SIMarket.setUser(fachada.buscarFuncionarioPorCpf(login));

            if(SIMarket.getUser().isGerente()){
                SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipal.fxml")));
            }else{
                SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipalAssociado.fxml")));
            }

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("ERRO DE LOGIN");
            alert.setHeaderText(null);
            alert.setContentText("LOGIN OU SENHA INVALIDO(S)");

            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
