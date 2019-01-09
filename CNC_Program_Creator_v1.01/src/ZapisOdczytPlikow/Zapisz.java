package ZapisOdczytPlikow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import Narzedzia.GlowicaNarzedziowa;
import Narzedzia.NarzedziaSkrawajace;
import javafx.collections.ObservableList;


/**
 * 
 * @author Tomasz Madeja
 *
 */
public class Zapisz {
	
	public void ZapiszNarzedzia(String NameFile, ObservableList<NarzedziaSkrawajace> list){
		ArrayList<String> out = new ArrayList<>();
		if(!list.isEmpty()){
			for(NarzedziaSkrawajace seria : list){
				String s = seria.getNazwa()+","+seria.getX()+","+seria.getZ()+","+seria.getPosow()+","+seria.getGlebokoscSkrawania()+","+seria.getPredkoscSkrawania();
	            out.add(s);
			}
			ZapiszPlik(NameFile,out);
		}else{
			System.out.println("List is Empty");
		}
	}
	
	public void ZapiszGlowice(String NameFile, ObservableList<GlowicaNarzedziowa> list){
		ArrayList<String> out = new ArrayList<>();
		if(!list.isEmpty()){
			for(GlowicaNarzedziowa seria : list){
				String s = seria.getNazwa()+","+seria.getX()+","+seria.getZ()+","+seria.getPosow()+","+seria.getGlebokoscSkrawania()+","+seria.getPredkoscSkrawania()+","+seria.getNumerPozycji();
	            out.add(s);
			}
			ZapiszPlik(NameFile,out);
		}else{
			System.out.println("List is Empty");
		}
	}
	
	public void ZapiszPlik(String NameFile, ArrayList<String> out){
		
		Path path = Paths.get(NameFile);
		try {
            Files.write(path, out);
        } catch (IOException ex) {
            System.out.println("Can't save File");
        }
	}
	
	
	
}
