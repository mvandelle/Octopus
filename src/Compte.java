import java.util.ArrayList;

public class Compte implements Comparable{
	
	private String intitule;
	private String type;
	private int nCompte;
	private String banque;
	private String ADE;
	private int AUM;
	private String origineRelation;
	private String toDO;
	private String note;
	private String state;
	private ArrayList<AdmDoc> doc;
	
	
	public Compte(String intitule, String type, int nCCompte, String banque, String aDE, int aUM,
			String origineRelation, String toDO, String note, String state) 
	{
		this.intitule = intitule;
		this.type = type;
		this.nCompte = nCCompte;
		this.banque = banque;
		ADE = aDE;
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
	public int getnCompte() {
		return nCompte;
	}
	public void setnCompte(int nCCompte) {
		this.nCompte = nCCompte;
	}
	public String getBanque() {
		return banque;
	}
	public void setBanque(String banque) {
		this.banque = banque;
	}
	public String getADE() {
		return ADE;
	}
	public void setADE(String aDE) {
		ADE = aDE;
	}
	public int getAUM() {
		return AUM;
	}
	public void setAUM(int aUM) {
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
	
	

}
