package Dane;


import javafx.beans.property.SimpleStringProperty;

public class Gwinty {
	private final SimpleStringProperty nazwa;
	private final SimpleStringProperty skok;
	private final SimpleStringProperty Xgorna;
	private final SimpleStringProperty Xdolna;
	private final SimpleStringProperty K;
	
	public Gwinty (String nazwaG,String skokG,String xG,String xD,String k){
		this.nazwa = new SimpleStringProperty(nazwaG);
		this.skok = new SimpleStringProperty(skokG);
		this.Xgorna = new SimpleStringProperty(xG);
		this.Xdolna = new SimpleStringProperty(xD);
		this.K = new SimpleStringProperty(k);
	}


	public SimpleStringProperty getPropertyNazwa() {
		return nazwa;
	}


	public SimpleStringProperty getPropertySkok() {
		return skok;
	}


	public SimpleStringProperty getPropertyXgorna() {
		return Xgorna;
	}
	
	public SimpleStringProperty getPropertyXdolna() {
		return Xdolna;
	}

	public SimpleStringProperty getPropertyK() {
		return K;
	}
	
	public final String getNazwa(){
		return nazwa.get();
	}
	
	public final String getSkok(){
		return skok.get();
	}

	public final String getK(){
		return K.get();
	}

	public final String getXgorna() {
		return Xgorna.get();
	}


	public final String getXdolna() {
		return Xdolna.get();
	}
	
}
