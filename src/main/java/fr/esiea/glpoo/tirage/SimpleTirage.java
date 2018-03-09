package fr.esiea.glpoo.tirage;

public class SimpleTirage implements Tirage {
	private int annee;
	private String jour;
	private String[] date;
	private int numeroTirage;
	private String[] dateFermeture;
	private int boule1;
	private int boule2;
	private int boule3;
	private int boule4;
	private int boule5;
	private int etoile1;
	private int etoile2;

	public SimpleTirage() {
		super();
	}

	public SimpleTirage(int annee, String jour, String[] date, int numeroTirage, String[] dateFermeture, int boule1,
			int boule2, int boule3, int boule4, int boule5, int etoile1, int etoile2) {
		this();
		this.annee = annee;
		this.jour = jour;
		this.date = date;
		this.numeroTirage = numeroTirage;
		this.dateFermeture = dateFermeture;
		this.boule1 = boule1;
		this.boule2 = boule2;
		this.boule3 = boule3;
		this.boule4 = boule4;
		this.boule5 = boule5;
		this.etoile1 = etoile1;
		this.etoile2 = etoile2;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String[] getDate() {
		return date;
	}

	public void setDate(String[] date) {
		this.date = date;
	}

	public int getNumeroTirage() {
		return numeroTirage;
	}

	public void setNumeroTirage(int numeroTirage) {
		this.numeroTirage = numeroTirage;
	}

	public String[] getDateFermeture() {
		return dateFermeture;
	}

	public void setDateFermeture(String[] dateFermeture) {
		this.dateFermeture = dateFermeture;
	}

	public int getBoule1() {
		return boule1;
	}

	public void setBoule1(int boule1) {
		this.boule1 = boule1;
	}

	public int getBoule2() {
		return boule2;
	}

	public void setBoule2(int boule2) {
		this.boule2 = boule2;
	}

	public int getBoule3() {
		return boule3;
	}

	public void setBoule3(int boule3) {
		this.boule3 = boule3;
	}

	public int getBoule4() {
		return boule4;
	}

	public void setBoule4(int boule4) {
		this.boule4 = boule4;
	}

	public int getBoule5() {
		return boule5;
	}

	public void setBoule5(int boule5) {
		this.boule5 = boule5;
	}

	public int getEtoile1() {
		return etoile1;
	}

	public void setEtoile1(int etoile1) {
		this.etoile1 = etoile1;
	}

	public int getEtoile2() {
		return etoile2;
	}

	public void setEtoile2(int etoile2) {
		this.etoile2 = etoile2;
	}
}
