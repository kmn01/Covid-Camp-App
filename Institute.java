import java.util.*;

public class Institute {

	private String iname;
	private String status;
	private int noofbeds;
	private int ioxylevel;
	private float ibodytemp;
	private ArrayList<Patient> patients;
	
	public Institute(String iname, float ibodytemp, int ioxylevel, int noofbeds)
	{
		this.iname = iname;
		this.setStatus("OPEN");
		this.noofbeds = noofbeds;
		this.ibodytemp = ibodytemp;
		this.ioxylevel = ioxylevel;
		this.patients = new ArrayList<Patient>();
	}
	public String getIname() {
		return iname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getIbodytemp() {
		return ibodytemp;
	}
	public int getIoxylevel() {
		return ioxylevel;
	}
	public int getNoofbeds() {
		return noofbeds;
	}
	public void setNoofbeds(int noofbeds) {
		this.noofbeds = noofbeds;
	}
	public ArrayList<Patient> getP() {
		return patients;
	}
	public void setP(Patient e) {
		this.patients.add(e);
	}
	public void displayPatients() {
		for (Patient x : this.patients) {
			System.out.println(x.getPname()+" Recovery time: "+x.getPrecdays()+" days");
		}
	}
	public void displayIdetails() {
		System.out.println(this.iname);
		System.out.println("Temperature should be <= "+ this.ibodytemp);
		System.out.println("Oxygen level should be >= "+ this.ioxylevel);
		System.out.println("Number of available beds: "+ this.noofbeds);
		System.out.println("Admitting status: "+ this.status);
	}
}
