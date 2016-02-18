import java.util.ArrayList;

public abstract class Kort {
	private String fornavn;
	private String etternavn;
	private int pin;
	private int kortnummer;
	private boolean sperretKort;
	private static ArrayList<Integer> alleKortnummer = new ArrayList<>();
	
	Kort(String fornavn, String etternavn, int pin) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.pin = pin;
		sperretKort = false;
		setKortnummer();
	}
	
	private void setKortnummer() {
		int kortnummer = (int)(Math.random() * (10000 - 1000) + 1000);
			while(alleKortnummer.contains(kortnummer)) {
				kortnummer = (int)(Math.random() * (10000 - 1000) + 1000);
		}
		alleKortnummer.add(kortnummer);
		this.kortnummer = kortnummer;
	}
	
	String getNavn() {
		return fornavn + " " + etternavn;
	}
	
	boolean isSperret() {
		return sperretKort;
	}
	
	@Override
	public String toString() {
		String header = String.format("%-20s %-20s %-20s %-20s %-20s\n", "Fornavn", "Etternavn", "Kortnummer", "PIN", "Status");
		String information = String.format("%-20s %-20s %-20d %-20d %-20s\n", fornavn, etternavn, kortnummer, pin, ((sperretKort) ? "Sperret": "Aktiv"));
		return header + information;
	}
	
	public abstract boolean sjekkPIN(int pin);
}
