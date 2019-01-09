package FXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Narzedzia.GlowicaNarzedziowa;
import Narzedzia.NarzedziaSkrawajace;
import ZapisOdczytPlikow.Odczyt;
import ZapisOdczytPlikow.Zapisz;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * 
 * @author Tomasz Madeja
 *
 */
public class FXMLTableViewController {
	
	public FXMLTableViewController(){
		
	}
	private final String SciezkaPlikuNarzedzi="src/CSV/Narzedzia.csv";
	
	private final String SciezkaPlikuGlowicyNarzedzi="src/CSV/GlowicaNarzedzi.csv";
	
	//Magazyn
	@FXML
	private TableColumn<NarzedziaSkrawajace, String> KolumnaNazwaNarzedzi;
	
	@FXML
	private TableColumn<NarzedziaSkrawajace, String> KolumnaX;
	
	@FXML
	private TableColumn<NarzedziaSkrawajace, String> KolumnaY;
	
	@FXML
	private TableColumn<NarzedziaSkrawajace, String> KolumnaPosow;
	
	@FXML
	private TableColumn<NarzedziaSkrawajace, String> KolumnaGlebokoscSkrawania;
	
	@FXML
	private TableColumn<NarzedziaSkrawajace, String> KolumnaPredkoscSkrawania;
	//---------------
	
	//Glowica
	@FXML
	private TableColumn<GlowicaNarzedziowa, Integer> KolumnaNrPozycji;
	
	@FXML
	private TableColumn<GlowicaNarzedziowa, String> KolumnaNazwyNarzedziWGlowicy;
	
	@FXML
	private TableColumn<GlowicaNarzedziowa, String> KolumnaXWGlowicy;

	@FXML
	private TableColumn<GlowicaNarzedziowa, String> KolumnaYWGlowicy;

	@FXML
	private TableColumn<GlowicaNarzedziowa, String> KolumnaPosowWGlowicy;

	@FXML
	private TableColumn<GlowicaNarzedziowa, String> KolumnaGlebokoscSkrawaniaWGlowicy;
	
	@FXML
	private TableColumn<GlowicaNarzedziowa, String> KolumnaPredkoscSkrawaniaWGlowicy;
	
	//--------------------------------------
	
	@FXML
	private TableView<NarzedziaSkrawajace> TableViewNarzedzi;
	
	@FXML
	private TableView<GlowicaNarzedziowa> TableViewGlowicy;
	
	
	
	Odczyt o = new Odczyt();
	private final ObservableList<NarzedziaSkrawajace> ListaNarzedzi = FXCollections.observableArrayList(
			o.OtworzNarzedzia(SciezkaPlikuNarzedzi));
	private final ObservableList<GlowicaNarzedziowa> ListaNarzedziWGlowicy = FXCollections.observableArrayList(
			o.UtworzGlowice(SciezkaPlikuGlowicyNarzedzi)
			);
	
	@FXML
	private TextField NazwaNarzedzia;
	
	@FXML
	private TextField WspolrzedneX;
	
	@FXML
	private TextField WspolrzedneY;
	
	@FXML
	private TextField Posow;
	
	@FXML
	private TextField GlebokoscSkrawania;
	
	@FXML
	private TextField PredkoscSkrawania;
	
	@FXML
	private Button ZapiszNarzedzia;
	
	@FXML
	private Button UsunNarzedzie;
	
	@FXML
	private Button OdmontujNarzedzie;
	
	@FXML
	private Button ZamontujNarzedzie;
	
