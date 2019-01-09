package FXML;

import Dane.Gwinty;
import Detale.Sruby;
import Detale.Tuleje;
import Generatory.GeneratorKoduCNC;
import Narzedzia.GlowicaNarzedziowa;
import ZapisOdczytPlikow.Odczyt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
/**
 * 
 * @author Tomasz Madeja
 *
 */
public class FXMLKreatorKoduController {

	
	@FXML
	private TextArea TextAreaGenerowanyKodToczenia;
	
	@FXML
	private TextArea TextAreaGenerowanyKodFrezowania;
	
	@FXML
	private TextArea TextAreaGenerowanyKodGwintowania;
	
	//Toczenie Tuleje
	@FXML
	private TextField FieldSrednicaWalkaNaTuleje;
	
	@FXML
	private TextField FieldSrednicaTuleji;
	
	@FXML
	private TextField FieldTulejeDlugoscTuleji;
	
	@FXML
	private TextField FieldSrednicaOtworuTuleji;
	
	@FXML
	private TextField WielkoscFazTuleji;
	
	@FXML
	private TextField MaksPredkoscWrzecionaTuleji;
	
	@FXML
	private CheckBox CheckFazaNawiertakiem;
	
	@FXML
	private ChoiceBox<GlowicaNarzedziowa> ChoicenarzedzieZgrubneTuleja;

	@FXML
	private ChoiceBox<GlowicaNarzedziowa> ChoicenarzedzieWykanczajaceTuleja;
	
	@FXML
	private ChoiceBox<GlowicaNarzedziowa> ChoicenarzedzieNawiertakTuleja;
	
	@FXML
	private ChoiceBox<GlowicaNarzedziowa> ChoicenarzedzieWiertloTuleja;
	
	@FXML
	private ChoiceBox<GlowicaNarzedziowa> ChoicenarzedziaPrzecinakTuleja;
	
	
	@FXML
	private Button ButtonTulejeSubmit;
	
	//------------------------------------------------
	
	//Toczenie Œruby
	
	@FXML
	private TextField FieldSrednicaWalkaSruby;
	
	@FXML
	private TextField FieldDlugoscGwintuSruby;
	
	@FXML
	private TextField FieldSrednicaKolnierzaSruby;
	
	@FXML
	private TextField FieldDlugoscSruby;
	
	@FXML
	private TextField FieldWielkoscFazSruby;
	
	@FXML
	private TextField FieldMaksymalneObrotyWrzecionaSruby;
	
	@FXML
	private CheckBox CheckPodciecie;
	
	@FXML
	private CheckBox CheckDodatkoweNarzedzie;
	
	@FXML
	private ChoiceBox<Gwinty> ChoiceGwintSruby;
	
	@FXML
	private ChoiceBox<GlowicaNarzedziowa> ChoiceZgrubnySruby;
	
	@FXML
	private ChoiceBox<GlowicaNarzedziowa> ChoiceWykanczajacySruby;
	
	@FXML
	private ChoiceBox<GlowicaNarzedziowa> ChoiceNarzedzieDoGwintowaniaSruby;
	
	@FXML
	private ChoiceBox<GlowicaNarzedziowa> ChoiceNarzedzieDodatkoweSruby;
	
	@FXML
	private Button ButtonSrubySubmit;
	
	//------------------------------------------------
	
		//Frezowanie kwadrat
		
		@FXML
		private TextField TextFieldWymiarKwadratu;
		
		@FXML
		private TextField TextFieldDlugoscKwadratu;
		
		@FXML
		private TextField TextFieldSrednicaWalkaNaKwadrat;
		
		@FXML
		private ChoiceBox<GlowicaNarzedziowa> ChoiceNarzedzieNaKwadrat;
		
		@FXML 
		private Button ButtonGenerujKwadrat;
		
		//---------------------------------------------------

		//------------------------------------------------
		
		//Frezowanie szesciokat
		
		@FXML
		private TextField TextFieldWymiarSzesciokata;
		
		@FXML
		private TextField TextFieldDlugoscSzesciokata;
		
		@FXML
		private TextField TextFieldSrednicaWalkaNaSzesciokat;
		
