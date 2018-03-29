package sd_prototype;

import java.io.IOException;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;
/**
* @author Guo Zheng   
* 
* Player management main page
* 
*/
public class PlayerMain {

	public static void playerMainPage() throws IOException, BackingStoreException {
		
		while (true) {

			// player main interface
			System.out.println("------------------WonderWorld-----------------\n");
			System.out.println("\t\t1.Start battle\n");
			System.out.println("\t\t2.Market\n");
			System.out.println("\t\t3.Create squad\n");
			System.out.println("\t\t4.Edit squad\n");
			System.out.println("\t\t5.Log off\n");
			System.out.println("----------------------------------------------\n");
			// scanner from keyboard
			Scanner sc = new Scanner(System.in);
			// choose operation
			System.out.println("Please select an option and press 'enter':");
			String choice = sc.nextLine();

			// switch case
			switch (choice) {
			// Battle page
			case "1":
				while(true) {
				System.out.println("---------------------Battle-------------------");
				System.out.println("|                                            |");
				System.out.println("|        This module is not yet online       |");
				System.out.println("|                                            |");
				System.out.println("----------------------------------------------");
				System.out.println("\nDo you want to return?(y/n)\n");
				String decision = sc.next();
				if(decision.equals("y")) {
					break;
				}
				else if(decision.equals("n"))
				{
					continue;
				}
				else {
					System.out.println("No such operation.Please enter y/n\n");
				}
				}
				break;
		    // Market page	
			case "2":
				Market.showMain();
				break;
		    // Create squad page
			case "3":
				while(true) {
					System.out.println("------------------Create squad----------------");
					System.out.println("|                                            |");
					System.out.println("|        This module is not yet online       |");
					System.out.println("|                                            |");
					System.out.println("----------------------------------------------");
					System.out.println("\nDo you want to return?(y/n)\n");
					String decision = sc.next();
					if(decision.equals("y")) {
						break;
					}
					else if(decision.equals("n"))
					{
						continue;
					}
					else {
						System.out.println("No such operation.Please enter y/n\n");
					}
					}
					break;
			// Edit squad page
			case "4":
				while(true) {
					System.out.println("-------------------Edit squad-----------------");
					System.out.println("|                                            |");
					System.out.println("|        This module is not yet online       |");
					System.out.println("|                                            |");
					System.out.println("----------------------------------------------");
					System.out.println("\nDo you want to return?(y/n)\n");
					String decision = sc.next();
					if(decision.equals("y")) {
						break;
					}
					else if(decision.equals("n"))
					{
						continue;
					}
					else {
						System.out.println("No such operation.Please enter y/n\n");
					}
					}
					break;
			//log off
			case "5":
				System.out.println("You have Logged off\n");
				Main.main(null);
			default:
				System.out.println("There is no such choice. Please select again\n");
				break;
				
			}
		}
	}
}
