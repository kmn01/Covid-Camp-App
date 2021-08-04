import java.util.*;

public class Patient {

	private String pname;
	private int page;
	private int poxylevel;
	private float pbodytemp;
	private int pid;
	private int precdays;
	private String admit;
	private String venue;
	
	public Patient(String pname, float pbodytemp, int poxylevel, int page, int pid)
	{
		this.pname = pname;
		this.page = page;
		this.poxylevel = poxylevel;
		this.pbodytemp = pbodytemp;
		this.pid = pid;
		this.setPrecdays(0);
		this.setAdmit("Not admitted");
		this.setVenue("N/A");
	}
	public int getPid() {
		return pid;
	}
	public void setAdmit(String admit) {
		this.admit = admit;
	}
	public int getPrecdays() {
		return precdays;
	}
	public void setPrecdays(int precdays) {
		this.precdays = precdays;
	}
	public String getAdmit() {
		return admit;
	}
	public String getPname() {
		return pname;
	}
	public float getPbodytemp() {
		return pbodytemp;
	}
	public int getPoxylevel() {
		return poxylevel;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
}
