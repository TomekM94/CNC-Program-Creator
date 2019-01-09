package Detale;

public class Tuleje {
	private double SrednicaWalka;
	private double SrednicaTuleji;
	private double SrednicaOtworu;
	private double DlugoscTuleji;
	private double WielkoscFaz;
	private double MaksymalnaPredkoscWrzeciona;
	private boolean FazaNawiertakiem;
	/**
	 * 
	 * @param SrednicaW Œrednica Materia³u
	 * @param SrednicaT Œrednica Tuleji
	 * @param SrednicaO Œrednica Otworu w Tuleji
	 * @param DlugoscT D³ugoœæ Tuleji
	 * @param WielkoscF Wielkoœæ Fazy
	 * @param Faza Fazowanie Nawiertakiem
	 */
	public Tuleje(double SrednicaW, double SrednicaT, double SrednicaO, double DlugoscT, double WielkoscF,double MaksPredkoscWrzeciona, boolean Faza){
		this.SrednicaOtworu = SrednicaO;
		this.SrednicaTuleji = SrednicaT;
		this.SrednicaWalka = SrednicaW;
		this.DlugoscTuleji = DlugoscT;
		this.WielkoscFaz = WielkoscF;
		this.setMaksymalnaPredkoscWrzeciona(MaksPredkoscWrzeciona);
		this.FazaNawiertakiem = Faza;
	}
	public double getSrednicaWalka() {
		return SrednicaWalka;
	}
	public void setSrednicaWalka(double srednicaWalka) {
		SrednicaWalka = srednicaWalka;
	}
	public double getSrednicaTuleji() {
		return SrednicaTuleji;
	}
	public void setSrednicaTuleji(double srednicaTuleji) {
		SrednicaTuleji = srednicaTuleji;
	}
	public double getSrednicaOtworu() {
		return SrednicaOtworu;
	}
	public void setSrednicaOtworu(double srednicaOtworu) {
		SrednicaOtworu = srednicaOtworu;
	}
	public double getDlugoscTuleji() {
		return DlugoscTuleji;
	}
	public void setDlugoscTuleji(double dlugoscTuleji) {
		DlugoscTuleji = dlugoscTuleji;
	}
	
	public double getWielkoscFaz() {
		return WielkoscFaz;
	}
	public void setWielkoscFaz(double wielkoscFaz) {
		WielkoscFaz = wielkoscFaz;
	}
	public boolean isFazaNawiertakiem() {
		return FazaNawiertakiem;
	}
	public void setFazaNawiertakiem(boolean fazaNawiertakiem) {
		FazaNawiertakiem = fazaNawiertakiem;
	}
	public double getMaksymalnaPredkoscWrzeciona() {
		return MaksymalnaPredkoscWrzeciona;
	}
	public void setMaksymalnaPredkoscWrzeciona(double maksymalnaPredkoscWrzeciona) {
		MaksymalnaPredkoscWrzeciona = maksymalnaPredkoscWrzeciona;
	}
	
	
	
}
