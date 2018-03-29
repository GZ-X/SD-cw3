package sd_prototype;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

import sd_prototype.Market;

/**
* @author Guo Zheng   
* 
* Game Market system
* 
*/
public class Main {
	
	public static void main(String[] args) throws IOException, BackingStoreException {


		while (true) {

			// welcome interface
			System.out.println("----------------------------------------------\n");
			System.out.println("\tWelcome to WonderWorld\n");
			System.out.println("\t1.Login\n");
			System.out.println("\t2.Register\n");
			System.out.println("\t3.Exit\n ");
			System.out.println("----------------------------------------------\n");
			// scanner from keyboard
			Scanner sc = new Scanner(System.in);
			// claim LoginAndRegiter object as lr
			LoginAndRegister lr = new LoginAndRegister();
			// choose operation
			System.out.println("Please select operation:");
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
				System.out.println("No such choice. Please select again");
				break;
				
			}
		}

	}

}
