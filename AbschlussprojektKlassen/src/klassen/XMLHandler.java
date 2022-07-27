package klassen;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {
	
	private Mitarbeiter mitarbeiter;
	private Auftraggeber auftraggeber;
	private ArrayList<Mitarbeiter> mitarbeiterElemente;
	private ArrayList<Auftraggeber> auftraggeberElemente;
	private Projekt projekt;
	private ArrayList<Projekt> projekte;
	private Arbeitszeit arbeitszeit;
	private ArrayList<Arbeitszeit> arbeitszeiten;
	private Meldung meldung;
	private String text;
	
	public void startElement (String uri , String localName, String qName , Attributes attributes)
			throws	SAXException {
				switch(qName.toUpperCase()) {
				case "MITARBEITERLIST":
					mitarbeiterElemente = new ArrayList<>();
					break;
				case "MITARBEITER":
					mitarbeiter = new Mitarbeiter();
					break;	
				case "AUFTRAGGEBERLIST":
					auftraggeberElemente = new ArrayList<>();
					break;
				case "AUFTRAGGEBER":
					auftraggeber = new Auftraggeber();
					break;
				case "PROJEKTLIST":
					projekte = new ArrayList<>();
					break;
				case "PROJEKT":
					projekt = new Projekt();
					break;
				case "ARBEITSZEITLIST":
					arbeitszeiten = new ArrayList<>();
					break;
				case "ARBEITSZEIT":
					arbeitszeit = new Arbeitszeit();
					break;
				case "MELDUNG":
					meldung = new Meldung();
					break;
				
				}
			}
			
			public	void endElement (String uri , String localName , String qName ) throws SAXException {
				switch(qName.toUpperCase()) {
				case "MITARBEITERID":
					mitarbeiter.setId(Integer.parseInt(text));
					break;
				case "MITARBEITERNAME":
					mitarbeiter.setName(text);
					break;
				case "MITARBEITERADRESSE":
					mitarbeiter.setAdresse(text);
					break;
				case "MITARBEITERGEBURTSDAT":
					mitarbeiter.setGeburtsdat(LocalDate.parse(text));
					break;
				case "MITARBEITERSVNUMMER":
					mitarbeiter.setSvNummer(text);
					break;
				case "MITARBEITERTELEFON":
					mitarbeiter.setTelefon(text);
					break;
				case "MITARBEITEREMAIL":
					mitarbeiter.setEmail(text);;
					break;
				case "MITARBEITERWOCHENARBEITSZEIT":
					mitarbeiter.setWochenarbeitszeit(Double.parseDouble(text));
					break;
				case "MITARBEITERSTUNDENSATZ":
					mitarbeiter.setStundensatz(Double.parseDouble(text));
					break;
				case "MITARBEITER":
					if(mitarbeiterElemente != null) {
						mitarbeiterElemente.add(mitarbeiter);
					}
					if(arbeitszeit != null) {
						arbeitszeit.setMitarbeiter(mitarbeiter);
					}
					break;
				case "AUFTRAGGEBERID":
					auftraggeber.setId(Integer.parseInt(text));
					break;
				case "AUFTRAGGEBERNAME":
					auftraggeber.setName(text);
					break;
				case "AUFTRAGGEBERADRESSE":
					auftraggeber.setAdresse(text);
					break;
				case "AUFTRAGGEBERTELEFON":
					auftraggeber.setTelefon(text);
					break;
				case "AUFTRAGGEBEREMAIL":
					auftraggeber.setEmail(text);;
					break;
				case "AUFTRAGGEBER":
					if(auftraggeberElemente != null) {
						auftraggeberElemente.add(auftraggeber);
					}
					if(projekt != null) {
						projekt.setAuftraggeber(auftraggeber);
					}
					break;
				case "PROJEKTID":
					projekt.setId(Integer.parseInt(text));
					break;
				case "PROJEKTNAME":
					projekt.setName(text);
					break;
				case "PROJEKTADRESSE":
					projekt.setAdresse(text);
					break;
				case "PROJEKTTELEFON":
					projekt.setTelefon(text);
					break;
				case "PROJEKTKONTAKTPERSON":
					projekt.setKontaktperson(text);
					break;
				case "ABGESCHLOSSEN":
					projekt.isAbgeschlossen();
					break;
				case "PROJEKT":
					if(projekte != null) {
						projekte.add(projekt);
					}
					if(arbeitszeit != null) {
						arbeitszeit.setProjekt(projekt);
					}
					break;
				case "ZEILENNUMMER":
					arbeitszeit.setZeilennummer(Integer.parseInt(text));
					break;
				case "ARBEITSZEITDATUM":
					arbeitszeit.setDatum(LocalDate.parse(text));
					break;
				case "ARBEITSZEITVON":
					arbeitszeit.setVon(text);
					break;
				case "ARBEITSZEITBIS":
					arbeitszeit.setBis(text);
					break;
				case "STUNDENGESAMT":
					arbeitszeit.setStundengesamt(Double.parseDouble(text));
					break;
				case "ARBEITSZEITSTUNDENSATZ":
					arbeitszeit.setStundensatz(Double.parseDouble(text));
					break;
				case "FAKTURIERT":
					arbeitszeit.isFakturiert();
					break;
				case "ARBEITSZEIT":
					if(arbeitszeiten != null) {
						arbeitszeiten.add(arbeitszeit);
					}
					break;
				case "TEXT":
					meldung.setText(text);
					break;
				}
			}
			
			public void characters(char	ch [], int start, int length) throws SAXException {
				text = new String(ch, start, length);
			}
	
	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}

	public ArrayList<Mitarbeiter> getMitarbeiterElemente() {
		return mitarbeiterElemente;
	}

	public Auftraggeber getAuftraggeber() {
		return auftraggeber;
	}

	public ArrayList<Auftraggeber> getAuftraggeberElemente() {
		return auftraggeberElemente;
	}
	
		public Projekt getProjekt() {
		return projekt;
	}

	public ArrayList<Projekt> getProjekte() {
		return projekte;
	}
	
	public Arbeitszeit getArbeitszeit() {
		return arbeitszeit;
	}

	public ArrayList<Arbeitszeit> getArbeitszeiten() {
		return arbeitszeiten;
	}

	public Meldung getMeldung() {
		return meldung;
	}
	
	
	


}