	Zapisz zapisz = new Zapisz();
	/**
	 *  Przypisywanie wartosci do kolumn.
	 */
	@FXML
	private void initialize(){
		System.out.println("FXMLTableViewController initialize..");
		KolumnaNazwaNarzedzi.setCellValueFactory(new PropertyValueFactory<NarzedziaSkrawajace, String>("nazwa"));
		KolumnaX.setCellValueFactory(new PropertyValueFactory<NarzedziaSkrawajace, String>("X"));
		KolumnaY.setCellValueFactory(new PropertyValueFactory<NarzedziaSkrawajace, String>("Y"));
		KolumnaPosow.setCellValueFactory(new PropertyValueFactory<NarzedziaSkrawajace, String>("posow"));
		KolumnaGlebokoscSkrawania.setCellValueFactory(new PropertyValueFactory<NarzedziaSkrawajace, String>("glebokoscSkrawania"));
		KolumnaPredkoscSkrawania.setCellValueFactory(new PropertyValueFactory<NarzedziaSkrawajace, String>("predkoscSkrawania"));
		
		KolumnaNrPozycji.setCellValueFactory(new PropertyValueFactory<GlowicaNarzedziowa, Integer>("numerPozycji"));
		KolumnaNazwyNarzedziWGlowicy.setCellValueFactory(new PropertyValueFactory<GlowicaNarzedziowa, String>("nazwa"));
		KolumnaXWGlowicy.setCellValueFactory(new PropertyValueFactory<GlowicaNarzedziowa, String>("X"));
		KolumnaYWGlowicy.setCellValueFactory(new PropertyValueFactory<GlowicaNarzedziowa, String>("Y"));
		KolumnaPosowWGlowicy.setCellValueFactory(new PropertyValueFactory<GlowicaNarzedziowa, String>("posow"));
		KolumnaGlebokoscSkrawaniaWGlowicy.setCellValueFactory(new PropertyValueFactory<GlowicaNarzedziowa, String>("glebokoscSkrawania"));
		KolumnaPredkoscSkrawaniaWGlowicy.setCellValueFactory(new PropertyValueFactory<GlowicaNarzedziowa, String>("predkoscSkrawania"));
		
		TableViewGlowicy.setItems(ListaNarzedziWGlowicy);
		TableViewNarzedzi.setItems(ListaNarzedzi);
	}
	
	
	@FXML
    protected void ZapiszNarzedzie(ActionEvent event) {
    	System.out.println("ActionEvent activation...");;
    	NarzedziaSkrawajace NewTool = new NarzedziaSkrawajace(NazwaNarzedzia.getText(), 
    			WspolrzedneX.getText(), 
    			WspolrzedneY.getText(), 
    			Posow.getText(), 
    			GlebokoscSkrawania.getText(), 
    			PredkoscSkrawania.getText());
    	ListaNarzedzi.add(NewTool);
    	zapisz.ZapiszNarzedzia(SciezkaPlikuNarzedzi, ListaNarzedzi);
    	NazwaNarzedzia.setText("");
    	WspolrzedneX.setText("");
    	WspolrzedneY.setText("");
    	Posow.setText("");
    	GlebokoscSkrawania.setText("");
    	PredkoscSkrawania.setText("");
    	initialize();
    	
    }
	
	@FXML
	protected void UsunNarzedzie(ActionEvent event){
		System.out.println("ActionEvent activation...");
		NarzedziaSkrawajace selectedItem = TableViewNarzedzi.getSelectionModel().getSelectedItem();
		TableViewNarzedzi.getItems().remove(selectedItem);
		Zapisz zapisz = new Zapisz();
		zapisz.ZapiszNarzedzia(SciezkaPlikuNarzedzi, ListaNarzedzi);
	}
	
	@FXML
	protected void OdmontujNarzedzie(ActionEvent event){
		System.out.println("ActionEvent activation...");
		GlowicaNarzedziowa selectedItem = TableViewGlowicy.getSelectionModel().getSelectedItem();
		GlowicaNarzedziowa blankItem = new GlowicaNarzedziowa("", "", "", "", "", "", (selectedItem.getNumerPozycji()));
		ListaNarzedziWGlowicy.set((selectedItem.getNumerPozycji()-1), blankItem);
		initialize();
		zapisz.ZapiszGlowice(SciezkaPlikuGlowicyNarzedzi, ListaNarzedziWGlowicy);
	}
	
	@FXML
	protected void ZamontujNarzedzie(ActionEvent event){
		System.out.println("ActionEvent activation...");
		NarzedziaSkrawajace selectedItem = TableViewNarzedzi.getSelectionModel().getSelectedItem();
		List<String> wybor = new ArrayList<>();
		for(Integer i=1;i<13;i++){
			wybor.add(i.toString());
		}
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Pozycja", wybor);
		dialog.setTitle("Wybór Pozycji");
		dialog.setHeaderText("Wybierz Pozycje");
		dialog.setContentText("Pozycje: ");
		
		Optional<String> decyzja = dialog.showAndWait();
		GlowicaNarzedziowa dodawaneNarzedzie = new GlowicaNarzedziowa(selectedItem.getNazwa(), selectedItem.getX(),selectedItem.getZ(),selectedItem.getPosow(),selectedItem.getGlebokoscSkrawania(),selectedItem.getPredkoscSkrawania(), Integer.parseInt(decyzja.get()));
		//ListaNarzedziWGlowicy.get(Integer.parseInt(decyzja.get()));
		//ListaNarzedziWGlowicy.remove(Integer.parseInt(decyzja.get())-1);
		decyzja.ifPresent(pozycja -> ListaNarzedziWGlowicy.set(Integer.parseInt(pozycja)-1, dodawaneNarzedzie));
		initialize();
		zapisz.ZapiszGlowice(SciezkaPlikuGlowicyNarzedzi, ListaNarzedziWGlowicy);
	}


	public ObservableList<GlowicaNarzedziowa> getListaNarzedziWGlowicy() {
		return ListaNarzedziWGlowicy;
	}
	
	public String getSciezkaPlikuGlowicyNarzedzi() {
		return SciezkaPlikuGlowicyNarzedzi;
	}
	
	
}