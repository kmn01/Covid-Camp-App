import java.util.*;

public class Camp {
	
	private static int pleft;
	private static ArrayList<Patient> plist;
	private static HashMap<String, Institute> ilist;
	
	public Camp()	{
		plist = new ArrayList<Patient>();
		setPleft(this.plist.size());
		ilist = new HashMap<String, Institute>();
	}
	public int getPleft() {
		return pleft;
	}
	public void setPleft(int pleft) {
		this.pleft = pleft;
	}
	public ArrayList<Patient> getPlist() {
		return plist;
	}
	public HashMap<String, Institute> getIlist() {
		return ilist;
	}
	public void notAdmitted() {
		System.out.println(pleft+" patients");
	}
	public void displayAllPatients() {
		for (Patient x : this.getPlist()) {
			System.out.println(x.getPid()+" "+x.getPname());
		}
	}
	public void setStatus(String name) {
		Institute temp = this.getIlist().get(name);
		if(temp.getNoofbeds()==0) {
			this.getIlist().get(name).setStatus("CLOSED");
		}
	}
	public void findHospital(String inst, int query) {
		Institute temp = ilist.get(inst);
		if(query == 6) {
			temp.displayIdetails();
		}
		else if(query == 9){
			temp.displayPatients();
		}
	}
	public void numberOpen() {
		int ctr = 0;
		for (Map.Entry<String, Institute> x : this.getIlist().entrySet()) {
			if(x.getValue().getStatus().equals("OPEN"))	{
				ctr++;
			}
		}
		System.out.println(ctr+" institutes are currently admitting patients");
	}
	public void deleteInstitute()
	{	
		System.out.println("Removed accounts of institutes whose admission is closed");
		Iterator<Map.Entry<String, Institute>> itr = this.ilist.entrySet().iterator(); 
        
        while(itr.hasNext()) { 
             Map.Entry<String, Institute> entry = itr.next(); 
             if(entry.getValue().getStatus().equals("CLOSED")) {
 				System.out.println("Removed: "+entry.getValue().getIname());
 				itr.remove();
 			}
        } 
	}
}
