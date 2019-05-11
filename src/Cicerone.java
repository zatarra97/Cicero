import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Cicerone extends Person{
	private String category;
	private String date;
	private String place;
	private double parcel;
	private String info;
	
	
	public void newActivity(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserisci i dati per la nuova attività da pubblicare\n");
		System.out.print("Inserisci il luogo: ");
		place = scan.nextLine();
		System.out.print("Inserisci la data: ");
		date = scan.nextLine();
		System.out.print("Inserisci la categoria del viaggio: ");
		category = scan.nextLine();
		System.out.print("Inserisci qualche info sul percorso: ");
		info = scan.nextLine();
		System.out.print("Inserisci il tuo compenso: ");
		parcel = scan.nextDouble();
		
		scan.close();	
		createFile(parcel, place,date,category, info);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void createFile (double money, String... text) {
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
		outputStream.printf("|%-5f |", money);
		for (int i = 0; i < text.length; ++i) {
			outputStream.printf(" %-25s |", text[i]);
	    }
		outputStream.printf("\n");
		outputStream.close();
		System.out.println("File scritto correttamente");
	}
}