		@FXML
		private ChoiceBox<GlowicaNarzedziowa> ChoiceNarzedzieNaSzesciokat;
		
		@FXML 
		private Button ButtonGenerujSzesciokat;
		
		//---------------------------------------------------
		
		//------------------------------------------------
		
		//Frezowanie z dwoch stron
		
		@FXML
		private TextField TextFieldWymiarFrezowanieZDwochStron;
		
		@FXML
		private TextField TextFieldDlugoscFrezowanieZDwochStron;
		
		@FXML
		private TextField TextFieldSrednicaWalkaNaFrezowanieZDwochStron;
		
		@FXML
		private ChoiceBox<GlowicaNarzedziowa> ChoiceNarzedzieNaFrezowanieZDwochStron;
		
		@FXML 
		private Button ButtonGenerujFrezowanieZDwochStron;
		
		//---------------------------------------------------
		
		//Gwintowanie Metryczne
		
		@FXML
		private ChoiceBox<GlowicaNarzedziowa> ChoiceNarzedzieNaGwintowanieMetryczne;
		
		@FXML
		private ChoiceBox<Gwinty> ChoiceGwintNaGwintowanieMetryczne;
		
		@FXML
		private TextField TextFieldDlugoscNaGwintowanieMetryczne;
		
		@FXML 
		private Button ButtonGenerujGwintowanieMetryczne;
		
		//-----------------------------------------------------
	
	Odczyt o = new Odczyt();
	FXMLTableViewController FXMLNarzedzi = new FXMLTableViewController();
	private final ObservableList<GlowicaNarzedziowa> ListaNarzedziWGlowicy = FXCollections.observableArrayList(
			o.UtworzGlowice(FXMLNarzedzi.getSciezkaPlikuGlowicyNarzedzi()));
	private final ObservableList<Gwinty> ListaGwintow = FXCollections.observableArrayList(
			o.OdczytajGwinty(o.getSciezkaGwintow()));
	
	StringConverter<GlowicaNarzedziowa> scN = new StringConverter<GlowicaNarzedziowa>(){

		@Override
		public String toString(GlowicaNarzedziowa object) {
			return object.getNazwa();
		}
		
		@Override
		public GlowicaNarzedziowa fromString(String string) {
			while(ListaNarzedziWGlowicy.iterator().hasNext()){
				if(ListaNarzedziWGlowicy.iterator().next().getNazwa().equals(string)){
					return ListaNarzedziWGlowicy.iterator().next();
				}
			}
			return null;
		}
		
	};
	
	StringConverter<Gwinty> scG = new StringConverter<Gwinty>(){

		@Override
		public Gwinty fromString(String string) {
			while(ListaGwintow.iterator().hasNext()){
				System.out.println("Sprawdzam Gwint " +ListaGwintow.iterator().next().getNazwa());
				if(ListaGwintow.iterator().next().getNazwa().equals(string)){
					return ListaGwintow.iterator().next();
				}
			}
			return null;
		}

		@Override
		public String toString(Gwinty object) {
			return object.getNazwa();
		}
		
	};
	
