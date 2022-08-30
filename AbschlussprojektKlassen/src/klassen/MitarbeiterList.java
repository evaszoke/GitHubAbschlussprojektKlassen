package klassen;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class MitarbeiterList {
	
	//Instanzvariable
	private ArrayList<Mitarbeiter> mitarbeiterElemente;

	//Konstruktor
	public MitarbeiterList(ArrayList<Mitarbeiter> mitarbeiterElemente) {
		super();
		this.mitarbeiterElemente = mitarbeiterElemente;
	}
	
	public MitarbeiterList() {}

	//Um die Mitarbeiterliste deserialisieren zu können
	public MitarbeiterList(String xmlString) {
		if(xmlString == null || xmlString.length() == 0) {
			return;
		}
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			XMLHandler xh = new XMLHandler();
			sp.parse(new InputSource(new StringReader(xmlString)), xh);
			mitarbeiterElemente = xh.getMitarbeiterElemente();
		} catch (ParserConfigurationException | SAXException | IOException e) {

			e.printStackTrace();
		}
	}

	//Getters und Setters
	public ArrayList<Mitarbeiter> getMitarbeiterElemente() {
		return mitarbeiterElemente;
	}

	public void setMitarbeiterElemente(ArrayList<Mitarbeiter> mitarbeiterElemente) {
		this.mitarbeiterElemente = mitarbeiterElemente;
	}

	//Umwandeln auf XML-Darstellung
	public String toXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<mitarbeiterlist>");
		if(mitarbeiterElemente != null) {
			for(Mitarbeiter einMA : mitarbeiterElemente) {
				sb.append(einMA.toXML());
			}
		}
		sb.append("</mitarbeiterlist>");
		return sb.toString();
	}

}
