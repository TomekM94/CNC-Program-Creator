package Generatory;

import Dane.Gwinty;
import Dane.PodcieciaGwintu;
import Detale.Sruby;
import Detale.Tuleje;
import Narzedzia.GlowicaNarzedziowa;
import ZapisOdczytPlikow.Odczyt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * 
 * @author Tomasz Madeja
 *
 */
public class GeneratorKoduCNC {
	private String Kod;

	public String getKod() {
		return Kod;
	}

	public void setKod(String kod) {
		Kod = kod;
	}
	Odczyt o = new Odczyt();
	private final ObservableList<PodcieciaGwintu> ListaPodciec = FXCollections.observableArrayList(
			o.OdczytajPodcieciaGwintu(o.getSciezkaPodciecia()));
	
	/**
	 * Funkcja Przyjmujaca parametr detal i sprawdzajaca jego instancje
	 * do wygenerowania kodu, oraz narzedzia.
	 * @param detal instancja z package "Detale"
	 * @return Zwraca kod typu String
	 */
	public String GenerujTuleje(Tuleje detal,GlowicaNarzedziowa... narzedzie){
		System.out.println("Sprawdzenie poprawnoœci przes³anych danych");
			if(narzedzie.length >= 5){
				Kod = "G54;\n"
						+ "G53 G00 Z-400 X0;\n"
						+ "G99 G88 G40 G18;\n"
						+ "S"+((Tuleje)detal).getMaksymalnaPredkoscWrzeciona()+" M03;\n"
						+ NumerPozycjiZNumeremGeometri(narzedzie[0])
						+ "M96 S"+narzedzie[0].getPredkoscSkrawania()+" M03;\n";
						
				if(((Tuleje) detal).getSrednicaWalka()>((Tuleje) detal).getSrednicaTuleji()){
					Kod +="G00 Z0 X"+(((Tuleje) detal).getSrednicaWalka() + 1) +"M08;\n"
						+ "G01 X-1.5 F0.1;\n"
						+ "G00 Z2 X"+(((Tuleje) detal).getSrednicaWalka() + 1) +";\n";
					Kod += Przetaczanie((((Tuleje) detal).getSrednicaWalka() + 1), 
							((Tuleje) detal).getSrednicaTuleji(), 
							((Tuleje) detal).getDlugoscTuleji()+Double.parseDouble(narzedzie[4].getGlebokoscSkrawania()+0.2), 
							Double.parseDouble(narzedzie[0].getGlebokoscSkrawania()), 
							Double.parseDouble(narzedzie[0].getPosow()),
							((Tuleje) detal).getWielkoscFaz(), 
							1, 
							2,
							narzedzie[1]);		 
				}else{
					Kod += "G00 Z-"+(((Tuleje) detal).getWielkoscFaz()+0.5)+" X"+(((Tuleje) detal).getSrednicaWalka() + 1)+";\n"
							+ "G01 Z0 A-45;\n"
							+ "G01 X-1.5;\n"
							+ "G00 Z5;\n"
							+ "M09;\n"
							+ "G53 G00 Z-400 X0;\n"
							+ ";\n";
				}
				Kod += NumerPozycjiZNumeremGeometri(narzedzie[2])
						+ "G97 S"+narzedzie[2].getPredkoscSkrawania()+" M03;\n"
						+ "G99 G88 G40 G18;\n"
						+ "G00 Z2 X0 M08;\n";
				if(((Tuleje) detal).isFazaNawiertakiem()){
					Kod += "G01 Z-"+(((Tuleje) detal).getSrednicaOtworu()/2 + 0.5)+"F"+narzedzie[3].getPosow()+";\n";
				}else{
					Kod += "G01 Z-2 F"+narzedzie[3].getPosow()+";\n";
				}
				Kod += "G00 Z5 M09"
						+ "G53 G00 Z-400 X0;\n"
						+ ";\n"
						+ NumerPozycjiZNumeremGeometri(narzedzie[3])
						+ "G97 S"+narzedzie[3].getPredkoscSkrawania()+" M03;\n"
						+ "G99 G88 G40 G18;\n"
						+ "G00 Z2 X0 M8;\n"
						+ "G83 Z-"+(((Tuleje) detal).getDlugoscTuleji()+3)+" F0.12"+" Q3."+" R2.;\n"
						+ "G00 Z5 M09;\n"
						+ "G53 G00 Z-400 X0;\n"
						+ ";\n"
						+ NumerPozycjiZNumeremGeometri(narzedzie[4])
						+ "G96 S"+narzedzie[4].getPredkoscSkrawania()+" M04;\n"
						+ "G99 G88 G40 G18;\n"
						+ "F"+narzedzie[4].getPosow()+";\n"
						+ "G00 Z-"+((Tuleje) detal).getDlugoscTuleji()+" X"+(((Tuleje) detal).getSrednicaTuleji()+1)+"M08;\n"
						+ "G01 X"+(((Tuleje) detal).getSrednicaTuleji()-((Tuleje) detal).getWielkoscFaz()*2+1)+" ;\n"
						+ "G00 X"+(((Tuleje) detal).getSrednicaTuleji()+1)+";\n"
						+ "G00 W"+(((Tuleje) detal).getWielkoscFaz()+0.5)+";\n"
						+ "G01 W-"+(((Tuleje) detal).getWielkoscFaz()+0.5)+" A45;\n"
						+ "G01 X"+(((Tuleje) detal).getSrednicaOtworu()+1)+";\n"
						+ "G50 S400 M04;\n"
						+ "G01 X"+(((Tuleje) detal).getSrednicaOtworu()-2)+";\n"
						+ "G00 X"+(((Tuleje) detal).getSrednicaTuleji()+1)+" M09;\n"
						+ "G53 G00 Z-400 X0;\n"
						+ "M30;\n";
			return Kod;
			
			}
		return "B³ad Generacji";
		
	}
	
