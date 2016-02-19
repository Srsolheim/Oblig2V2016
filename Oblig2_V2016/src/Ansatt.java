import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ansatt extends Kort implements Konstanter {

	StringBuilder fulltNavn = new StringBuilder(super.getFulltNavn());
	int i = fulltNavn.indexOf(" ");
	String forNavn = fulltNavn.substring(0, i);
	String etterNavn = fulltNavn.substring(i);
	double timeLønn;
	int ansiennitet;
	
	public Ansatt(String fulltNavn, int pin, double timeLønn, int ansiennitet) {
		super(fulltNavn, pin);
		this.timeLønn = timeLønn;
		this.ansiennitet = ansiennitet;
	}
	
	public Kort Cloneable() {
		Kort kortClone = new Ansatt(this.getFulltNavn(), this.getPin(), timeLønn, ansiennitet);
		System.out.println(this.getKortnummer());
		(kortClone).setKortNummer(this.getKortnummer());
		return kortClone;
	}
	
	public String toString() {
		return super.toString() + "\nTimelønn: " + this.getTimeLønn() + ",-"+ "\nAnsiennitet: " + this.getAnsiennitet() + " år";
	}
	
	public double getTimeLønn() {
		return timeLønn;
	}

	public void setTimeLønn(double timeLønn) {
		this.timeLønn = timeLønn;
	}

	public int getAnsiennitet() {
		return ansiennitet;
	}

	public void setAnsiennitet(int ansiennitet) {
		this.ansiennitet = ansiennitet;
	}

	public double beregnKreditt() {
		double beregnKredittAvTimelønn = 0.15;
		return this.getTimeLønn() * beregnKredittAvTimelønn;
	}
	
	public double beregnBonus() {
		double konstantSomBeregnerBonusBasertPåAnsiennitet = 0.25;
		return this.getAnsiennitet() * konstantSomBeregnerBonusBasertPåAnsiennitet;
	}
	@Override
	public void setFulltNavn(String fornavn, String etternavn) {
		fulltNavn.delete(0, fulltNavn.length());
		fulltNavn.append(forNavn + " " + etterNavn);
	}
	public String getFulltNavn() {
		return fulltNavn.toString();
	}
	@Override
	public void setEtternavn(String etternavn) {
		fulltNavn.replace(i + 1, fulltNavn.length(), etterNavn);
	}
	@Override
	public String getEtternavn() {
		i = fulltNavn.indexOf(" ");
		return fulltNavn.substring(i + 1);
	}
	@Override
	public void setFornavn(String fornavn) {
		fulltNavn.replace(0, i, forNavn);
	}
	@Override
	public String getFornavn() {
		i = fulltNavn.indexOf(" ");
		return fulltNavn.substring(0, i);
	}
	@Override
	public boolean sjekkPIN(int pin) {
		
		if (super.getPin() == pin) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean WorkingHours() {
		
		GregorianCalendar timeNow = new GregorianCalendar();
		System.out.println(timeNow.get(GregorianCalendar.HOUR_OF_DAY));
		if ((timeNow.get(GregorianCalendar.DATE) == 6) || (timeNow.get(GregorianCalendar.DATE) == 7)) {
			return false;
		}
		else if ((timeNow.get(GregorianCalendar.HOUR_OF_DAY) < 7) || (timeNow.get(GregorianCalendar.HOUR_OF_DAY) > 17)) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public boolean brukerTilgang(){
		if (super.isSperret() == true) {
			return false;
		}
		else if (WorkingHours() == true) {
			return true;
		}

		Scanner input = new Scanner(System.in);
		System.out.print("Tast inn PIN-kode: ");
		int enteredPinCode = input.nextInt();
		if (this.sjekkPIN(enteredPinCode) == true) {
			return true;
		}
		else {
			return false;
		}
	}
}