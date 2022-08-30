package klassen;

import java.io.IOException;
import java.io.StringReader;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Auftraggeber {
	
	//Instanzvariablen
	private int id;
	private String name;
	private String adresse;
	private String telefon;
	private String email;
	
	//Konstruktor
	public Auftraggeber(int id, String name, String adresse, String telefon, String email) {
		super();
		this.id = id;
		this.name = name;
		this.adresse = adresse;
		this.telefon = telefon;
		this.email = email;
	}


	public Auftraggeber() {}
	
	
	//Um den Auftraggeber deserialisieren zu können
	public Auftraggeber(String xmlString) {
		if(xmlString == null || xmlString.length() == 0) {
			return;
		}
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			XMLHandler xh = new XMLHandler();
			sp.parse(new InputSource(new StringReader(xmlString)), xh);
			id = xh.getAuftraggeber().getId();
			name = xh.getAuftraggeber().getName();
			adresse = xh.getAuftraggeber().getAdresse();
			telefon = xh.getAuftraggeber().getTelefon();
			email = xh.getAuftraggeber().getEmail();
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	//Umwandeln auf XML-Darstellung
	public String toXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<auftraggeber>");
		sb.append("<auftraggeberid>" + id + "</auftraggeberid>");
		sb.append("<auftraggebername>" + name + "</auftraggebername>");
		sb.append("<auftraggeberadresse>" + adresse + "</auftraggeberadresse>");
		sb.append("<auftraggebertelefon>" + telefon + "</auftraggebertelefon>");
		sb.append("<auftraggeberemail>" + email + "</auftraggeberemail>");
		sb.append("</auftraggeber>");
		return sb.toString();
	}

	//toString Methode
	@Override
	public String toString() {
		return name;
	}
	
	


}