	public String GenerujSrube(Sruby detal,GlowicaNarzedziowa... narzedzie){
		System.out.println("Sprawdzam ListePodciec d³ugoœæ = "+ListaPodciec.size());
			Kod = "G54;\n"
				+ "G53 G00 Z-400 X0;\n"
				+ "G99 G88 G40 G18;\n"
				+ "S"+detal.getMaksymalneObrotyWrzeciona()+" M03;\n"
				+ NumerPozycjiZNumeremGeometri(narzedzie[0])
				+ "G96 S"+narzedzie[0].getPredkoscSkrawania()+" M03;\n"
				+ "G00 Z0 X"+(detal.getSrednicaWalka()+1)+"M08;\n"
				+ "G01 X-1.5 F0.1;\n"
				+ "G00 Z2 X"+(detal.getSrednicaWalka()+1)+";\n";
				System.out.println("Sprawdzam czy jest dodatkowe narzedzie ");
			if(detal.isDodatkoweNarzedzie()){
				System.out.println("Jest dodatkowe narzedzie");
				Kod += "G53 G00 Z-400 X0;\n"
					+ ";\n"
					+ NumerPozycjiZNumeremGeometri(narzedzie[3])+";\n"
					+ "G96 S"+narzedzie[4].getPredkoscSkrawania()+" M03;\n"
					+ "G00 Z2 X"+(detal.getSrednicaWalka()+1)+"M08;\n"
					+ PrzetaczanieNaSrube(
							detal,
							detal.getSrednicaWalka()+1, 
							Double.parseDouble(detal.getGwint().getXgorna()), 
							detal.getDlugoscSruby(), 
							detal.getDlugoscGwintu(), 
							detal.getSrednicaKolnierza(), 
							Double.parseDouble(narzedzie[1].getGlebokoscSkrawania()), 
							Double.parseDouble(narzedzie[1].getPosow()), 
							detal.getWielkoscFaz(), 
							1, 
							2, 
							narzedzie[1])
					+"M09 ;\n"
					+ "G53 G00 Z-400 X0;\n"
					+ ";\n";
			}else{
				System.out.println("Nie ma dodatkowego narzedzia");
				Kod += PrzetaczanieNaSrube(
						detal,
						(detal.getSrednicaWalka()+1), 
						Double.parseDouble(((Sruby)detal).getGwint().getXgorna()), 
						((Sruby)detal).getDlugoscSruby(), 
						((Sruby)detal).getDlugoscGwintu(), 
						((Sruby)detal).getSrednicaKolnierza(), 
						Double.parseDouble(narzedzie[1].getGlebokoscSkrawania()), 
						Double.parseDouble(narzedzie[1].getPosow()), 
						((Sruby)detal).getWielkoscFaz(), 
						1, 
						2, 
						narzedzie[1])
						+"M09 ;\n"
						+ "G53 G00 Z-400 X0;\n"
						+ ";\n";
			}
			Kod += "G99 G88 G40 G18;\n"
					+ "S"+((Sruby)detal).getMaksymalneObrotyWrzeciona()+" M03;\n"
					+ NumerPozycjiZNumeremGeometri(narzedzie[2])
					+ "G96 S"+narzedzie[2].getPredkoscSkrawania()+" M03;\n"
					+ "G00 Z2 X"+(((Sruby)detal).getSrednicaWalka()+1)+"M08;\n"
					+ "G76 Z-"+(((Sruby)detal).getDlugoscGwintu()-0.2)+" X"+((Sruby)detal).getGwint().getXdolna()+" F"+((Sruby)detal).getGwint().getSkok()+" K"+((Sruby)detal).getGwint().getK()+" D"+narzedzie[2].getGlebokoscSkrawania()+";\n"
					+ "M09;\n"
					+ "G53 G0Z-400 X0;\n"
					+ "M30;\n"
					+ ";";
			
		
			return Kod;
		
	}
	
