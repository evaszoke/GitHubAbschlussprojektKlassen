package klassen;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Mitarbeiter {
	private int id;
	private String name;
	private String adresse;
	private LocalDate geburtsdat;
	private String svNummer;
	private String telefon;
	private String email;
	private double wochenarbeitszeit;
	private double stundensatz;
	public Mitarbeiter(int id, String name, String adresse, LocalDate geburtsdat, String svNummer, String telefon,
			String email, double wochenarbeitszeit, double stundensatz) {
		super();
		this.id = id;
		this.name = name;
		this.adresse = adresse;
		this.geburtsdat = geburtsdat;
		this.svNummer = svNummer;
		this.telefon = telefon;
		this.email = email;
		this.wochenarbeitszeit = wochenarbeitszeit;
		this.stundensatz = stundensatz;
	}
	
	public Mitarbeiter() {}
	
	
	//um den Mitarbeiter deserialisieren zu können
	public Mitarbeiter(String xmlString) {
		if(xmlString == null || xmlString.length() == 0) {
			return;
		}
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			XMLHandler xh = new XMLHandler();
			sp.parse(new InputSource(new StringReader(xmlString)), xh);
			id = xh.getMitarbeiter().getId();
			name = xh.getMitarbeiter().getName();
			adresse = xh.getMitarbeiter().getAdresse();
			geburtsdat = xh.getMitarbeiter().getGeburtsdat();
			svNummer = xh.getMitarbeiter().getSvNummer();
			telefon = xh.getMitarbeiter().getTelefon();
			email = xh.getMitarbeiter().getEmail();
			wochenarbeitszeit = xh.getMitarbeiter().getWochenarbeitszeit();
			stundensatz = xh.getMitarbeiter().getStundensatz();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public LocalDate getGeburtsdat() {
		return geburtsdat;
	}

	public void setGeburtsdat(LocalDate geburtsdat) {
		this.geburtsdat = geburtsdat;
	}

	public String getSvNummer() {
		return svNummer;
	}

	public void setSvNummer(String svNummer) {
		this.svNummer = svNummer;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getWochenarbeitszeit() {
		return wochenarbeitszeit;
	}

	public void setWochenarbeitszeit(double wochenarbeitszeit) {
		this.wochenarbeitszeit = wochenarbeitszeit;
	}

	public double getStundensatz() {
		return stundensatz;
	}

	public void setStundensatz(double stundensatz) {
		this.stundensatz = stundensatz;
	}
	
	public String toXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<mitarbeiter>");
		sb.append("<mitarbeiterid>" + id + "</mitarbeiterid>");
		sb.append("<mitarbeitername>" + name + "</mitarbeitername>");
		sb.append("<mitarbeiteradresse>" + adresse + "</mitarbeiteradresse>");
		sb.append("<mitarbeitergeburtsdat>" + geburtsdat + "</mitarbeitergeburtsdat>");
		sb.append("<mitarbeitersvnummer>" + svNummer + "</mitarbeitersvnummer>");
		sb.append("<mitarbeitertelefon>" + telefon + "</mitarbeitertelefon>");
		sb.append("<mitarbeiteremail>" + email + "</mitarbeiteremail>");
		sb.append("<mitarbeiterwochenarbeitszeit>" + wochenarbeitszeit + "</mitarbeiterwochenarbeitszeit>");
		sb.append("<mitarbeiterstundensatz>" + stundensatz + "</mitarbeiterstundensatz>");
		sb.append("</mitarbeiter>");
		return sb.toString();
		
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
	

}
