import java.util.GregorianCalendar;
import java.util.Scanner;

public class Gjest extends Kort {

	public Gjest(String fulltNavn, int pin) {
		super(fulltNavn, pin);
	}
	
	@Override
	public boolean sjekkPIN(int pin) {

		if (pin != 9999) {
			return false;
		}
		else {
			return true;
		}
	}
		
	public Kort Cloneable() {
		Kort kortClone = new Gjest(this.getFulltNavn(), this.getPin());
		System.out.println(this.getKortnummer());
		kortClone.setKortNummer(this.getKortnummer());
		return kortClone;
	}
	
	public boolean isGuestCardExpired() {
		
		GregorianCalendar expirationDateForCard = new GregorianCalendar();
		expirationDateForCard.setTime(getDateCreated());
		expirationDateForCard.add(GregorianCalendar.HOUR, 168);
		if (super.currentTime().before(expirationDateForCard.getTime())) {
			return false;	
		}
		else {
			return true;
		}
	}
	@Override
	public boolean brukerTilgang() {
		if (super.isSperret() == true) {
			return false;
		}
		else if (isGuestCardExpired() == true) {
			return false;
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