	public String GenerujFrezowanieZ2Stron(double Szerokosc,double Dlugosc,double Swalka,GlowicaNarzedziowa narzedzie){
		Kod = "G54;\n"
			+ "G53 G00 Z-400 X0;\n"
			+ "G98 G88 G40 G17;\n"
			+ NumerPozycjiZNumeremGeometri(narzedzie)
			+ "M133 P"+narzedzie.getPredkoscSkrawania()+";\n"
			+ "M154;\n"
			+ "F"+narzedzie.getPosow()+";\n"
			+ "G00 Z-"+Dlugosc+" X"+(Swalka/2+6)+" Y"+(Szerokosc/2+2)+" M08;\n"
			+ "G41 G01 X"+(Swalka/2+2)+" Y"+(Szerokosc/2)+";\n"
			+ "G01 X-"+(Swalka/2+2)+";\n"
			+ "G00 Y-"+(Szerokosc/2)+";\n"
			+ "G01 X"+(Swalka/2+6)+";\n"
			+ "G40;\n"
			+ "G18;\n"
			+ "M09;\n"
			+ "M135;\n"
			+ "M155;\n"
			+ "G53 G0Z-400 X0;\n";
		return Kod;
		
	}
	
	public String GenerujFrezowanieSzesciokat(double Szerokosc,double Dlugosc,double Swalka,GlowicaNarzedziowa narzedzie){
		double a = ((Swalka/2)*2/Math.sqrt(3));
		
		Kod = "G54;\n"
			+ "G53 G00 Z-400 X0;\n"
			+ "G98 G88 G40 G17;\n"
			+ NumerPozycjiZNumeremGeometri(narzedzie)
			+ "M133 P"+narzedzie.getPredkoscSkrawania()+";\n"
			+ "M154;\n"
			+ "F"+narzedzie.getPosow()+";\n"
			+ "G00 Z-"+Dlugosc+" X"+(Swalka/2+6)+" Y"+(Szerokosc/2+2)+" M08;\n"
			+ "G41 G01 X"+(a*2)+" Y"+(0)+";\n"
			+ "G01 X"+(a)+" Y"+(a/2)+";\n"
			+ "G01 X"+(0)+" Y"+(a)+";\n"
			+ "G01 X-"+(a)+" Y"+(a/2)+";\n"
			+ "G01 X-"+(a)+" Y-"+(a/2)+";\n"
			+ "G01 X"+(0)+" Y-"+(a)+";\n"
			+ "G01 X"+(a)+" Y-"+(a/2)+";\n"
			+ "G01 X"+(a)+" Y-"+(a*2)+";\n"
			+ "G40;\n"
			+ "G18;\n"
			+ "M09;\n"
			+ "M135;\n"
			+ "M155;\n"
			+ "G53 G0Z-400 X0;\n";
		
		return Kod;
		
	}
	
	public String GenerujFrezowanieKwadrat(double Szerokosc,double Dlugosc,double Swalka,GlowicaNarzedziowa narzedzie){
		Kod = "G54;\n"
				+ "G53 G00 Z-400 X0;\n"
				+ "G98 G88 G40 G17;\n"
				+ NumerPozycjiZNumeremGeometri(narzedzie)
				+ "M133 P"+narzedzie.getPredkoscSkrawania()+";\n"
				+ "M154;\n"
				+ "F"+narzedzie.getPosow()+";\n"
				+ "G00 Z-"+Dlugosc+" X"+(Swalka/2+6)+" Y"+(Szerokosc/2+2)+" M08;\n"
				+ "G41 G01 X"+(Szerokosc)+" Y"+(Szerokosc)+";\n"
				+ "G01 X-"+(Szerokosc)+" Y"+(Szerokosc)+";\n"
				+ "G01 X-"+(Szerokosc)+" Y-"+(Szerokosc)+";\n"
				+ "G01 X"+(Szerokosc)+" Y-"+(Szerokosc)+";\n"
				+ "G01 X"+(Szerokosc)+" Y"+(Szerokosc*2)+";\n"
				+ "G40;\n"
				+ "G18;\n"
				+ "M09;\n"
				+ "M135;\n"
				+ "M155;\n"
				+ "G53 G0Z-400 X0;\n";
		
		return Kod;
		
	}
	
