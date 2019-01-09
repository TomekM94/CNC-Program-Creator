package Narzedzia;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class GlowicaNarzedziowa extends NarzedziaSkrawajace {
	
	private final SimpleIntegerProperty numerPozycji;
	
	public GlowicaNarzedziowa(String nazwaNarzedzia, String WsporzedneX, String WspolrzedneZ,String posowN,String glebokoscS,String predkoscS,Integer numer) {
		super(nazwaNarzedzia, WsporzedneX, WspolrzedneZ, posowN, glebokoscS, predkoscS);
		this.numerPozycji = new SimpleIntegerProperty(numer);
		
	}

	public IntegerProperty getPropertyNumerPozycji() {
		return numerPozycji;
	}
	
	public final Integer getNumerPozycji(){
		return numerPozycji.get();
		
	}
	
	

}
