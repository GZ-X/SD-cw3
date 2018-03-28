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
			System.out.println("\t\t 1. Purchase character\n");//
			System.out.println("\t\t 2. Purchase equipment\n");//
			System.out.println("\t\t 3. return\n");// 注销账户
			System.out.println("----------------------------------------------\n");
			System.out.print("Please select an operation:");
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
				System.out.println("No such choice. Please select again.");
				showMain();
				break;
			}
		}
	}
}