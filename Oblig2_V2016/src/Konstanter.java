public interface Konstanter {

	void setFornavn(String fornavn);
	String getFornavn();
	void setEtternavn(String etternavn);
	String getEtternavn();
	void setFulltNavn(String fornavn, String etternavn);
	String getFulltNavn();
	double beregnKreditt();
	double beregnBonus();
}