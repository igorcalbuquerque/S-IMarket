package GUI;

import fachada.Fachada;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.SIMarket;
import negocio.entidades.ProdutoVenda;
import negocio.entidades.Venda;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlerTelaVenda implements Initializable {
    @FXML
    private TableView<ProdutoVenda> tabelaProdutos;
    @FXML
    private TableColumn<ProdutoVenda,String> colunaCodigo;
    @FXML
    private TableColumn<ProdutoVenda,String> colunaDescricao;
    @FXML
    private TableColumn<ProdutoVenda,Double> colunaQuantidade;
    @FXML
    private TableColumn<ProdutoVenda,Double> colunaValor;
    @FXML
    private TableColumn<ProdutoVenda,Double> colunaTotal;
    @FXML
    private TextField entradaCpf;
    @FXML
    private TextField entradaCodigo;
    @FXML
    private TextField entradaQuantidade;
    @FXML
    private Label labelTotal;
    @FXML
    private Label labelCliente;
    private Venda venda;

    @FXML
    public void clikAdicionar(){
        try{
            String codigo = entradaCodigo.getText();
            double quantidade = Double.parseDouble(entradaQuantidade.getText());

            venda.adicionarItem(Fachada.getInstance().buscarProdutoPorCodigoDeBarras(codigo),quantidade);
            labelTotal.setText("TOTAL: RS "+venda.getValorTotal());
            tabelaProdutos.setItems(FXCollections.observableArrayList(venda.getCarrinho()));

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }
    @FXML
    public void clikFinalizar(){
        try{
           Fachada.getInstance().adicionarVenda(venda);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("VENDA");
            alert.setHeaderText(null);
            alert.setContentText("VENDA CONCLUIDA!!!");

            alert.showAndWait();

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
    public void clikCancelar(){
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
    public void clikBuscar(){
        try{
            venda.atribuirCliente(Fachada.getInstance().buscarClientePorCpf(entradaCpf.getText()));
            labelCliente.setText(Fachada.getInstance().buscarClientePorCpf(entradaCpf.getText()).getNome()+"  "+entradaCpf.getText());
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
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigoBarra"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valorVenda"));
        colunaTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        venda = new Venda(SIMarket.getUser());

        tabelaProdutos.setItems(FXCollections.observableArrayList(venda.getCarrinho()));
    }
}
