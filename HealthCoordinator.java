import java.util.*;

public class HealthCoordinator {
	
	private static Camp hcamp;
	public HealthCoordinator() {
		hcamp = new Camp();
	}
	public void inputPatients(int n) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<n; i++) {
			String name = sc.next();
			float bodytemp = sc.nextFloat();
			int oxylevel = sc.nextInt();
			int age = sc.nextInt();
			hcamp.getPlist().add(new Patient(name, bodytemp, oxylevel, age, i+1));
		}
		hcamp.setPleft(n);
	}
	public void deletePatient()	{
		System.out.println("Removed accounts of admitted patients");
		Iterator<Patient> itr = hcamp.getPlist().iterator(); 
		while (itr.hasNext()) { 
			Patient next = itr.next();
			if(next.getAdmit().equals("Admitted")) { 
				System.out.println("Removed: "+ next.getPname());
				itr.remove(); 
			} 
		}
	}
	public void admitPatients(String name) {
		Institute temp = hcamp.getIlist().get(name);
		for (Patient x : hcamp.getPlist()) {
			if(x.getAdmit().equals("Not admitted") && hcamp.getIlist().get(name).getNoofbeds()>0)	{
				if(x.getPoxylevel()>=temp.getIoxylevel()) {
					x.setAdmit("Admitted");
					System.out.println(x.getPname());
					x.setVenue(temp.getIname());
					hcamp.setPleft(hcamp.getPleft() - 1);
					hcamp.getIlist().get(name).setP(x);
					hcamp.getIlist().get(name).setNoofbeds(hcamp.getIlist().get(name).getNoofbeds()-1);
				}
			}
		}
		for (Patient x : hcamp.getPlist()) {
			if(x.getAdmit().equals("Not admitted") && hcamp.getIlist().get(name).getNoofbeds()>0)	{
				if(x.getPbodytemp()<=temp.getIbodytemp()) {
					x.setAdmit("Admitted");
					System.out.println(x.getPname());
					x.setVenue(temp.getIname());
					hcamp.setPleft(hcamp.getPleft() - 1);
					hcamp.getIlist().get(name).setNoofbeds(hcamp.getIlist().get(name).getNoofbeds()-1);
				}
			}
		}
	}
	public void addInstitute(String name, Institute in)
	{
		Scanner sc = new Scanner(System.in);
		hcamp.getIlist().put(name, in);
		System.out.println(in.getIname());
		System.out.println("Temperature should be <= "+ in.getIbodytemp());
		System.out.println("Oxygen level should be >= "+ in.getIoxylevel());
		System.out.println("Number of available beds: "+ in.getNoofbeds());
		System.out.println("Admission status: "+ in.getStatus());
		
		this.admitPatients(name);
		hcamp.setStatus(name);
		if(hcamp.getIlist().get(name).getP().size()!=0)
		{	
			for (Patient x : hcamp.getIlist().get(name).getP()) 
			{
				System.out.println("Recovery days for admitted patient ID "+x.getPid()+": ");
				int days = sc.nextInt();
				x.setPrecdays(days);
			}
		}
	}
	
	public void findPatient(int idno)
	{
		for (Patient x : hcamp.getPlist()) 
		{
			if(x.getPid() == idno)
			{
				System.out.println(x.getPname());
				System.out.println("Body temperature: "+ x.getPbodytemp());
				System.out.println("Oxygen level: "+ x.getPoxylevel());
				System.out.println("Admission status: "+ x.getAdmit());
				System.out.println("Admitting institute: "+ x.getVenue());
			}
		}
	}
}
