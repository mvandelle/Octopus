
public class AdmDoc {
	private String name;
	private boolean haveIt;
	
	public AdmDoc(String name, boolean haveIt)
	{
		this.name = name;
		this.haveIt = haveIt;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHaveIt() {
		return haveIt;
	}
	public void setHaveIt(boolean haveIt) {
		this.haveIt = haveIt;
	}
	
	
}
