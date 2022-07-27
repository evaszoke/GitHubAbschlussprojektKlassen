package klassen;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Arbeitszeit {
	private int zeilennummer;
	private LocalDate datum;
	private Mitarbeiter mitarbeiter;
	private Projekt projekt;
	private String von;
	private String bis;
	private double stundengesamt;
	private double stundensatz;
	private boolean fakturiert;
	
	public Arbeitszeit(int zeilennummer, LocalDate datum, Mitarbeiter mitarbeiter, Projekt projekt, String von,
			String bis, double stundengesamt, double stundensatz, boolean fakturiert) {
		super();
		this.zeilennummer = zeilennummer;
		this.datum = datum;
		this.mitarbeiter = mitarbeiter;
		this.projekt = projekt;
		this.von = von;
		this.bis = bis;
		this.stundengesamt = stundengesamt;
		this.stundensatz = stundensatz;
		this.fakturiert = fakturiert;
	}

	public Arbeitszeit() {}
	
	public Arbeitszeit(String xmlString) {
		if(xmlString == null || xmlString.length() == 0) {
			return;
		}
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			XMLHandler xh = new XMLHandler();
			sp.parse(new InputSource(new StringReader(xmlString)), xh);
			zeilennummer = xh.getArbeitszeit().getZeilennummer();
			datum = xh.getArbeitszeit().getDatum();
			mitarbeiter = xh.getArbeitszeit().getMitarbeiter();
			projekt = xh.getArbeitszeit().getProjekt();
			von = xh.getArbeitszeit().getVon();
			bis = xh.getArbeitszeit().getBis();
			stundengesamt = xh.getArbeitszeit().getStundengesamt();
			stundensatz = xh.getArbeitszeit().getStundensatz();
			fakturiert = xh.getArbeitszeit().isFakturiert();
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			
			e.printStackTrace();
		}
	}

	public int getZeilennummer() {
		return zeilennummer;
	}

	public void setZeilennummer(int zeilennummer) {
		this.zeilennummer = zeilennummer;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}

	public String getVon() {
		return von;
	}

	public void setVon(String von) {
		this.von = von;
	}

	public String getBis() {
		return bis;
	}

	public void setBis(String bis) {
		this.bis = bis;
	}

	public double getStundengesamt() {
		return stundengesamt;
	}

	public void setStundengesamt(double stundengesamt) {
		this.stundengesamt = stundengesamt;
	}

	public double getStundensatz() {
		return stundensatz;
	}

	public void setStundensatz(double stundensatz) {
		this.stundensatz = stundensatz;
	}

	public boolean isFakturiert() {
		return fakturiert;
	}

	public void setFakturiert(boolean fakturiert) {
		this.fakturiert = fakturiert;
	}
	
	public String toXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<arbeitszeit>");
		sb.append("<zeilennummer>" + zeilennummer + "</zeilennummer>");
		sb.append("<arbeitszeitdatum>" + datum + "</arbeitszeitdatum>");
		sb.append(mitarbeiter.toXML());
		sb.append(projekt.toXML());
		sb.append("<arbeitszeitvon>" + von + "</arbeitszeitvon>");
		sb.append("<arbeitszeitbis>" + bis + "</arbeitszeitbis>");
		sb.append("<stundengesamt>" + stundengesamt + "</stundengesamt>");
		sb.append("<arbeitszeitstundensatz>" + stundensatz + "</arbeitszeitstundensatz>");
		sb.append("<fakturiert>" + fakturiert + "</fakturiert>");
		sb.append("</arbeitszeit>");
		return sb.toString();
		
	}
	
	

}
