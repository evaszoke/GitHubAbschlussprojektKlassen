package klassen;

import java.io.IOException;
import java.io.StringReader;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Projekt {
	
	//Instanzvariablen
	private int id;
	private String name;
	private String adresse;
	private String telefon;
	private String kontaktperson;
	private Auftraggeber auftraggeber;
	private boolean abgeschlossen;
	
	//Konstruktor
	public Projekt(int id, Auftraggeber auftraggeber, String name, String adresse, String telefon, String kontaktperson,
			boolean abgeschlossen) {
		super();
		this.id = id;
		this.auftraggeber = auftraggeber;
		this.name = name;
		this.adresse = adresse;
		this.telefon = telefon;
		this.kontaktperson = kontaktperson;
		this.abgeschlossen = abgeschlossen;
	}

	public Projekt() {}
	
	//Um den Projekt deserialisieren zu können
	public Projekt(String xmlString) {
		if(xmlString == null || xmlString.length() == 0) {
			return;
		}
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			XMLHandler xh = new XMLHandler();
			sp.parse(new InputSource(new StringReader(xmlString)), xh);
			id = xh.getProjekt().getId();
			name = xh.getProjekt().getName();
			adresse = xh.getProjekt().getAdresse();
			telefon = xh.getProjekt().getTelefon();
			kontaktperson = xh.getProjekt().getKontaktperson();
			auftraggeber = xh.getProjekt().getAuftraggeber();
			abgeschlossen = xh.getProjekt().isAbgeschlossen();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			
			e.printStackTrace();
		}
	}

	//Getters und Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Auftraggeber getAuftraggeber() {
		return auftraggeber;
	}

	public void setAuftraggeber(Auftraggeber auftraggeber) {
		this.auftraggeber = auftraggeber;
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

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getKontaktperson() {
		return kontaktperson;
	}

	public void setKontaktperson(String kontaktperson) {
		this.kontaktperson = kontaktperson;
	}

	public boolean isAbgeschlossen() {
		return abgeschlossen;
	}

	public void setAbgeschlossen(boolean abgeschlossen) {
		this.abgeschlossen = abgeschlossen;
	}

	//Umwandeln auf XML-Darstellung
	public String toXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<projekt>");
		sb.append("<projektid>" + id + "</projektid>");
		sb.append("<projektname>" + name + "</projektname>");
		sb.append("<projektadresse>" + adresse + "</projektadresse>");
		sb.append("<projekttelefon>" + telefon + "</projekttelefon>");
		sb.append("<projektkontaktperson>" + kontaktperson + "</projektkontaktperson>");
		sb.append(auftraggeber.toXML());
		sb.append("<abgeschlossen>" + abgeschlossen + "</abgeschlossen>");
		sb.append("</projekt>");
		return sb.toString();
		
	}

	//toString Methode
	@Override
	public String toString() {
		return name;
	}
	
	


}
