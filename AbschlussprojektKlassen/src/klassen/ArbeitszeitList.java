package klassen;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ArbeitszeitList {
	
	//Instanzvariablen
	private ArrayList<Arbeitszeit> arbeitszeiten;

	public ArbeitszeitList(ArrayList<Arbeitszeit> arbeitszeiten) {
		super();
		this.arbeitszeiten = arbeitszeiten;
	}
	
	//Konstruktor
	public ArbeitszeitList() {}
	
	//Um die Arbeitszeitliste deserialisieren zu k?nnen
	public ArbeitszeitList(String xmlString) {
		if(xmlString == null || xmlString.length() == 0) {
			return;
		}
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			XMLHandler xh = new XMLHandler();
			sp.parse(new InputSource(new StringReader(xmlString)), xh);
			arbeitszeiten = xh.getArbeitszeiten();
		} catch (ParserConfigurationException | SAXException | IOException e) {

			e.printStackTrace();
		}
	}

	//Getters und Setters
	public ArrayList<Arbeitszeit> getArbeitszeiten() {
		return arbeitszeiten;
	}

	public void setArbeitszeiten(ArrayList<Arbeitszeit> arbeitszeiten) {
		this.arbeitszeiten = arbeitszeiten;
	}
	
	//Umwandeln auf XML-Darstellung
	public String toXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<arbeitszeitlist>");
		if(arbeitszeiten != null) {
			for(Arbeitszeit einAZ : arbeitszeiten) {
				sb.append(einAZ.toXML());
			}
		}

		sb.append("</arbeitszeitlist>");
		return sb.toString();
	}

}
