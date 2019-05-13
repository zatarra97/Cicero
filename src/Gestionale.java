import java.util.Scanner;


public class Gestionale {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int choice;							//Per le varie scelte nei menu
		String email = null, password = null;		//Per il login
		
		Cicerone user = new Cicerone();
		
		
	do{
		System.out.println("1.Accedi\n2.Registrati\n0.Esci\n");
		System.out.print("Scelgo: ");
		choice = scan.nextInt();
		
		if (choice == 1){
			System.out.println("\nInserisci le tue credenziali");
			System.out.print("Email: ");
			email = scan.next();
			System.out.print("Password: ");
			password = scan.next();
			user.logIn(email, password);
		}else if (choice == 2){
			user.signUp();
		}else if (choice == 0){
			System.out.print("Grazie per aver utilizzato questo programma.");
			System.exit(0);
		}else{
			System.out.println("\nScelta errata!\n");		
		}
	}while(choice != 1 && choice != 2);	
	
	
	do{
		System.out.println("In quale menu vuoi entrare?");
		System.out.println("1.Cicerone\n2.Globetrotter\n0.Log Out\n");
		System.out.print("Scelgo: ");
		choice = scan.nextInt();
		
		//Entra nella funzionalità Cicerone
		if (choice == 1){
			int choiceCicero;
			System.out.println("\nMenu del cicerone!\nPer ora puoi:");
			System.out.println("1.Inserire una nuova attività");
			System.out.println("2.Visualizzare le tue attività inserite");
			System.out.print("Scelgo: ");
			choiceCicero = scan.nextInt();
			
			if (choiceCicero == 1){			//Inserisce nuova attività
				user.newActivity();	
			}else if(choiceCicero == 2){	//Visualizza attività registrate
				email = user.getEmail();
				user.myActivity(email);
			}else{
				System.out.println("Scelta errata");
			}
			
		//Entra nella funzionalità Globetrotter
		}else if (choice == 2){
			int choiceGlobe;
			System.out.println("\nMenu del Globetrotter!\nCosa desideri fare?\n");
			System.out.print("1.Cercare un Cicerone per un viaggio\n"
					+ "2.Le tue prenotazioni\n\n Scelgo: ");
			choiceGlobe = scan.nextInt();
			
			if (choiceGlobe == 1){
				user.searchForTrip();
			}else if (choiceGlobe == 2){
				System.out.println("Ancora in fase di sviluppo");
			}else{
				System.out.println("Scelta errata");
			}
			
		}else if (choice == 0){
			System.out.print("A presto " + user.getName());
		}else{
			System.out.println("\nScelta errata!\n");		
		}
	
		
	}while(choice != 0);	
		
		
		
		scan.close();
	}
}
