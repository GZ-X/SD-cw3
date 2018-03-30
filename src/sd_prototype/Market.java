package sd_prototype;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * @author Guo Zheng
 * 
 *         Market page
 * 
 */
public class Market {

	public static void showMain() throws BackingStoreException, IOException {

		while (true) {

			System.out.println("--------------------Market--------------------\n");
			System.out.println("\t\t1.Purchase character\n");//
			System.out.println("\t\t2.Purchase equipment\n");//
			System.out.println("\t\t3.return\n");// log off
			System.out.println("----------------------------------------------\n");
			System.out.println("Please select the option and press 'enter':");
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				Character.characterMenu();
				break;
			case "2":
				Equipment.equipmentMenu();
				break;
			case "3":
				PlayerMain.playerMainPage();
				break;
			default:
				System.out.println("There is no such operation. Please select again");
				showMain();
				break;
			}
		}
	}
}