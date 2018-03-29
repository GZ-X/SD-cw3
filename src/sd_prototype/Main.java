package sd_prototype;

import java.io.IOException; 
import java.util.Scanner;
import java.util.prefs.BackingStoreException;


/**
*
* @author Guo Zheng   
* Game Market system
* Github URL : https://github.com/GZ-X/SD-cw3.git
* 
*/
public class Main {
	
	public static void main(String[] args) throws IOException, BackingStoreException {


		while (true) {

			// welcome interface
			System.out.println("----------------------------------------------\n");
			System.out.println("            Welcome to WonderWorld\n");
			System.out.println("\t\t1.Login\n");
			System.out.println("\t\t2.Register\n");
			System.out.println("\t\t3.Exit\n ");
			System.out.println("----------------------------------------------\n");
			// scanner from keyboard
			Scanner sc = new Scanner(System.in);
			// claim LoginAndRegiter object as lr
			LoginAndRegister lr = new LoginAndRegister();
			// choose operation
			System.out.println("Please select an option and press 'enter':");
			String choice = sc.nextLine();

			// switch case
			switch (choice) {
			case "1":
				// login interface
				if (lr.login()) {
					PlayerMain.playerMainPage();;
				}
				break;
			case "2":
				lr.register();// register a new account
				break;
			case "3":
				System.out.println("Exited the system");
				System.exit(0); // exit the system
				break;
			default:
				System.out.println("There is no such choice. Please select again");
				break;
				
			}
		}

	}

}
