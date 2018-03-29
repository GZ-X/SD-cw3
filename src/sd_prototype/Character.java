package sd_prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

public class Character {

	// Show the menu in character purchase page
	public static void characterMenu() throws BackingStoreException, IOException {
		while (true) {
			System.out.println("--------------------Character-----------------\n");
			System.out.println("\t\t1.Show character\n");
			System.out.println("\t\t2.Return\n");
			System.out.println("----------------------------------------------\n");
			System.out.println("Please select an option and press 'enter':");
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			// switch case
			switch (choice) {
			case "1":
				showCharacter();
				break;
			case "2":
				Market.showMain();
				break;
			default:
				System.out.println("There is no such choice.Please select again");
				break;
			}
		}
	}

	// Show all products
	private static void showCharacter() throws BackingStoreException, IOException {

		File file = new File("Character.txt"); // create file
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
		System.out.println("----------------------------------------------\n");
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
				if (sbstring.charAt(i) == '~') // distinguish each character by '~'
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

		buyCharacter();
	}

	private static void buyCharacter() throws BackingStoreException, IOException {
		boolean stopBuyFlag = true;
		while (stopBuyFlag) {
			System.out.println("Please buy the item by selecting the NO. of it or return by press 'r':");
			Scanner sc = new Scanner(System.in);
			String itemNum = sc.nextLine();
			boolean flag = false;
			flag = new Verify().verifyCharacter(itemNum);
			if (itemNum.equals("r")) {// if user enter 'r', then return to previous page
				characterMenu();
			} else if (flag) {// to check whether the itemNum exists in the list of character
				String tempCharacterInfo[] = new FileOperation().readCharacter(itemNum);
				int price = Integer.parseInt(tempCharacterInfo[2]);
				// to verify whether the balance is enough
				if (!new Verify().verifyCharacterExist(StaticVariable.username, itemNum)) {
					// to verify whether the user has already owned this item
					if (new Verify().verifyBalance(StaticVariable.username, price)) {
						new FileOperation().buyThisCharacter(StaticVariable.username, itemNum);
						System.out.println("Purchase successful");
						// read current balance from file
						String newBalance;
						newBalance = new FileOperation().readBalance(StaticVariable.username);
						System.out.println(
								"'" + StaticVariable.username + "'" + " " + "Your balance is " + newBalance + "\n");

						while (true) {
							System.out.println("Do you want to buy another one?(y/n)\n");
							String choice = sc.nextLine();
							if (choice.equals("y")) {
								// System.out.println("Please buy the item by selecting the NO. of it");
								break;
							} else if (choice.equals("n")) {
								stopBuyFlag = false;
								break;
							} else {
								System.out.println("There is no such operation\n");
							}
						}

					} else {
						System.out.println("Purchase failed. Your balance is insufficient");
					}

				} else {

					System.out.println("You have already purchased this character");
				}

			} else {
				System.out.println("There is no such operation.Please select again");
			}
		}
	}
}
