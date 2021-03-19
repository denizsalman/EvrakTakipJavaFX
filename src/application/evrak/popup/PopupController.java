package application.evrak.popup;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import application.entity.Evrak;
import application.entity.Il;
import application.entity.Ilce;
import application.repository.EvrakRepository;
import application.repository.UtilRepository;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class PopupController implements Initializable {

	@FXML
	private TextField tfIdariBirimKodu;

	@FXML
	private ComboBox<Il> cmbIl;

	@FXML
	private ComboBox<Ilce> cmbIlce;

	@FXML
	private DatePicker dpTarih;

	@FXML
	private TextField tfKurumKisi;

	@FXML
	private TextField tfEk;

	@FXML
	private TextField tfAciklama;

    @FXML
    private TextField tfKonu;

	@FXML
	private Button kaydet;

	@FXML
	private void kaydet(ActionEvent event) throws SQLException {
		Il selectedIl = cmbIl.getSelectionModel().getSelectedItem();
		Ilce selectedIlce = cmbIlce.getSelectionModel().getSelectedItem();
		Evrak evrak = new Evrak(tfIdariBirimKodu.getText(), selectedIl.getIl_no().toString(), selectedIlce.getIlce_no().toString(), 
				tfKurumKisi.getText(), "20201203", tfEk.getText(), 
				dpTarih.getValue().toString() , tfAciklama.getText(), tfKonu.getText());
		EvrakRepository.createEvrak(evrak);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Il> ilList = UtilRepository.getIller();

		ObservableList<Il> options = FXCollections.observableArrayList(ilList);
		cmbIl.getItems().addAll(options);
		cmbIl.setConverter(new StringConverter<Il>() {

			@Override
			public String toString(Il il) {
				return il.getIsim();
			}

			@Override
			public Il fromString(String string) {
//				return cmbIl.getItems().stream().filter(ap -> 
//					ap.getIsim().equals(string)).findFirst().orElse(null);
				return null;
			}
		});
		cmbIl.valueProperty().addListener(new ChangeListener<Il>() {

			@Override
			public void changed(ObservableValue<? extends Il> observable, Il oldValue, Il newValue) {
				if (newValue != null) {
					System.out.println(newValue.getIsim() + " " + newValue.getIl_no());
					setCmbIlce(newValue.getIl_no());
				}
			}
		});
	}

	private void setCmbIlce(Integer id) {
		List<Ilce> ilceList = UtilRepository.getIlceler(id);

		ObservableList<Ilce> options = FXCollections.observableArrayList(ilceList);
		cmbIlce.setItems(options);
		cmbIlce.setConverter(new StringConverter<Ilce>() {

			@Override
			public String toString(Ilce ilce) {
				return ilce.getIsim();
			}

			@Override
			public Ilce fromString(String string) {
//				return cmbIl.getItems().stream().filter(ap -> 
//					ap.getIsim().equals(string)).findFirst().orElse(null);
				return null;
			}
		});
	}

}
