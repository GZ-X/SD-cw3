package sd_prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

public class Equipment {

	// Show the menu in character purchase page
	public static void equipmentMenu() throws BackingStoreException, IOException {
		while (true) {
			System.out.println("--------------------Equipment-----------------\n");
			System.out.println("\t\t1.Show equipment\n");
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
		BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();
        temp=br.readLine();

		String[] productInfo = new String[10];
		if(temp == null)
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
			
			int item = 1;
			System.out.print(item+".");
			for(int i = 0; i<10; i++)
			{
				System.out.print( productInfo[i]+" ");
			}
			System.out.println("\n");
			item++;
			temp = br.readLine();
		}
		
		
		
		
	}

	private static void buyEquipment() {

	}

}
