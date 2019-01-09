package Narzedzia;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NarzedziaSkrawajace {
	private final SimpleStringProperty nazwa;
	private final SimpleStringProperty X;
	private final SimpleStringProperty Z;
	private final SimpleStringProperty posow;
	private final SimpleStringProperty glebokoscSkrawania;
	private final SimpleStringProperty predkoscSkrawania;
	/**
	 *  Narzedzia Skrawajace,
	 *  Wiert³a,
	 *  Frezy,
	 *  Nawiertaki.
	 * @param nazwaNarzedzia 
	 * @param wspolrzedneX
	 * @param wspolrzedneY
	 * @param posowNarzedzia
	 * @param glebokoscSkrawaniaNarzedzia Dla Wierte³ - g³êbokoœæ dosówu
	 * @param predkoscSkrawaniaNarzedzia
	 */
	public NarzedziaSkrawajace(String nazwaNarzedzia,String wspolrzedneX,String wspolrzedneY,String posowNarzedzia, String glebokoscSkrawaniaNarzedzia, String predkoscSkrawaniaNarzedzia){
		this.nazwa = new SimpleStringProperty(nazwaNarzedzia);
		this.X = new SimpleStringProperty(wspolrzedneX);
		this.Z = new SimpleStringProperty(wspolrzedneY);
		this.posow = new SimpleStringProperty(posowNarzedzia);
		this.glebokoscSkrawania = new SimpleStringProperty(glebokoscSkrawaniaNarzedzia);
		this.predkoscSkrawania = new SimpleStringProperty(predkoscSkrawaniaNarzedzia);
	}
	public StringProperty getPropertyNazwa() {
		return nazwa;
	}
	public StringProperty getPropertyX() {
		return X;
	}
	public StringProperty getPropertyZ() {
		return Z;
	}
	public StringProperty getPropertyPosow() {
		return posow;
	}
	public StringProperty getPropertyGlebokoscSkrawania() {
		return glebokoscSkrawania;
	}
	public StringProperty getPropertyPredkoscSkrawania() {
		return predkoscSkrawania;
	}
	public final String getNazwa(){
		return nazwa.get();
	}
	public final String getX() {
		return X.get();
	}
	public final String getZ() {
		return Z.get();
	}
	public final String getPosow(){
		return posow.get();
	}
	public final String getGlebokoscSkrawania(){
		return glebokoscSkrawania.get();
	}
	public final String getPredkoscSkrawania(){
		return predkoscSkrawania.get();
	}
}