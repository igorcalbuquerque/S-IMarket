package GUI;

import fachada.Fachada;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import main.SIMarket;
import negocio.entidades.Endereco;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlerFornecedor implements Initializable {
    @FXML
    private TextField txtCnpj;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtRua;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtCep;
    @FXML
    private TextField txtEstado;

    @FXML
    public void clikSalvar(){
        try {
            Fachada.getInstance().adicionarFornecedor(txtNome.getText(),txtCnpj.getText(),
                                                      new Endereco(txtRua.getText(),txtNumero.getText(),txtBairro.getText(),
                                                      txtCidade.getText(),txtCep.getText(),txtEstado.getText()));
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
