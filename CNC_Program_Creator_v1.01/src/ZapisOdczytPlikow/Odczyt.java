package ZapisOdczytPlikow;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import Dane.Gwinty;
import Dane.PodcieciaGwintu;
import Narzedzia.GlowicaNarzedziowa;
import Narzedzia.NarzedziaSkrawajace;

/**
 * 
 * @author Tomasz Madeja
 *
 */
public class Odczyt {
	private final String SciezkaGwintow ="src/CSV/Gwinty.csv";
	private final String SciezkaPodciecia ="src/CSV/podcieciaPN83.csv";
	private final int MAXPozycji = 12;
	/**
	 * 
	 * @param fileName Œcie¿ka pliku
	 * @return Tablice narzêdzi
	 */
	public NarzedziaSkrawajace[] OtworzNarzedzia(String fileName){
		System.out.println("Odczytuje Plik Narzedzia....");
		//Sciezka do pliku
		Path path = Paths.get(fileName);
		ArrayList <String> read = new ArrayList<String>();
		try{
			read = (ArrayList<String>) Files.readAllLines(path);
		}catch(IOException ex){
			System.out.println("Plik narzêdzi nie istnieje");
			System.out.println();
		}
		NarzedziaSkrawajace[] tablicaNarzedzi = new NarzedziaSkrawajace[read.size()];
		int i = 0;
		for(String line : read){
			
			String[] textLine = line.split(",");
			NarzedziaSkrawajace narzedzie = new NarzedziaSkrawajace(textLine[0],textLine[1],textLine[2],textLine[3],textLine[4],textLine[5]);
			tablicaNarzedzi[i]=narzedzie;
			i++;
		}
		System.out.println("Plik Narzedzia Odczytany");
		System.out.println();
		return tablicaNarzedzi;
	}
	
	/**
	 * 
	 * @param fileName Œcie¿ka pliku
	 * @return Tablice narzêdzi w g³owicy
	 */
	public GlowicaNarzedziowa[] UtworzGlowice(String fileName){
		File f = new File(fileName);
		if(!f.exists()){
			System.out.println("Tworze tablice Glowicy....");
			GlowicaNarzedziowa[] Glowica = new GlowicaNarzedziowa[MAXPozycji];
			for(Integer i=0;i<MAXPozycji;i++){
				Integer a=+i+1;
				GlowicaNarzedziowa Pozycja = new GlowicaNarzedziowa("test", "test","test", "test", "test", "test", a);
				
				Glowica[i]=Pozycja;
			}
			return Glowica;
		}else{
			System.out.println("Odczytuje Plik Glowicy....");
			//Sciezka do pliku
			Path path = Paths.get(fileName);
			ArrayList <String> read = new ArrayList<String>();
			try{
				read = (ArrayList<String>) Files.readAllLines(path);
			}catch(IOException ex){
				System.out.println("Plik g³owicy nie istnieje");
				System.out.println();
			}
			GlowicaNarzedziowa[] tablicaGlowicy = new GlowicaNarzedziowa[MAXPozycji];
			int i = 0;
			for(String line : read){
				
				String[] textLine = line.split(",");
				// nazwa narzedzia , nr geometri ;
				GlowicaNarzedziowa glowica = new GlowicaNarzedziowa(textLine[0],textLine[1],textLine[2], textLine[3], textLine[4], textLine[5], Integer.parseInt(textLine[6]));
				tablicaGlowicy[i]=glowica;
				i++;
			}
			System.out.println("Plik Glowicy Odczytany");
			System.out.println();
			return tablicaGlowicy;
		}
		
	}
	
	public Gwinty[] OdczytajGwinty(String fileName){
		System.out.println("Odczytuje Plik Gwinty....");
		//Sciezka do pliku
		Path path = Paths.get(fileName);
		ArrayList <String> read = new ArrayList<String>();
		try{
			read = (ArrayList<String>) Files.readAllLines(path);
		}catch(IOException ex){
			System.out.println("Plik Gwintów nie istnieje");
			System.out.println();
		}
		Gwinty[] gwinty = new Gwinty[read.size()];
		int i = 0;
		for(String line : read){
			
			String[] textLine = line.split(",");
			// nazwa narzedzia , nr geometri ;
			Gwinty gwint = new Gwinty(textLine[0],textLine[1],textLine[2],textLine[3],textLine[4]);
			gwinty[i]=gwint;
			i++;
		}
		System.out.println("Plik Gwinty Odczytany");
		System.out.println();
		return gwinty;
		
	}
	
	public PodcieciaGwintu[] OdczytajPodcieciaGwintu(String fileName){
		System.out.println("Odczytuje Plik Podciec Gwintu....");
		//Sciezka do pliku
		Path path = Paths.get(fileName);
		ArrayList <String> read = new ArrayList<String>();
		try{
			read = (ArrayList<String>) Files.readAllLines(path);
		}catch(IOException ex){
			System.out.println("Plik podciec nie istnieje");
			System.out.println();
		}
		PodcieciaGwintu[] ListaPodciec = new PodcieciaGwintu[read.size()];
		int i = 0;
		for(String line : read){
			
			String[] textLine = line.split(",");
			// nazwa narzedzia , nr geometri ;
			PodcieciaGwintu podciecie = new PodcieciaGwintu(textLine[0],textLine[1],textLine[2],textLine[3],textLine[4]);
			ListaPodciec[i]=podciecie;
			i++;
		}
		System.out.println("Plik Podciecia Odczytany");
		System.out.println();
		return ListaPodciec;
	}

	public String getSciezkaGwintow() {
		return SciezkaGwintow;
	}

	public String getSciezkaPodciecia() {
		return SciezkaPodciecia;
	}
	
	
	
	
	
}
