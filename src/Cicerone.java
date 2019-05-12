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
	private int maxPerson;		//Massimo di persone
	
	public void newActivity(){
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Inserisci i dati per la nuova attività da pubblicare\n");
		System.out.print("Inserisci il luogo: ");
		place = scan2.nextLine();
		System.out.print("Inserisci la data: ");
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
		
		scan2.close();	
		createAttivitaFile(parcel,maxPerson, place,date,category, info, getEmail());
	}
	
	

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
		outputStream.printf("| €%-3f |", money);
		outputStream.printf(" Massimo:%-5d |", max);
		for (int i = 0; i < text.length; i++) {
			outputStream.printf(" %-25s |", text[i]);
	    }
		outputStream.printf("\n");
		outputStream.close();
		System.out.println("File scritto correttamente");
	}
}
