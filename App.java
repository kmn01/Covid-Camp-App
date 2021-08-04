import java.util.*;

public class App {

	private Camp hcamp;
	private HealthCoordinator coordinator;
	
	public App() {
		hcamp = new Camp();
		coordinator = new HealthCoordinator();
	}
	public void runApp() {
		Scanner sc = new Scanner(System.in);
		int numberofpatients = sc.nextInt();
		coordinator.inputPatients(numberofpatients);
		int ch;
		while(hcamp.getPleft()!=0) {
			ch = sc.nextInt();
			switch(ch) {
				case 1:{
					System.out.println("Institute Name: ");
					String inst = sc.next();
					System.out.println("Temperature Criteria: ");
					float t = sc.nextFloat();
					System.out.println("Oxygen Criteria: ");
					int oxy = sc.nextInt();
					System.out.println("Number of available beds: ");
					int b = sc.nextInt();
					coordinator.addInstitute(inst, new Institute(inst, t, oxy, b));
					break;
				}
				case 2:{
					coordinator.deletePatient();
					break;
				}	
				case 3:{
					hcamp.deleteInstitute();
					break;
				}	
				case 4:{
					hcamp.notAdmitted();
					break;
				}
				case 5:{
					hcamp.numberOpen();
					break;
				}
				case 6:{
					String inst = sc.next();
					hcamp.findHospital(inst, 6);
					break;
				}
				case 7:{
					int idno = sc.nextInt();
					coordinator.findPatient(idno);
					break;
				}
				case 8:{
					hcamp.displayAllPatients();
					break;
				}
				case 9:{
					String inst = sc.next();
					hcamp.findHospital(inst, 9);
					break;
				}
				default:{
					System.out.println("Invalid query");
				}
			}
		}
	}
	public static void main(String[] args) {
		
		App newapp = new App();
		newapp.runApp();

	}
}
