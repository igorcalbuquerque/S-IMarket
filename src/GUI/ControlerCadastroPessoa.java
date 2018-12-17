package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.omg.CORBA.PRIVATE_MEMBER;

public class ControlerCadastroPessoa {


    @FXML
    private RadioButton rdFuncionario;
    @FXML
    private RadioButton rdCliente;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtRG;
    @FXML
    private TextField txtCPF;
    @FXML
    private TextField txtRua;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtCep;
    @FXML
    private TextField txtEstado;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField pssSenha;
    @FXML
    private TextField pssConfirmaSenha;
    @FXML
    private Button btnSalvar;
    @FXML
    private Label lblLogin;
    @FXML
    private Label lblSenha;
    @FXML
    private Label lblConfirma;
    @FXML
    private RadioButton rdGerente;

    @FXML
    private void desativaFuncionario(){

       if (rdCliente.isSelected()) {


           txtLogin.setVisible(false);
           pssSenha.setVisible(false);
           pssConfirmaSenha.setVisible(false);
           lblConfirma.setVisible(false);
           lblLogin.setVisible(false);
           lblSenha.setVisible(false);
           rdGerente.setVisible(false);
        }



    }






}
