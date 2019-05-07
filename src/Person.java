import java.util.Scanner;

public class Person {
	
	
	private String  name;
	private String  surname;
	private String  phone;
	private String  email;
	private boolean sharePhone;
	private String 	role;
	
	public Person () {
		name = "No Name";
		surname = "No Surname";
		phone = "No phone number";
		email = "No email";
		sharePhone = false;
	}
	
	public void printProfile() {
		System.out.println("\nEcco i tuoi dati da " + role);
		System.out.println("Nome e Cognome: " + name + " " + surname);
		System.out.println("Email: " + email);
		
		if (sharePhone == true) {		//Se l'utente ha deciso di voler condividere il numero di telefono:
			System.out.println("Numero di telefono: " + phone);
		}
	}
	
	public void newProfile() {		//Registrazione
		Scanner scan = new Scanner (System.in);
		System.out.println("Sei un Cicerone o un Globetrotter? ");
		System.out.println("\t1.Cicerone \n\t2.Globetrotter\n");
		System.out.print("Sono un: ");
		int choice = scan.nextInt();
		
		String antiRole;	//Contiene l'elemento contrario del ruolo scelto
		if (choice == 1) {
			role = "Cicerone";
			antiRole = "Globetrotter";
		}else {
			role = "Globetrotter";
			antiRole = "Cicerone";
		}
		
		System.out.println("Benvenuto nuovo " + role + "! Inserisci i tuoi dati\n");
		System.out.println("Nome: ");
		name = scan.nextLine();
		System.out.println("Cognome: ");
		surname = scan.nextLine();
		System.out.println("Email: ");
		email = scan.next();	//Non possono esserci spazi (Si può fare un controllo con la grammatica regolare)
		System.out.println("Vuoi inserire il tuo numero di telefono?\nIl tuo numero di telefono non sarà pubblico"
				+ "ma sarà inviato al tuo " + antiRole + " qual'ora venga accettata la richiesta di viaggio. ");
		System.out.println("\t1.Si \n\t2.No\n");
		choice = scan.nextInt();
		
		if (choice == 1) {		//Se l'utente ha deciso di voler condividere il numero di telefono:
			sharePhone = true;
			System.out.println("Numero di telefono: " );
			phone = scan.next();
		}else {
			sharePhone = false;
		}
		scan.close();
	}
	
	
}
