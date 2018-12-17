package GUI;

import dados.RepositorioPessoa;
import dados.interfaces.IRepositorioPessoa;
import fachada.Fachada;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.PropertyResourceBundle;

public class ControleConsultaFuncionario {

    @FXML
    private TableView tblFuncionario;
    @FXML
    private TableColumn nome;
    @FXML
    private TableColumn cpf;
    @FXML
    private TableColumn rg;
    @FXML
    private TableColumn rua;
    @FXML
    private TableColumn bairro;
    @FXML
    private TableColumn cidade;
    @FXML
    private TableColumn estado;
    @FXML
    private TableColumn cep;
    @FXML
    private TableColumn telefone;
    @FXML
    private TableColumn cargo;

    @FXML
    private void retornaListaFuncioario(){

        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Funcionarios");
        alert.setHeaderText("");
        alert.setContentText(Fachada.getInstance().listarFuncionarios());



        alert.showAndWait();

    }

}
