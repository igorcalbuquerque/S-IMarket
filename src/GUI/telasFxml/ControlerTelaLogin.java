package GUI.telasFxml;

import fachada.Fachada;
import fachada.interfaces.IFachadaAssociado;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import negocio.excessoes.UsuarioOuSenhaInvalidoException;

public class ControlerTelaLogin {

    @FXML
    private Button botaoLogin;
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
}
