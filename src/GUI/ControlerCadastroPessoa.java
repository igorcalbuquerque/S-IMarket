package GUI;

import fachada.Fachada;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import main.SIMarket;
import negocio.entidades.Endereco;

public class ControlerCadastroPessoa {


    Fachada fachada = new Fachada();

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
    private TextField txtTelefone;
    @FXML
    private TextField txtEmail;

    @FXML
    private void radioOpcoes(){

    }
    @FXML
    public void clikVoltar(){
        try{
            if(SIMarket.getUser().isGerente()){
                SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipal.fxml")));
            }else{
                SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipalAssociado.fxml")));
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }
    @FXML
    private void cadastrarPessoa(){

        if (rdCliente.isSelected()) {

            rdFuncionario.setVisible(false);
            txtLogin.setVisible(false);
            pssSenha.setVisible(false);
            pssConfirmaSenha.setVisible(false);
            lblConfirma.setVisible(false);
            lblLogin.setVisible(false);
            lblSenha.setVisible(false);
            rdGerente.setVisible(false);

            try {
                Endereco endereco = new Endereco(txtRua.getText(), txtNumero.getText(), txtBairro.getText(), txtCidade.getText(), txtCep.getText(), txtEstado.getText());

                fachada.adicionarCliente(txtNome.getText(), txtRG.getText(), txtCPF.getText(), endereco, txtTelefone.getText(), txtEmail.getText());
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("ERRO DE LOGIN");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());

                e.printStackTrace();

                alert.showAndWait();

            }
        }
        else{

            try {
                Endereco endereco = new Endereco(txtRua.getText(), txtNumero.getText(), txtBairro.getText(), txtCidade.getText(), txtCep.getText(), txtEstado.getText());

                fachada.adicionarFuncionario(txtNome.getText(), txtRG.getText(), txtCPF.getText(), endereco, rdGerente.isSelected(), pssSenha.getText(), txtEmail.getText());
                if(SIMarket.getUser().isGerente()){
                    SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipal.fxml")));
                }else{
                    SIMarket.setJanela(FXMLLoader.load(getClass().getClassLoader().getResource("GUI/TelaPrincipalAssociado.fxml")));
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("ERRO DE LOGIN");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());

                e.printStackTrace();

                alert.showAndWait();
            }
        }
    }








}