	@FXML
	private void initialize(){
		System.out.println("FXMLTableViewController initialize..");
		ChoicenarzedzieZgrubneTuleja.setItems(ListaNarzedziWGlowicy);
		ChoicenarzedzieWykanczajaceTuleja.setItems(ListaNarzedziWGlowicy);
		ChoicenarzedzieNawiertakTuleja.setItems(ListaNarzedziWGlowicy);
		ChoicenarzedzieWiertloTuleja.setItems(ListaNarzedziWGlowicy);
		ChoicenarzedziaPrzecinakTuleja.setItems(ListaNarzedziWGlowicy);
		
		ChoiceGwintSruby.setItems(ListaGwintow);
		ChoiceZgrubnySruby.setItems(ListaNarzedziWGlowicy);
		ChoiceWykanczajacySruby.setItems(ListaNarzedziWGlowicy);
		ChoiceNarzedzieDoGwintowaniaSruby.setItems(ListaNarzedziWGlowicy);
		ChoiceNarzedzieDodatkoweSruby.setItems(ListaNarzedziWGlowicy);
		
		ChoiceNarzedzieNaKwadrat.setItems(ListaNarzedziWGlowicy);
		ChoiceNarzedzieNaSzesciokat.setItems(ListaNarzedziWGlowicy);
		ChoiceNarzedzieNaFrezowanieZDwochStron.setItems(ListaNarzedziWGlowicy);
		ChoiceNarzedzieNaGwintowanieMetryczne.setItems(ListaNarzedziWGlowicy);
		ChoiceGwintNaGwintowanieMetryczne.setItems(ListaGwintow);
		
		ChoiceGwintSruby.setConverter(scG);
		ChoiceZgrubnySruby.setConverter(scN);
		ChoiceWykanczajacySruby.setConverter(scN);
		ChoiceNarzedzieDoGwintowaniaSruby.setConverter(scN);
		ChoiceNarzedzieDodatkoweSruby.setConverter(scN);
		
		ChoicenarzedzieZgrubneTuleja.setConverter(scN);
		ChoicenarzedzieWykanczajaceTuleja.setConverter(scN);
		ChoicenarzedzieNawiertakTuleja.setConverter(scN);
		ChoicenarzedzieWiertloTuleja.setConverter(scN);
		ChoicenarzedziaPrzecinakTuleja.setConverter(scN);
		
		ChoiceNarzedzieNaKwadrat.setConverter(scN);
		ChoiceNarzedzieNaSzesciokat.setConverter(scN);
		ChoiceNarzedzieNaFrezowanieZDwochStron.setConverter(scN);
		ChoiceNarzedzieNaGwintowanieMetryczne.setConverter(scN);
		ChoiceGwintNaGwintowanieMetryczne.setConverter(scG);
		
	}
	