	public String GenerujPodcieciePodGwint(Sruby Sruba){
		String KodPodciecia="";
		String SrednicaGwintu = Sruba.getGwint().getXgorna();
		PodcieciaGwintu podciecie = fromSkok(Sruba.getGwint().getSkok());
		double DlugoscGwintu = Sruba.getDlugoscGwintu();
		double df ;
		double f1 ;
		double f2 ;
		double R ;
		
		
		df = Double.parseDouble(SrednicaGwintu) - Double.parseDouble(podciecie.getDf());
		f1 = Double.parseDouble(podciecie.getF1());
		f2 = Double.parseDouble(podciecie.getF2());
		R = Double.parseDouble(podciecie.getR());
		
		KodPodciecia = "G00 Z-"+(DlugoscGwintu - f2 - 0.5 )+" X"+(SrednicaGwintu+0.5)+";\n"
				+ "G71 P3. Q4. F0.1 D0.5 I0.1 K0.05;\n"
				+ "N3 G01 Z-"+(DlugoscGwintu - f2)+" X"+(SrednicaGwintu)+";\n"
				+ "G01 Z-"+(DlugoscGwintu-f1)+" X"+df+";\n"
				+ "G01 Z-"+(DlugoscGwintu-R)+";\n"
				+ "G02 Z-"+DlugoscGwintu+" X"+(df+R*2)+";\n"
				+ "N4 G01 X"+(SrednicaGwintu+0.5)+";\n";
		
		
		return KodPodciecia;
		
	}
	
	
	/**
	 * Metoda generuje Cykl toczenia G71 dla Tuleji
	 * @param sStartowa Srednica Startowa (Srednica Walka + 1mm)
	 * @param sDocelowa Srednica Dolecowa
	 * @param dlugoscDocelowa dlugoscDocelowa
	 * @param glebokoscSkrawania (zalezna od narzedzia)
	 * @param posow (Posow w MM na Obrot)
	 * @param faza (Kat 45 Staly)
	 * @param numerblokuPoczatkujacego
	 * @param numerblokuKoncowego
	 * @param wykanczak
	 * @return wygenerowany cykl przetaczania
	 */
	public String Przetaczanie(double sStartowa, double sDocelowa, double dlugoscDocelowa, double glebokoscSkrawania, double posow, double faza ,int numerblokuPoczatkujacego ,int numerblokuKoncowego,GlowicaNarzedziowa wykanczak ){
		
		return "G71 D"+glebokoscSkrawania+" F"+posow+" P"+numerblokuPoczatkujacego+" Q"+numerblokuKoncowego+" W0.05 U0.3;\n"+
				"N"+numerblokuPoczatkujacego+" G00 Z1 X"+(sDocelowa-faza*2)+";\n"+
				"G01 Z0.1;\n"+
				"G01 Z-"+faza+" X"+sDocelowa+";\n"+
				"G01 Z-"+dlugoscDocelowa+";\n"+
				"N"+numerblokuKoncowego+" G01 X"+sStartowa+";\n"+
				"M09;\n"+ 
				"G53 G00 Z-400 X0;\n"
				+ ";\n"
				+ "G99 G88 G40 G18;\n"
				+ NumerPozycjiZNumeremGeometri(wykanczak)
				+ "G96 S"+wykanczak.getPredkoscSkrawania()+" M03;\n"
				+ "G00 Z2 X"+sStartowa+";\n"
				+ "G70 P"+numerblokuPoczatkujacego+" Q"+numerblokuKoncowego+" F"+wykanczak.getPosow()+";\n"
				+ "M09;\n"
				+ "G53 G00 Z-400 X0;\n"
				+ ";\n";
	}
	/**
	 * 
	 * @param sStartowa Srednica Startowa
	 * @param sGwintu Srednica Gwintu
	 * @param dlugoscSruby 
	 * @param dlugoscGwintu
	 * @param sKolnierza Srednica Kolnierza
	 * @param glebokoscSkrawania
	 * @param posow
	 * @param faza
	 * @param numerblokuPoczatkujacego
	 * @param numerblokuKoncowego
	 * @param wykanczak
	 * @return
	 */
	public String PrzetaczanieNaSrube(
			Sruby sruba,
			double sStartowa, 
			double sGwintu, 
			double dlugoscSruby,
			double dlugoscGwintu,
			double sKolnierza,
			double glebokoscSkrawania, 
			double posow, 
			double faza ,
			int numerblokuPoczatkujacego ,
			int numerblokuKoncowego,
			GlowicaNarzedziowa wykanczak){
		System.out.println("Generuje przetaczanie sruby");
		String KodP;
		KodP = "G71 P"+numerblokuPoczatkujacego+" Q"+numerblokuKoncowego+" F"+posow+" D"+glebokoscSkrawania+" U0.3 W0.05"+";\n"
		+ "N"+numerblokuPoczatkujacego+" G00 Z1 X"+(sGwintu-faza*2)+";\n"
		+ "G01 Z0.1;\n"
		+ "G01 Z-"+faza+" X"+sGwintu+";\n"
		+ "G01 Z-"+dlugoscGwintu+";\n"
		+ "G01 X"+(sKolnierza-faza*2)+";\n"
		+ "G01 X"+sKolnierza+" Z-"+faza+";\n";
		System.out.println("Sprawdzam czy œrednica wa³ka "+sStartowa+" jest wiêksza od ko³nierza "+sKolnierza);
		if(sStartowa>sKolnierza){
			System.out.println("Jest wieksza");
			KodP += "G01 Z-"+dlugoscSruby+";\n"
					+ "N"+numerblokuKoncowego+" G01 X"+sStartowa+";\n";
		}else{
			System.out.println("Nie jest");
			KodP += "N"+numerblokuKoncowego+" G01 X"+sStartowa+";\n";
		}
		System.out.println("Generowanie podciecia");
		KodP += "M09;\n"+ 
				"G53 G00 Z-400 X0;\n"
				+ ";\n"
				+ NumerPozycjiZNumeremGeometri(wykanczak)
				+ "G99 G88 G40 G18;\n"
				+ "G96 S"+wykanczak.getPredkoscSkrawania()+"M03;\n"
				+ "G00 Z2 X"+sStartowa+";\n"
				+ "G70 P"+numerblokuPoczatkujacego+" Q"+numerblokuKoncowego+" F"+wykanczak.getPosow()+";\n";
		System.out.println("Sprawdzam czy jest podciecie");
				if(sruba.isPodciecie()){
					System.out.println("Podciecie jest");
					KodP += GenerujPodcieciePodGwint(sruba);
				}
		KodP += "M09;\n"
				+ "G53 G00 Z-400 X0;\n"
				+ ";\n";	
		System.out.println("Generowanie przetaczania powiod³o siê");
		return KodP;
		
	}
	
