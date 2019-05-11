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
		
		public void order (){
			Scanner scan = new Scanner (System.in);
			System.out.println("Cerca un Cicerone per un viaggio:\n");
			System.out.println("Qaul è la tua destinazione?");
			System.out.print("Vorrei andare in: ");
			destination = scan.nextLine();
			
			
			
			
		}
		
}
