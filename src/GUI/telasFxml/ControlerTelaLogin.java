package GUI.telasFxml;

import javafx.fxml.FXML;

import java.awt.*;

public class ControlerTelaLogin {

    @FXML
    private Button botaoLogin;
    @FXML
    private TextField entradaLogin;
    @FXML
    private TextField entradaSenha;

    @FXML
    public void logar(){
        String login = entradaLogin.getText();
        String senha = entradaLogin.getText();
    }
}
