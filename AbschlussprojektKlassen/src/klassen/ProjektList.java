package klassen;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ProjektList {
	
	//Instanzvariable
	private ArrayList<Projekt> projekte;

	//Konstruktor
	public ProjektList(ArrayList<Projekt> projekte) {
		super();
		this.projekte = projekte;
	}

	public ProjektList() {}

	//Um die Projektliste deserialisieren zu können
	public ProjektList(String xmlString) {
		if(xmlString == null || xmlString.length() == 0) {
			return;
		}
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			XMLHandler xh = new XMLHandler();
			sp.parse(new InputSource(new StringReader(xmlString)), xh);
			projekte = xh.getProjekte();
		} catch (ParserConfigurationException | SAXException | IOException e) {

			e.printStackTrace();
		}
	}

	//Getters und Setters
	public ArrayList<Projekt> getProjekte() {
		return projekte;
	}

	public void setProjekte(ArrayList<Projekt> projekte) {
		this.projekte = projekte;
	}
	
	//Umwandeln auf XML-Darstellung
	public String toXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<projektlist>");
		if(projekte != null) {
			for(Projekt einP : projekte) {
				sb.append(einP.toXML());
			}
		}

		sb.append("</projektlist>");
		return sb.toString();
	}


}
