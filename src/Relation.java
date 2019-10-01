
public class Relation implements Comparable {
	private String gestionnaire;
	private String intitule;
	private String nCompte;
	private String banque;
	private String nom;
	private String prenom;
	private String date;
	private String adresse;
	private String legitimation;
	private String siege;
	private String regact;
	private String nationalite;
	private String residence;
	private String det;
	private String eu;
	private boolean risque;
	private String entre;
	private String dernier;
	private String profil;
	private String comGest;
	private String comPerf;
	private String monnaie;
	private String soldeDeb;
	private String soldeFin;
	
	private boolean isAlive;

	public Relation(String gestionnaire, String intitule, String nCompte, String banque, String nom, String prenom,
			String date,String adresse, String legislation,String siege,String regact, String nationalite, String residence,String det, String eu, boolean risque, String entre,
			String dernier, String profil, String comGest, String comPerf, String monnaie, String soldeDeb, String soldeFin, boolean isAlive) {
		this.gestionnaire = gestionnaire;
		this.intitule = intitule;
		this.nCompte = nCompte;
		this.banque = banque;
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.adresse = adresse;
		this.legitimation = legislation;
		this.siege = siege;
		this.regact = regact;
		this.nationalite = nationalite;
		this.residence = residence;
		this.det = det;
		this.eu = eu;
		this.risque = risque;
		this.entre = entre;
		this.dernier = dernier;
		this.profil = profil;
		this.comGest = comGest;
		this.comPerf = comPerf;
		this.monnaie = monnaie;
		this.soldeDeb = soldeDeb;
		this.soldeFin = soldeFin;
		this.isAlive = isAlive;
	}
	
	

	public Relation() {
		
	}
	
	public Relation(Compte c)
	{
		this.intitule = c.getIntitule();
		
	}
	
	public boolean getAlive()
	{
		return isAlive;
	}
	
	public void setAlive(boolean a)
	{
		isAlive = a;
	}
	
	public String getAdresse()
	{
		return adresse;
	}
	
	public void setAdresse(String adresse)
	{
		this.adresse = adresse;
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

	public String getnCompte() {
		return nCompte;
	}

	public void setnCompte(String nCompte) {
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

	public String getEntre() {
		return entre;
	}

	public void setEntre(String entre) {
		this.entre = entre;
	}

	public String getDernier() {
		return dernier;
	}

	public void setDernier(String dernier) {
		this.dernier = dernier;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getComGest() {
		return comGest;
	}

	public void setComGest(String comGest) {
		this.comGest = comGest;
	}

	public String getComPerf() {
		return comPerf;
	}

	public void setComPerf(String comPerf) {
		this.comPerf = comPerf;
	}

	public String getMonnaie() {
		return monnaie;
	}

	public void setMonnaie(String monnaie) {
		this.monnaie = monnaie;
	}

	public String getSoldeDeb() {
		return soldeDeb;
	}

	public void setSoldeDeb(String soldeDeb) {
		this.soldeDeb = soldeDeb;
	}

	public String getSoldeFin() {
		return soldeFin;
	}

	public void setSoldeFin(String soldeFin) {
		this.soldeFin = soldeFin;
	}

	public String toString() {
		return nCompte+ " " + intitule;
	}
	
	public String getSiege()
	{
		return siege;
	}
	
	public void setSiege(String s)
	{
		siege = s;
	}
	
	public String getReg()
	{
		return regact;
	}
	
	public void setReg(String s)
	{
		regact = s;
	}
	
	public String getDet()
	{
		return det;
	}
	
	public void setDet(String d)
	{
		det = d;
	}
	
	public String getEu()
	{
		return eu;
	}
	
	public void setEu(String e)
	{
		eu = e;
	}
	
	

	@Override
	public int compareTo(Object o) {
		return this.banque.compareTo(((Relation) o).getBanque());
	}

}
