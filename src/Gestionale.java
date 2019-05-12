import java.util.Scanner;


public class Gestionale {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int choice;					//Per le varie scelte nei menu
		String email, password;		//Per il login
		
		
		Cicerone user = new Cicerone();
		
		
		
		System.out.println("1.Accedi\n2.Registrati\n");
		System.out.print("Scelgo: ");
		choice = scan.nextInt();
		
		if (choice == 1){
			System.out.println("\nInserisci le tue credenziali");
			System.out.print("Email: ");
			email = scan.next();
			System.out.print("Password: ");
			password = scan.next();
			user.logIn(email, password);
		}else{
			user.signUp();
			}
		
		
		
		
		
		
		//Inserisce nuova attività
		user.newActivity();
		scan.close();
	}
}
