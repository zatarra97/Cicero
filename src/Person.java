import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Person {
	
	
	private String  name;
	private String  surname;
	private String  phone;
	private String  email;
	private String  password;
	
	public Person () {
		name = "No Name";
		surname = "No Surname";
		phone = "No phone number";
		email = "No email";
	}
	
	public void printProfile() {
		System.out.println("\nEcco i tuoi dati");
		System.out.println("Nome e Cognome: " + name + " " + surname);
		System.out.println("Email: " + email);
		System.out.println("Numero di telefono: " + phone + "\n");
		
	}
	
	//Registrazione
	public void signUp() {		
		Scanner scan = new Scanner (System.in);
		System.out.println("Benvenuto! Inserisci i tuoi dati\n");
		System.out.print("Nome: ");
		name = scan.nextLine();
		System.out.print("Cognome: ");
		surname = scan.nextLine();
		System.out.print("Email: ");
		email = scan.next();	//Non possono esserci spazi (Si può fare un controllo con la grammatica regolare)
		System.out.print("Password: ");
		password = scan.next();
		System.out.print("Numero di telefono: " );
		phone = scan.next();
		createFile(name, surname, phone, email, password);
		scan.close();
	}
	
	//LOGIN
	public void logIn(String email, String password) {		
		String userAccount = openAccessFile (email, password);
		
		if (userAccount == "null"){
			System.out.println("Credenziali errate, riprovare!");
			
		}else{//Popola le variabili che contengono le credenziali e i dati dell'account
			int length1, length2; //Servono per spezzare la stringa del file e acquisire i dati singoli
			
			length1 = userAccount.indexOf("COGNOME");
			this.name = userAccount.substring(8, length1 - 2);
			this.name.replace(" ", ""); //Toglie tutti gli spazi vuoti
			System.out.println("Benvenuto " + this.name);
			
			length1 = length1 +9;
			length2 = userAccount.indexOf("PHONE");
			this.surname = userAccount.substring(length1 , length2 - 2);
			this.surname.replace(" ", ""); //Toglie tutti gli spazi vuoti
			
			length1 = length2 + 7;
			//Length1 + 10 perchè il numero di telefono è lungo 10 numeri e non di più
			this.phone = userAccount.substring(length1 , length1 + 10);
			
			this.email = email;
			this.password = password;
			
			printProfile();
			
		}
	}
	
	public String getEmail(){
		return email;
	}
	
	
	//Inserisce i dati della registrazione all'interno del file
	private static void createFile (String name,String surname,String phone,String email,String password) {
		String fileName = "account.txt";
		PrintWriter outputStream = null;
		
		try {
			//Crea un nuovo file solo se non esiste già, altrimenti aggiunge in coda il testo
			outputStream = new PrintWriter (new FileOutputStream (fileName, true));
		}catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file");
			System.exit(0);    //Termina il programma
		}
		//Inserisce nel file i dati e chiude lo chiude
		outputStream.printf("| NOME: %-25s | COGNOME: %-25s | PHONE: %-15s | EMAIL: %-25s | PWD: %-25s |", name, surname, phone, email, password);
		
		outputStream.printf("\n");
		outputStream.close();
		System.out.println("File scritto correttamente");
	}
	
	//Apre il file dove ci sono tutti gli account e vede se i dati inseriti esistono per l'accesso
	public static String openAccessFile (String email, String password) {
		String account = null;	//Null se non viene trova un account, altrimenti contiene i dati
		boolean find = false;
		
		String fileName = "account.txt";
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
			if (riga.contains(email) && riga.contains(password)){
				System.out.println("\nAccount trovato!\n");
				//System.out.println(riga);		Stampa la riga dei dati che corrispondono alle credenziali inserite
				find = true;
				account = riga;
				break;
			}
		}
		
		if(find == false){
			account = null;
		}
		
		inputStream.close();
		return account;
	}
	
}
