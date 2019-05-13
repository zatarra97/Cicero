import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Cicerone extends Globetrotter {
	private String category;		//Categoria di viaggio
	private String date;			//Data
	private String place;			//Luogo 
	private double parcel;			//Costo dell'attività
	private String info;			//Informazioni itinerario
	private int maxPerson;			//Massimo di persone
	int choice = 0;					//Contiene le scelte nel menu di conferma per salvare l'attività
	
	//Inserisce una nuova attività
	public void newActivity(){
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Inserisci i dati per la nuova attività da pubblicare\n");
		System.out.print("Inserisci il luogo: ");
		place = scan2.nextLine();
		System.out.print("Inserisci la data (formato gg/mm/aaaa): ");
		date = scan2.nextLine();
		System.out.print("Quante persone possono partecipare massimo: ");
		maxPerson = scan2.nextInt();
		scan2.nextLine();	//Prende in input il carattere 'invio'
		System.out.print("Inserisci la categoria del viaggio: ");
		category = scan2.nextLine();
		System.out.print("Inserisci qualche info sul percorso: ");
		info = scan2.nextLine();
		System.out.print("Inserisci il tuo compenso: ");
		parcel = scan2.nextDouble();
	do{	
		System.out.print("Sei sicuro di voler pubblicare questa tua attività? (1 = si / 2 = no): ");
		choice = scan2.nextInt();
		if (choice == 1){
			//Inserisce i dati nel file
			createAttivitaFile(parcel,maxPerson, place,date,category, info, getEmail());
			System.out.println("Attività inserita\n");
		}else if (choice == 2){
			System.out.println("\nNon ho inserito questa attività");
		}else{
			System.out.println("\nScelta errata!\n");
		}
	}while (choice != 1 && choice != 2);
			
	}
	
	
	
	//Mostra tutte le attività registrate dal cicerone loggato
	public void myActivity(String email){
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
				if (riga.contains(email)){
					if(find == false){
						System.out.println("\nEcco le tue attività:");
					}
					System.out.println(riga);	
					find = true;
				}
			}
			
			if(find == false){
				System.out.println("Non hai inserito alcuna attività ancora.");
			}
			
			inputStream.close();	
			
			Scanner scan3 = new Scanner(System.in);
			System.out.println("");
			//TODO Inserire uno stop prima di ritornare nel menu principale
	}
	
	
	//Inserisce la nuova attività insieme a tutte le altre
	private static void createAttivitaFile (double money,int max, String... text) {
		String fileName = "attività.txt";
		PrintWriter outputStream = null;
		
		try {
			//Crea un nuovo file solo se non esiste già, altrimenti aggiunge in coda il testo
			outputStream = new PrintWriter (new FileOutputStream (fileName, true));
		}catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file");
			System.exit(0);    //Termina il programma
		}
		//Inserisce nel file i dati e chiude lo chiude
		outputStream.printf("| €%-5.2f |", money);
		
		//Per la formattazione ordinata del testo nel file uso questo costrutto if-else
		if (max > 9){
		outputStream.printf(" Massimo:%d Persone |", max);
		}else{
			outputStream.printf(" Massimo:%d  Persone |", max);
			}
		for (int i = 0; i < text.length; i++) {
			outputStream.printf(" %-25s |", text[i]);
	    }
		outputStream.printf("\n");
		outputStream.close();
		System.out.println("File scritto correttamente");
	}
}
