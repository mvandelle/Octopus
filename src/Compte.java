import java.util.ArrayList;

public class Compte implements Comparable{
	
	private String intitule;
	private String type;
	private String nCompte;
	private String banque;
	private String ADENom;
	private String ADEPrenom;
	private String AUM;
	private String origineRelation;
	private String toDO;
	private String note;
	private String state;
	private ArrayList<AdmDoc> doc;
	
	
	public Compte(String intitule, String type, String nCCompte, String banque, String ADENom, String ADEPrenom, String aUM,
			String origineRelation, String toDO, String note, String state) 
	{
		this.intitule = intitule;
		this.type = type;
		this.nCompte = nCCompte;
		this.banque = banque;
		this.ADENom = ADENom;
		this.ADEPrenom = ADEPrenom;
		AUM = aUM;
		this.origineRelation = origineRelation;
		this.toDO = toDO;
		this.note = note;
		this.state = state;
		this.doc = new ArrayList<>();
	}
	
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getnCompte() {
		return nCompte;
	}
	public void setnCompte(String nCCompte) {
		this.nCompte = nCCompte;
	}
	public String getBanque() {
		return banque;
	}
	public void setBanque(String banque) {
		this.banque = banque;
	}
	public String getADENom()
	{
		return ADENom;
	}
	public void setADENom(String ade) {
		this.ADENom = ade;
	}
	public String getADEPrenom() {
		return ADEPrenom;
	}
	public void setADEPrenom(String aDE) {
		ADEPrenom = aDE;
	}
	public String getAUM() {
		return AUM;
	}
	public void setAUM(String aUM) {
		AUM = aUM;
	}
	public String getOrigineRelation() {
		return origineRelation;
	}
	public void setOrigineRelation(String origineRelation) {
		this.origineRelation = origineRelation;
	}
	public String getToDO() {
		return toDO;
	}
	public void setToDO(String toDO) {
		this.toDO = toDO;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public ArrayList<AdmDoc> getDoc()
	{
		return doc;
	}
	
	public void HasDoc(String name)
	{
		for ( int i = 0; i < doc.size(); ++i)
		{
			if ( doc.get(i).getName().equals(name))
			{
				doc.get(i).setHaveIt(true);
			}
		}
	}
	
	@Override
	public int compareTo(Object o) {
		return this.banque.compareTo(((Compte) o).getBanque());
		}
	
	public void addDoc(String name)
	{
		doc.add(new AdmDoc(name,false));
	}
	
	public void addDoc(ArrayList<AdmDoc> d)
	{
		for ( int i = 0; i < d.size(); ++i)
		{
			this.addDoc(d.get(i).getName());
		}
	}
	
	public String toString()
	{
		return nCompte + " " + intitule;
	}
	
	public void removeDoc(AdmDoc d)
	{
		for ( int i = 0; i < doc.size(); ++i)
		{
			if (doc.get(i).getName().equals(d.getName()))
			{
				doc.remove(i);
				i= i-1;
			}
		}
		
	}
	
	

}
