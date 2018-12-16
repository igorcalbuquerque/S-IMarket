package GUI;

import fachada.Fachada;
import fachada.interfaces.IFachadaAssociado;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import negocio.entidades.abstratas.Pessoa;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlerTelaLogin implements Initializable {

    private Fachada fachada;

    @FXML
    private Button btnLogin;
    @FXML
    private TextField entradaLogin;
    @FXML
    private TextField entradaSenha;

    @FXML
    public void logar(){
        try{

            String login = entradaLogin.getText();
            String senha = entradaLogin.getText();
            IFachadaAssociado fachada = Fachada.getInstance();
            fachada.login(login,senha);

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("ERRO DE LOGIN");
            alert.setHeaderText(e.getMessage());
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
