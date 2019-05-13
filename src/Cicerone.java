import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Cicerone extends Globetrotter {
	private String category;		//Categoria di viaggio
	private String date;			//Data
	private String email;			//Email
	private String place;			//Luogo 
	private double parcel;			//Costo dell'attivit�
	private String info;			//Informazioni itinerario
	private int maxPerson;			//Massimo di persone
	int choice = 0;					//Contiene le scelte nel menu di conferma per salvare l'attivit�
	
	//Inserisce una nuova attivit�
	public void newActivity(){
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Inserisci i dati per la nuova attivit� da pubblicare\n");
		System.out.print("Inserisci il luogo: ");
		place = scan2.nextLine();
		place = place.toLowerCase();	//in modo tale da non creare incomprensioni quando il globe cerca il luogo
		System.out.print("Inserisci la data (formato gg/mm/aaaa): ");
		date = scan2.nextLine();
		System.out.print("Quante persone possono partecipare massimo: ");
		maxPerson = scan2.nextInt();
		scan2.nextLine();	//Prende in input il carattere 'invio'
		System.out.print("Inserisci la categoria del viaggio: ");
		category = scan2.nextLine();
		category = category.toLowerCase();	//in modo tale da non creare incomprensioni quando il globe cerca la categoria
		System.out.print("Inserisci qualche info sul percorso: ");
		info = scan2.nextLine();
		System.out.print("Inserisci il tuo compenso: ");
		parcel = scan2.nextDouble();
	do{	
		System.out.print("Sei sicuro di voler pubblicare questa tua attivit�? (1 = si / 2 = no): ");
		choice = scan2.nextInt();
		if (choice == 1){
			//Inserisce i dati nel file
			email = getEmail();
			email = "EMAIL: " + email;
			
			createAttivitaFile(parcel,maxPerson, place,date,category, email, info);
			System.out.println("Attivit� inserita\n");
		}else if (choice == 2){
			System.out.println("\nNon ho inserito questa attivit�");
		}else{
			System.out.println("\nScelta errata!\n");
		}
	}while (choice != 1 && choice != 2);
			
	}
	
	
	
	//Mostra tutte le attivit� registrate dal cicerone loggato
	public void myActivity(String email){
		Scanner scan3 = new Scanner(System.in);
		boolean find = false;
		String fileName = "attivit�.txt";
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
			if (riga.contains(email)){
				if(find == false){
					System.out.println("\nEcco le tue attivit�:");
				}
				System.out.println(riga);	
				find = true;
			}
		}
			
		if(find == false){
			System.out.println("Non hai inserito alcuna attivit� ancora.");
		}
			
		inputStream.close();	
			
		//Piccola pausa per poter visualizzare le proprie attivit� prima di ritornare al menu
		System.out.print("\nPremi un tasto per continuare . . . \n");
		scan3.nextLine();
	}
	
	
	//Inserisce la nuova attivit� insieme a tutte le altre
	private static void createAttivitaFile (double money,int max, String place, String date, String category, String email,String info) {
		String fileName = "attivit�.txt";
		PrintWriter outputStream = null;
		
		try {
			//Crea un nuovo file solo se non esiste gi�, altrimenti aggiunge in coda il testo
			outputStream = new PrintWriter (new FileOutputStream (fileName, true));
		}catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file");
			System.exit(0);    //Termina il programma
		}
		//Inserisce nel file i dati e chiude lo chiude
		outputStream.printf("| �%-5.2f |", money);
		
		//Per la formattazione ordinata del testo nel file uso questo costrutto if-else
		if (max > 9){
		outputStream.printf(" Massimo:%d Persone |", max);
		}else{
			outputStream.printf(" Massimo:%d  Persone |", max);
			}
		
		outputStream.printf(" %-25s |", place);
		outputStream.printf(" %-10s |", date);
		outputStream.printf(" TAG: %-12s |", category);
		outputStream.printf(" %-30s |", email);
		outputStream.printf(" INFO: %-45s |", info);	
		outputStream.printf("\n");
		outputStream.close();
		System.out.println("File scritto correttamente");
	}
}
