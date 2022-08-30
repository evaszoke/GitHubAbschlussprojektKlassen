package klassen;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Meldung {
	
	//Instanzvariable
	private String text;

	//Konstruktor
	public Meldung(String text) {
		super();
		if(text == null || text.length() == 0) {
			return;
		}
		if(!text.startsWith("<")) {
		this.text = text;
		}
		else {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			try {
				SAXParser sp = spf.newSAXParser();
				XMLHandler xh = new XMLHandler();
				sp.parse(new InputSource(new StringReader(text)), xh);
				text = xh.getMeldung().getText();
			} catch (ParserConfigurationException | SAXException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Meldung() {}

	//Getters und Setters
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	//toString Methode
	@Override
	public String toString() {
		return text;
	}
	
	//Umwandeln auf XML-Darstellung
	public String toXML() {
		return "<meldung><text>" + text + "</text></meldung>";
	}
	
	
	
	
}