	public String GenerujGwintowanie(Gwinty gwint,GlowicaNarzedziowa narzedzie,double dlugosc){
		Kod += NumerPozycjiZNumeremGeometri(narzedzie)
		+ "G99 G88 G40 G18;\n"
		+ "G97 S"+narzedzie.getPredkoscSkrawania()+" M03;\n"
		+ "G00 Z2 X"+(Double.parseDouble(gwint.getXgorna())+1)+";\n"
		+ "G76 Z-"+dlugosc+" X"+gwint.getXdolna()+" K"+gwint.getK()+" D"+narzedzie.getGlebokoscSkrawania()+" F"+gwint.getSkok()+";\n"
		+ "M09;\n"
		+ "G53 G00 Z-400 X0;\n"
		+ ";\n";
		return Kod;
		
	}
	
	
	public String NumerPozycjiZNumeremGeometri(GlowicaNarzedziowa narzedzie){
		String sprawdzoneNarzedzie="";
		if(narzedzie.getNumerPozycji()<10){
			sprawdzoneNarzedzie += "T"+narzedzie.getNumerPozycji()+"0"+narzedzie.getNumerPozycji()+"("+narzedzie.getNazwa()+");\n"
					+ "(X "+narzedzie.getX()+" Z "+narzedzie.getZ()+");\n";
		}else{
			sprawdzoneNarzedzie += "T"+narzedzie.getNumerPozycji()+narzedzie.getNumerPozycji()+"("+narzedzie.getNazwa()+");\n"
					+ "(X "+narzedzie.getX()+" Z "+narzedzie.getZ()+");\n";
		}
				
		return sprawdzoneNarzedzie;
		
	}
	
	
	public PodcieciaGwintu fromSkok(String skok){
		for(int i = 0; ListaPodciec.size()> i;i++){
			System.out.println("Sprawdzam "+ListaPodciec.get(i).getPodzialka());
			if(ListaPodciec.get(i).getPodzialka().equals(skok)){
				return ListaPodciec.get(i);
			}
		}
		return null;
	}

}
