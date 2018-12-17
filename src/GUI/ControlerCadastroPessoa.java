package GUI;

import fachada.Fachada;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import negocio.entidades.Endereco;
import negocio.excecao.CpfJaExisteException;
import negocio.excecao.FuncionarioJaCadastrado;
import negocio.excecao.RgJaExisteException;
import org.omg.CORBA.PRIVATE_MEMBER;

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
                e.getMessage();
            }
        }
        else{

            try {
                Endereco endereco = new Endereco(txtRua.getText(), txtNumero.getText(), txtBairro.getText(), txtCidade.getText(), txtCep.getText(), txtEstado.getText());

                fachada.adicionarFuncionario(txtNome.getText(), txtRG.getText(), txtCPF.getText(), endereco, rdGerente.isSelected(), pssSenha.getText(), txtEmail.getText());

            } catch (CpfJaExisteException e) {
                e.printStackTrace();
            } catch (RgJaExisteException e) {
                e.printStackTrace();
            }

        }


    }








}
