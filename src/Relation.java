
public class Relation implements Comparable {
	private String gestionnaire;
	private String intitule;
	private int nCompte;
	private String banque;
	private String nom;
	private String prenom;
	private String date;
	private String legitimation;
	private String nationalite;
	private String residence;
	private boolean risque;
	private int entre;
	private int dernier;
	private String profil;
	private double comGest;
	private int comPerf;
	private String monnaie;
	private int soldeDeb;
	private int soldeFin;

	public Relation(String gestionnaire, String intitule, int nCompte, String banque, String nom, String prenom,
			String date, String legislation, String nationalite, String residence, boolean risque, int entre,
			int dernier, String profil, double comGest, int comPerf, String monnaie, int soldeDeb, int soldeFin) {
		this.gestionnaire = gestionnaire;
		this.intitule = intitule;
		this.nCompte = nCompte;
		this.banque = banque;
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.legitimation = legislation;
		this.nationalite = nationalite;
		this.residence = residence;
		this.risque = risque;
		this.entre = entre;
		this.dernier = dernier;
		this.profil = profil;
		this.comGest = comGest;
		this.comPerf = comPerf;
		this.monnaie = monnaie;
		this.soldeDeb = soldeDeb;
		this.soldeFin = soldeFin;
	}

	

	public Relation() {
		
	}



	public String getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(String gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getnCompte() {
		return nCompte;
	}

	public void setnCompte(int nCompte) {
		this.nCompte = nCompte;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLegitimation() {
		return legitimation;
	}

	public void setLegitimation(String legislation) {
		this.legitimation = legislation;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public boolean isRisque() {
		return risque;
	}

	public void setRisque(boolean risque) {
		this.risque = risque;
	}

	public int getEntre() {
		return entre;
	}

	public void setEntre(int entre) {
		this.entre = entre;
	}

	public int getDernier() {
		return dernier;
	}

	public void setDernier(int dernier) {
		this.dernier = dernier;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public double getComGest() {
		return comGest;
	}

	public void setComGest(double comGest) {
		this.comGest = comGest;
	}

	public int getComPerf() {
		return comPerf;
	}

	public void setComPerf(int comPerf) {
		this.comPerf = comPerf;
	}

	public String getMonnaie() {
		return monnaie;
	}

	public void setMonnaie(String monnaie) {
		this.monnaie = monnaie;
	}

	public int getSoldeDeb() {
		return soldeDeb;
	}

	public void setSoldeDeb(int soldeDeb) {
		this.soldeDeb = soldeDeb;
	}

	public int getSoldeFin() {
		return soldeFin;
	}

	public void setSoldeFin(int soldeFin) {
		this.soldeFin = soldeFin;
	}

	public String toString() {
		return Integer.toString(nCompte)+ " " + intitule;
	}
	
	

	@Override
	public int compareTo(Object o) {
		return this.banque.compareTo(((Relation) o).getBanque());
	}

}