	@FXML
	private void wypisywanieKoduNaTuleje(ActionEvent event){
		System.out.println("Action Start...");
		GeneratorKoduCNC generator = new GeneratorKoduCNC();
		try{
		Tuleje tuleja = new Tuleje(
				Double.parseDouble(FieldSrednicaWalkaNaTuleje.getText()), 
				Double.parseDouble(FieldSrednicaTuleji.getText()), 
				Double.parseDouble(FieldSrednicaOtworuTuleji.getText()), 
				Double.parseDouble(FieldTulejeDlugoscTuleji.getText()), 
				Double.parseDouble(WielkoscFazTuleji.getText()),
				Double.parseDouble(MaksPredkoscWrzecionaTuleji.getText()),
				CheckFazaNawiertakiem.isArmed());
				
		TextAreaGenerowanyKodToczenia.setText(generator.GenerujTuleje(tuleja, 
						ChoicenarzedzieZgrubneTuleja.getSelectionModel().getSelectedItem(),
						ChoicenarzedzieWykanczajaceTuleja.getSelectionModel().getSelectedItem(),
						ChoicenarzedzieNawiertakTuleja.getSelectionModel().getSelectedItem(),
						ChoicenarzedzieWiertloTuleja.getSelectionModel().getSelectedItem(),
						ChoicenarzedziaPrzecinakTuleja.getSelectionModel().getSelectedItem()));
		}catch (NumberFormatException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	@FXML
	private void wypisywanieKoduNaSrube(ActionEvent event){
		System.out.println("Action Start...");
		GeneratorKoduCNC generator = new GeneratorKoduCNC();
		System.out.println("Dodatkowe narzedzie = "+CheckDodatkoweNarzedzie.isSelected());
		
		try{
		Sruby sruba = new Sruby(
				Double.parseDouble(FieldSrednicaWalkaSruby.getText()), 
				ChoiceGwintSruby.getSelectionModel().getSelectedItem(), 
				Double.parseDouble(FieldDlugoscGwintuSruby.getText()), 
				Double.parseDouble(FieldSrednicaKolnierzaSruby.getText()), 
				Double.parseDouble(FieldDlugoscSruby.getText()),
				Double.parseDouble(FieldWielkoscFazSruby.getText()),
				Double.parseDouble(FieldMaksymalneObrotyWrzecionaSruby.getText()),
				CheckPodciecie.isSelected(),
				CheckDodatkoweNarzedzie.isSelected());
				
		TextAreaGenerowanyKodToczenia.setText(generator.GenerujSrube(sruba,
						ChoiceZgrubnySruby.getSelectionModel().getSelectedItem(),
						ChoiceWykanczajacySruby.getSelectionModel().getSelectedItem(),
						ChoiceNarzedzieDoGwintowaniaSruby.getSelectionModel().getSelectedItem(),
						ChoiceNarzedzieDodatkoweSruby.getSelectionModel().getSelectedItem()));
				
		}catch (NumberFormatException e){
			System.out.println(e.getMessage());
		}
	}
	
	@FXML
	private void WypisywanieKoduNaFrezowanieZ2Stron(ActionEvent event){
		System.out.println("Wypisuje kod na frezowanie z 2 stron ...");
		GeneratorKoduCNC generator = new GeneratorKoduCNC();
		
		try{
			TextAreaGenerowanyKodFrezowania.setText(generator.GenerujFrezowanieZ2Stron(
					Double.parseDouble(TextFieldWymiarFrezowanieZDwochStron.getText()), 
					Double.parseDouble(TextFieldDlugoscFrezowanieZDwochStron.getText()), 
					Double.parseDouble(TextFieldSrednicaWalkaNaFrezowanieZDwochStron.getText()), 
					ChoiceNarzedzieNaFrezowanieZDwochStron.getSelectionModel().getSelectedItem()));
			;
		}catch (NumberFormatException e){
			System.out.println(e.getMessage());
			TextAreaGenerowanyKodFrezowania.setText("B³¹d formatu liczb");
		}
	}
	
	@FXML
	private void WypisywanieKoduNaFrezowanieKwadratu(ActionEvent event){
		System.out.println("Wypisuje kod na frezowanie kwadratu ...");
		GeneratorKoduCNC generator = new GeneratorKoduCNC();
		
		try{
			TextAreaGenerowanyKodFrezowania.setText(generator.GenerujFrezowanieZ2Stron(
					Double.parseDouble(TextFieldWymiarKwadratu.getText()), 
					Double.parseDouble(TextFieldDlugoscKwadratu.getText()), 
					Double.parseDouble(TextFieldSrednicaWalkaNaKwadrat.getText()), 
					ChoiceNarzedzieNaKwadrat.getSelectionModel().getSelectedItem()));
			;
		}catch (NumberFormatException e){
			System.out.println(e.getMessage());
			TextAreaGenerowanyKodFrezowania.setText("B³¹d formatu liczb");
		}
	}
	
	@FXML
	private void WypisywanieKoduNaFrezowanieSzesciokata(ActionEvent event){
		System.out.println("Wypisuje kod na frezowanie szesciokata ...");
		GeneratorKoduCNC generator = new GeneratorKoduCNC();
		
		try{
			TextAreaGenerowanyKodFrezowania.setText(generator.GenerujFrezowanieZ2Stron(
					Double.parseDouble(TextFieldWymiarSzesciokata.getText()), 
					Double.parseDouble(TextFieldDlugoscSzesciokata.getText()), 
					Double.parseDouble(TextFieldSrednicaWalkaNaSzesciokat.getText()), 
					ChoiceNarzedzieNaSzesciokat.getSelectionModel().getSelectedItem()));
			;
		}catch (NumberFormatException e){
			System.out.println(e.getMessage());
			TextAreaGenerowanyKodFrezowania.setText("B³¹d formatu liczb");
		}
	}
	
	@FXML
	private void WypisywanieKoduNaGwintowanie(ActionEvent event){
		System.out.println("Wypisuje kod na gwint metryczny ...");
		GeneratorKoduCNC generator = new GeneratorKoduCNC();
		
		try{
			TextAreaGenerowanyKodGwintowania.setText(generator.GenerujGwintowanie(
					ChoiceGwintNaGwintowanieMetryczne.getSelectionModel().getSelectedItem(), 
					ChoiceNarzedzieNaGwintowanieMetryczne.getSelectionModel().getSelectedItem(), 
					Double.parseDouble(TextFieldDlugoscNaGwintowanieMetryczne.getText())));
			;
		}catch (NumberFormatException e){
			System.out.println(e.getMessage());
			TextAreaGenerowanyKodGwintowania.setText("B³¹d formatu liczb");
		}
	}
	
	
}
