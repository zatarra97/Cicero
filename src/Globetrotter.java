import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Globetrotter extends Person{
	
		private String destination;	//Destinazione
		private int howMany;		//Quante persone partecipano al viaggio
		private String category;	//Categoria di viaggio
		private String date;		//Data del viaggio
		
		
		public Globetrotter(){
			destination = "Nessuna destinazione";
			howMany = 0;
			category = "Nessuna categoria";
			date = "Nessuna data";
		}
		
		
		public void searchForTrip (){
			Scanner scan = new Scanner (System.in);
			int choice = 0; 	//Gestisce le scelte nel menu
	
		do{
			System.out.println("Vuoi ricercare la disponibilità per una data specifica o solo un luogo?");
			System.out.println("\n\t1. Data\n\t 2. Luogo\n\t 3. Categoria\n");
			System.out.print("Scelgo: ");
			choice = scan.nextInt();
			scan.nextLine();
			if (choice == 1){			//Ricerca per Data
				System.out.print("Inserisci quando vorresti partire: ");
				date = scan.nextLine();
				System.out.print("In quante persone? ");
				howMany = scan.nextInt();
				searhTripFile(date,howMany);
			}else if (choice == 2){		//Ricerca per Luogo
				System.out.print("Inserisci la tua destinazione: ");
				destination = scan.nextLine();
				destination = destination.toLowerCase();
				System.out.print("In quante persone? ");
				howMany = scan.nextInt();
				searhTripFile(destination,howMany);
			}else if (choice == 3){		//Ricerca per Categoria
				System.out.print("Inserisci la tua categoria di interesse: ");
				category = scan.next();
				category = category.toLowerCase();
				System.out.print("In quante persone? ");
				howMany = scan.nextInt();
				searhTripFile(category,howMany);
			}else{
				System.out.println("Scelta errata, riprovare");
			}
		}while(choice != 1 && choice != 2 && choice != 3);
		
		
	}
		
		
	//Mostra tutte le attività registrate dal cicerone loggato
	public void searhTripFile(String keyword, int howMany){
		Scanner scan3 = new Scanner(System.in);
		boolean find = false;
		String fileName = "attività.txt";
		Scanner inputStream = null;
		
		try {
			inputStream =  new Scanner (new File(fileName));	
		}catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file");
			System.exit(0);    //Termina il programma
		}
			//Legge i dati presenti nel file
		while(inputStream.hasNextLine()) {
			String riga = inputStream.nextLine();
			if (riga.contains(keyword)){
				if(find == false){
					System.out.println("\nEcco le attività che potrebbero interessarti:\n");
					System.out.println("| Prezzo | Disponibilità      | Luogo                     | Data       | Categoria         | Info");
				}
				//Bisogna eliminare l'email (per privacy) fino a quando il globe non prenota
				//Verranno mostrati perciò solo i dati tecnici
				int emailIndex; //Contiene l'indice della stringa dove è contenuta l'email
				int infoIndex;	//Contiene l'indice della stringa dove ci sono le info aggiuntive (Subito dopo l'email)
				emailIndex = riga.indexOf("EMAIL: ");
			    infoIndex = riga.indexOf("INFO:");
				riga = riga.substring(0, emailIndex -3) + " | " + riga.substring( infoIndex + 6, riga.length());
				System.out.println(riga);	
				find = true;
			}
		}
		if(find == false){
			System.out.println("Non ci sono attività che corrispondo a questi criteri di ricerca.");
		}
				
		inputStream.close();	
				
		//Piccola pausa per poter visualizzare le attività  consigliate prima di ritornare al menu
		System.out.print("\nPremi un tasto per continuare . . . \n");
		scan3.nextLine();
	}
}
