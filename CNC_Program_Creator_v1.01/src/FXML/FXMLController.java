package FXML;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

import ZapisOdczytPlikow.Zapisz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class FXMLController {
	
	@FXML
	private TextArea AreaTextProgram ;
	
	
	@FXML
	private void initialize(){
		System.out.println("FXMLController initialize..");
		
		
	}
	
    @FXML
    public void OpenNarzedziaStage(ActionEvent event) throws Exception {
        try {
        	
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NarzedziaPane.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
        
    	}
    
    @FXML
    public void OpenGeneratorStage(ActionEvent event) throws Exception {
        try {
        	
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("KreatorKoduPane.fxml"));
                Parent root2 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root2));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
        
    	}
    
    @FXML
    public void ZapiszProgram() throws IOException{
    	File sciezka = new File(".").getCanonicalFile();
    	File sciezkaPliku = new File(sciezka.getPath()+"/Programy");
    	Zapisz zapisz = new Zapisz();
    	ArrayList<String> alist = new ArrayList<String>();
    	TextInputDialog dialog = new TextInputDialog("o00000");
    	dialog.setTitle("Zapisz plik");
    	dialog.setHeaderText("Zapisywanie pliku");
    	dialog.setContentText("Podaj nazwê pliku:");
    	Optional<String> result = dialog.showAndWait();
    	
    	if (result.isPresent()){
    		if(result.get()==null || result.get().equals("")){
    			System.out.println("Brak nazwy pliku");
    			
    		}else{
    			System.out.println("Zapisuje plik");
    			alist.add(AreaTextProgram.getText());
    			if(sciezkaPliku.exists()){
    				if(sciezkaPliku.isDirectory())
    				zapisz.ZapiszPlik(sciezkaPliku.getPath()+"/"+result.get()+".nc", alist);
    	    	}else{
    	    		Files.createDirectory(Paths.get(sciezkaPliku.getPath()));
    	    		zapisz.ZapiszPlik(sciezkaPliku.getPath()+"/"+result.get()+".nc", alist);
    	    	}
    	    	
    		}
    	}
    }
}
