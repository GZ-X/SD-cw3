package sd_prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

public class Equipment {

	// Show the menu in Equipment purchase page
	public static void equipmentMenu() throws BackingStoreException, IOException {
		while (true) {
			System.out.println("--------------------Equipment-----------------\n");
			System.out.println("\t\t1.Show Equipment\n");
			System.out.println("\t\t2.Return\n");
			System.out.println("----------------------------------------------\n");
			System.out.print("Please select an operation:");
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			// switch case
			switch (choice) {
			case "1":
				showEquipment();
				break;
			case "2":
				Market.showMain();
				break;
			default:
				System.out.println("No such choice. Please select again");
				break;
			}
		}
	}

	// Show all products
	private static void showEquipment() throws BackingStoreException, IOException {

		File file = new File("Equipment.txt"); // create file
		try {
			if (!file.exists())
				file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = br.readLine();

		String[] productInfo = new String[10];
		if (temp == null)
			System.out.println("No item");
		while (temp != null) {
			String sbstring = temp.toString();
			int n = sbstring.length();
			for (int i = 0; i < 10; i++)
				productInfo[i] = "";

			int k = 0;
			for (int i = 0; i < n; i++) {
				if (sbstring.charAt(i) == '~') // distinguish each Equipment by '~'
				{
					k++;
				} else {
					productInfo[k] += sbstring.charAt(i);
				}
			}
			for (int i = 0; i < 10; i++) {
				System.out.print(productInfo[i] + " ");
			}
			System.out.println("\n");
			temp = br.readLine();
		}

		System.out.println("Please buy the item by selecting the NO. of it:");
		buyEquipment();
	}

	private static void buyEquipment() throws BackingStoreException, IOException {

		while (true) {
			Scanner sc = new Scanner(System.in);
			String itemNum = sc.nextLine();
			
			if (itemNum.equals("r")) {
				equipmentMenu();
			}
			
			
			else {
				String tempEquipmentInfo[] = new FileOperation().readEquipment(itemNum);
				int price = Integer.parseInt(tempEquipmentInfo[2]);
				// to verify whether the balance is enough

				if (new Verify().verifyBalance(StaticVariable.username, price)) {
					// to verify whether the user has already owned this item
					if (!new Verify().verifyEquipmentExist(StaticVariable.username, itemNum)) {
						new FileOperation().buyThisEquipment(StaticVariable.username, itemNum);
						System.out.println("Purchase successful");
						//read current balance from file
						String newBalance;
						newBalance = new FileOperation().readBalance(StaticVariable.username);
						System.out.println(StaticVariable.username +  " " + "Your balance is " + newBalance + "\n");
						System.out.println("Do you want to buy another one?(y/n)");
						String choice = sc.nextLine();
						if (choice.equals("y")) {
							System.out.println("Please buy the item by selecting the NO. of it");
							continue;
						} else {
							break;
						}
					} else {
						System.out.println("You have already purchased this Equipment");
						System.out.println("Please select another one or return by enter 'r'");
					}

				} else {
					System.out.println("Purchase failed. Your balance is insufficient");
				}

			}
		}
	}
}
