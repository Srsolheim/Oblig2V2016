import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Kort {
	private String fulltNavn;
	private int pin;
	private static int kortID = 1000;
	private int kortnummer;
	private boolean sperretKort;
	private final GregorianCalendar dateCreated = new GregorianCalendar();
	
	Kort(String fulltNavn, int pin) {
		this.fulltNavn = fulltNavn;
		this.pin = pin;
		kortnummer = kortID;
		sperretKort = false;
	}
	
	public int compareTo(Kort k) {
		int i = this.getFulltNavn().indexOf(" "), j = k.getFulltNavn().indexOf(" ");
		if((this.getFulltNavn().substring(i, this.getFulltNavn().length())).compareToIgnoreCase(k.getFulltNavn().substring(j, k.getFulltNavn().length())) > 0) {
			return 1;
		}
		else if ((this.getFulltNavn().substring(i, this.getFulltNavn().length())).compareToIgnoreCase(k.getFulltNavn().substring(j, k.getFulltNavn().length())) < 0) {
			return -1;
			}
		else {
			if (this.getFulltNavn().substring(0, i).compareToIgnoreCase(k.getFulltNavn().substring(0, j)) > 0) {
				return 1;
			}
			else if (this.getFulltNavn().substring(0, i).compareToIgnoreCase(k.getFulltNavn().substring(0, j)) < 0) {
				return -1;
			}
			else {
				return 0;
			}	
		}
	}
	
	String getFulltNavn() {
		return fulltNavn;
	}
	
	public int getKortnummer(){
		return kortnummer;
	}
	public void setKortNummer(int kortNummer) {
		this.kortnummer = kortNummer;
	}
	
	public int getPin() {
		return pin;
	}
	
	boolean isSperret() {
		return sperretKort;
	}
	
	public Date getDateCreated() {
		return dateCreated.getTime();
	}
	
	@Override
	public String toString() {
		return "\nNavn: " + fulltNavn + "\nPIN-kode: " + pin + "\nKortnummer: " + kortnummer 
				+ "\nKortet sperret? " + sperretKort;
	}
	
	public abstract boolean sjekkPIN(int pin);
	public abstract boolean brukerTilgang();
	
	public Date currentTime() {
		GregorianCalendar timeRightNow = new GregorianCalendar();
		return timeRightNow.getTime();
	}
}
