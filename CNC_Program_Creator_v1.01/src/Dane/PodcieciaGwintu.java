package Dane;

import javafx.beans.property.SimpleStringProperty;

public class PodcieciaGwintu {
	
	private final SimpleStringProperty podzialka;
	private final SimpleStringProperty df;
	private final SimpleStringProperty f1;
	private final SimpleStringProperty f2;
	private final SimpleStringProperty R;
	 /**
	  * 
	  * @param podzialkaG Skok Gwintu
	  * @param D Ró¿nica œrednicy gwintu
	  * @param dlugoscP Dlugosc Podciecia œrednicy bez gwintu
	  * @param dlugoscPzZ Dlugosc Podcieci ogólna
	  * @param promien Promien w podcieciu
	  */
	public PodcieciaGwintu(String podzialkaG, String D, String dlugoscP, String dlugoscPzZ,String promien){
		this.podzialka = new SimpleStringProperty(podzialkaG);
		this.df = new SimpleStringProperty(D);
		this.f1 = new SimpleStringProperty(dlugoscP);
		this.f2 = new SimpleStringProperty(dlugoscPzZ);
		this.R = new SimpleStringProperty(promien);
	}
	
	public SimpleStringProperty getPropertyPodzialka() {
		return podzialka;
	}

	public SimpleStringProperty getPropertyDf() {
		return df;
	}

	public SimpleStringProperty getPropertyF1() {
		return f1;
	}

	public SimpleStringProperty getPropertyF2() {
		return f2;
	}

	public SimpleStringProperty getPropertyR() {
		return R;
	}
	
	public String getPodzialka() {
		return podzialka.get();
	}
	
	public String getDf() {
		return df.get();
	}
	
	public String getF1() {
		return f1.get();
	}
	
	public String getF2() {
		return f2.get();
	}
	
	public String getR() {
		return R.get();
	}
}
