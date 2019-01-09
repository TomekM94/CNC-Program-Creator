package Detale;

import Dane.Gwinty;

public class Sruby {
	private double SrednicaWalka;
	private Gwinty gwint;
	private double DlugoscGwintu;
	private double SrednicaKolnierza;
	private double DlugoscSruby;
	private double WielkoscFaz;
	private double MaksymalneObrotyWrzeciona;
	private boolean Podciecie;
	private boolean DodatkoweNarzedzie;
	/**
	 * 
	 * @param srednicaW Œrednica wa³ka
	 * @param Gwint Gwint
	 * @param dlugoscG D³ugoœæ gwintu
	 * @param srednicaK Œrednica ko³nierzu
	 * @param dlugoscS D³ugoœæ œruby
	 * @param wielkoscF Wielkoœæ faz
	 * @param podciecie Podciêcie gwintu
	 * @param dodatkoweN Dodatkowe narzêdzie
	 */
	public Sruby(
			double srednicaW, 
			Gwinty Gwint,
			double dlugoscG,
			double srednicaK, 
			double dlugoscS, 
			double wielkoscF,
			double maksObrW,
			boolean podciecie,
			boolean dodatkoweN){
		this.SrednicaWalka = srednicaW;
		this.gwint = Gwint;
		this.DlugoscGwintu = dlugoscG;
		this.SrednicaKolnierza = srednicaK;
		this.DlugoscSruby = dlugoscS;
		this.WielkoscFaz = wielkoscF;
		this.MaksymalneObrotyWrzeciona = maksObrW;
		this.Podciecie = podciecie;
		this.DodatkoweNarzedzie = dodatkoweN;
	}
	
	public double getSrednicaWalka() {
		return SrednicaWalka;
	}

	public void setSrednicaWalka(double srednicaWalka) {
		SrednicaWalka = srednicaWalka;
	}

	public Gwinty getGwint() {
		return gwint;
	}

	public void setGwint(Gwinty gwint) {
		this.gwint = gwint;
	}

	public double getDlugoscGwintu() {
		return DlugoscGwintu;
	}

	public void setDlugoscGwintu(double dlugoscGwintu) {
		DlugoscGwintu = dlugoscGwintu;
	}

	public double getSrednicaKolnierza() {
		return SrednicaKolnierza;
	}

	public void setSrednicaKolnierza(double srednicaKolnierza) {
		SrednicaKolnierza = srednicaKolnierza;
	}

	public double getDlugoscSruby() {
		return DlugoscSruby;
	}

	public void setDlugoscSruby(double dlugoscSruby) {
		DlugoscSruby = dlugoscSruby;
	}

	public double getWielkoscFaz() {
		return WielkoscFaz;
	}

	public void setWielkoscFaz(double wielkoscFaz) {
		WielkoscFaz = wielkoscFaz;
	}

	public boolean isPodciecie() {
		return Podciecie;
	}

	public void setPodciecie(boolean podciecie) {
		Podciecie = podciecie;
	}

	public boolean isDodatkoweNarzedzie() {
		return DodatkoweNarzedzie;
	}

	public void setDodatkoweNarzedzie(boolean dodatkoweNarzedzie) {
		DodatkoweNarzedzie = dodatkoweNarzedzie;
	}

	public double getMaksymalneObrotyWrzeciona() {
		return MaksymalneObrotyWrzeciona;
	}

	public void setMaksymalneObrotyWrzeciona(double maksymalneObrotyWrzeciona) {
		MaksymalneObrotyWrzeciona = maksymalneObrotyWrzeciona;
	}
}
