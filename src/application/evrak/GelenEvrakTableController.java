package application.evrak;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import application.entity.Evrak;
import application.repository.EvrakRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GelenEvrakTableController implements Initializable {

	@FXML
	private ScrollPane scrollPane;
	
    @FXML
    private TableView<Evrak> table;
	
    @FXML
    private TableColumn<Evrak, String> sira;

    @FXML
    private TableColumn<Evrak, String> idariBirimKodu;

    @FXML
    private TableColumn<Evrak, String> il;

    @FXML
    private TableColumn<Evrak, String> ilce;

    @FXML
    private TableColumn<Evrak, String> kurumKisi;

    @FXML
    private TableColumn<Evrak, String> tarih;

    @FXML
    private TableColumn<Evrak, String> ek;

    @FXML
    private TableColumn<Evrak, String> aciklama;
    

    @FXML
    private TableColumn<Evrak, String> konu;

    @FXML
    private Button btnEkle;
    

    @FXML
    void ekle(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
    	
    	Parent root = FXMLLoader.load(getClass().getResource("popup/Popup.fxml"));
    	
    	stage.initModality(Modality.APPLICATION_MODAL);
    	stage.initOwner(btnEkle.getScene().getWindow());
    	stage.setOnHidden(e -> tableDoldur());
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.show();
    }
 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		tableDoldur();
	}
	
	private void tableDoldur() {
		try {
			//Veritaban??ndan gelen evrak bilgilerini getirir
			List<Evrak> evrakList = EvrakRepository.getAllEvrak();
			
			ObservableList<Evrak> oList = FXCollections.observableArrayList(evrakList);
			System.out.println("Gelen evrak table controller");
			sira.setCellValueFactory(new PropertyValueFactory<Evrak, String>("id"));
			idariBirimKodu.setCellValueFactory(new PropertyValueFactory<Evrak, String>("idariBirimKodu"));
			il.setCellValueFactory(new PropertyValueFactory<Evrak, String>("il"));
			ilce.setCellValueFactory(new PropertyValueFactory<Evrak, String>("ilce"));
			kurumKisi.setCellValueFactory(new PropertyValueFactory<Evrak, String>("kurumKisi"));
			tarih.setCellValueFactory(new PropertyValueFactory<Evrak, String>("evrakTarihi"));
			ek.setCellValueFactory(new PropertyValueFactory<Evrak, String>("ek"));
			aciklama.setCellValueFactory(new PropertyValueFactory<Evrak, String>("aciklama"));
			konu.setCellValueFactory(new PropertyValueFactory<Evrak, String>("konu"));
			
			table.setItems(oList);
			
			/* 
			 * Table ??zerinde row silme i??in right click contextMenu. 
			 */
			
			table.setRowFactory(tv -> {
				TableRow<Evrak> row = new TableRow();
				
				row.setOnMousePressed(new EventHandler<MouseEvent>() {
						@Override
					    public void handle(MouseEvent event) {
					        if (row.getItem() != null) {
								if (event.isSecondaryButtonDown()) {
						        	TextField textField = new TextField("Type Something");
									final ContextMenu contextMenu = new ContextMenu();
									MenuItem delete = new MenuItem("Delete");
									contextMenu.getItems().addAll(delete);
									delete.setOnAction(new EventHandler<ActionEvent>() {
									    @Override
									    public void handle(ActionEvent event) {
									        System.out.println("Delete...");
									        System.out.println(row);
								        	try {
												EvrakRepository.deleteEvrak(row.getItem().getId());
												tableDoldur();
											} catch (SQLException e) {
												e.printStackTrace();
											}
									    }
									});
									// ...
									textField.setContextMenu(contextMenu);
						            contextMenu.show(row, event.getScreenX(), event.getScreenY());
						           
						        }
					        }
					    }
				});
				return row;
			});
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
}
