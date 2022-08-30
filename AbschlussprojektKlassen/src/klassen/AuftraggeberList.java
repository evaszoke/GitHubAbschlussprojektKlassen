package klassen;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class AuftraggeberList {
	
	//Instanzvariable
	private ArrayList<Auftraggeber> auftraggeberElemente;
	
	//Konstruktor
	public AuftraggeberList(ArrayList<Auftraggeber> auftraggeberElemente) {
		super();
		this.auftraggeberElemente = auftraggeberElemente;
	}

	public AuftraggeberList() {}

	//Um die Auftraggeberliste deserialisieren zu können
	public AuftraggeberList(String xmlString) {
		if(xmlString == null || xmlString.length() == 0) {
			return;
		}
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			XMLHandler xh = new XMLHandler();
			sp.parse(new InputSource(new StringReader(xmlString)), xh);
			auftraggeberElemente = xh.getAuftraggeberElemente();
		} catch (ParserConfigurationException | SAXException | IOException e) {

			e.printStackTrace();
		}
	}

	//Getters und Setters
	public ArrayList<Auftraggeber> getAuftraggeberElemente() {
		return auftraggeberElemente;
	}

	public void setAuftraggeberElemente(ArrayList<Auftraggeber> auftraggeberElemente) {
		this.auftraggeberElemente = auftraggeberElemente;
	}

	//Umwandeln auf XML-Darstellung
	public String toXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<auftraggeberlist>");
		if(auftraggeberElemente != null) {
			for(Auftraggeber einAG : auftraggeberElemente) {
				sb.append(einAG.toXML());
			}
		}
		sb.append("</auftraggeberlist>");
		return sb.toString();
	}
}
