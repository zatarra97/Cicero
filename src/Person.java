import java.util.Scanner;

public class Person {
	
	
	private String  name;
	private String  surname;
	private String  phone;
	private String  email;
	
	public Person () {
		name = "No Name";
		surname = "No Surname";
		phone = "No phone number";
		email = "No email";
	}
	
	public void printProfile() {
		System.out.println("\nEcco i tuoi dati da");
		System.out.println("Nome e Cognome: " + name + " " + surname);
		System.out.println("Email: " + email);
		System.out.println("Numero di telefono: " + phone);
		
	}
	
	public void newProfile() {		//Registrazione
		Scanner scan = new Scanner (System.in);
		System.out.println("Benvenuto! Inserisci i tuoi dati\n");
		System.out.println("Nome: ");
		name = scan.nextLine();
		System.out.println("Cognome: ");
		surname = scan.nextLine();
		System.out.println("Email: ");
		email = scan.next();	//Non possono esserci spazi (Si può fare un controllo con la grammatica regolare)
		
		System.out.println("Numero di telefono: " );
		phone = scan.next();
		
		scan.close();
	}
	
	
}
