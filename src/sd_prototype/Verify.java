package sd_prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Verify {
	/**
	 * to verify the correctness of username and password
	 */
	public boolean verifyCorrectness(String username, String password) throws IOException {

		File file = new File("UserAccount.txt");
		if (!file.exists() || file.isDirectory()) // check whether the file exists
			file.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(file)); // read by line
		String temp = null;
		temp = br.readLine(); // read by line
		while (temp != null) {
			String sbstring = temp.toString();
			int n = sbstring.length(); // get the length of string
			String[] message = new String[10]; // split the string and assign to an array
			int k = 0;

			for (int i = 0; i < 10; i++)
				message[i] = "";
			for (int i = 0; i < n; i++) {
				if (sbstring.charAt(i) == '~') {
					k++;
				} else {
					message[k] += sbstring.charAt(i);
				}
			}
			if (username.equals(message[0]) && password.equals(message[1]))// check username and password
				return true;
			temp = br.readLine(); // read next line
		}
		return false;

	}

	/**
	 * to verify whether the username exists
	 */
	public boolean verifyExist(String username) throws IOException {

		File file = new File("UserAccount.txt");
		if (!file.exists() || file.isDirectory()) // check whether the file exist
			file.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(file)); // read from file
		String temp = null;
		temp = br.readLine(); // read by line
		while (temp != null) {
			String sbstring = temp.toString();
			int n = sbstring.length(); // get the length of string
			String[] message = new String[10];
			int k = 0;

			// split the string and assign characters to an array.
			for (int i = 0; i < 10; i++)
				message[i] = "";
			for (int i = 0; i < n; i++) {
				if (sbstring.charAt(i) == '~') {
					k++;
				} else {
					message[k] += sbstring.charAt(i);
				}
			}
			if (username.equals(message[0]))
				return true;
			temp = br.readLine();
		}
		return false;
	}

	public boolean verifyBalance(String username, int price) throws IOException {

		File file = new File("UserBalance.txt");
		if (!file.exists() || file.isDirectory()) // check whether the file exist
			file.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(file)); // read from file
		String temp = null;
		temp = br.readLine(); // read by line
		while (temp != null) {
			String sbstring = temp.toString();
			int n = sbstring.length(); // get the length of string
			String[] message = new String[10];
			int k = 0;

			// split the string and assign characters to an array.
			for (int i = 0; i < 10; i++)
				message[i] = "";
			for (int i = 0; i < n; i++) {
				if (sbstring.charAt(i) == '~') {
					k++;
				} else {
					message[k] += sbstring.charAt(i);
				}
			}
			StaticVariable.balance = message[1];// give the current balance to the static variable 'balance'
			// System.out.println(message[1]);
			int userBalance = Integer.parseInt(message[1].trim());

			if (username.equals(message[0]) && price <= userBalance)
				return true;
			temp = br.readLine();
		}
		return false;
	}

	public boolean verifyCharacter(String itemNum) throws IOException {
		File file = new File("Character.txt");
		if (!file.exists() || file.isDirectory()) // check whether the file exist
			file.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = br.readLine();

		String[] message = new String[10];
		while (temp != null) {
			String sbstring = temp.toString();
			int n = sbstring.length();
			for (int i = 0; i < 10; i++)
				message[i] = "";

			int k = 0;
			for (int i = 0; i < n; i++) {
				if (sbstring.charAt(i) == '~') // distinguish each character by '~'
				{
					k++;
				} else {
					message[k] += sbstring.charAt(i);
				}
			}

			if (message[0].equals(itemNum))// verify itemNum exists in the list of character
			{
				return true;
			}
			temp = br.readLine();
		}
		br.close();

		return false;
	}

	public boolean verifyEquipment(String itemNum) throws IOException {
		File file = new File("Equipment.txt");
		if (!file.exists() || file.isDirectory()) // check whether the file exist
			file.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = br.readLine();

		String[] message = new String[10];
		while (temp != null) {
			String sbstring = temp.toString();
			int n = sbstring.length();
			for (int i = 0; i < 10; i++)
				message[i] = "";

			int k = 0;
			for (int i = 0; i < n; i++) {
				if (sbstring.charAt(i) == '~') // distinguish each character by '~'
				{
					k++;
				} else {
					message[k] += sbstring.charAt(i);
				}
			}

			if (message[0].equals(itemNum))// verify itemNum exists in the list of character
			{
				return true;
			}
			temp = br.readLine();
		}
		br.close();

		return false;
	}

	public boolean verifyCharacterExist(String username, String itemNum) throws IOException {
		File file = new File("UserOwnCharacter.txt");
		if (!file.exists() || file.isDirectory()) // check whether the file exist
			file.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = br.readLine();

		String[] message = new String[10];
		while (temp != null) {
			String sbstring = temp.toString();
			int n = sbstring.length();
			for (int i = 0; i < 10; i++)
				message[i] = "";

			int k = 0;
			for (int i = 0; i < n; i++) {
				if (sbstring.charAt(i) == '~') // distinguish each character by '~'
				{
					k++;
				} else {
					message[k] += sbstring.charAt(i);
				}
			}

			String tempCharacterInfo[] = new FileOperation().readCharacter(itemNum);// read the name of this item by its
																					// item number
			if (message[0].equals(username) && message[1].equals(tempCharacterInfo[1]))// verify username and item name
			{
				return true;
			}
			temp = br.readLine();
		}
		br.close();

		return false;
	}

	public boolean verifyEquipmentExist(String username, String itemNum) throws IOException {
		File file = new File("UserOwnEquipment.txt");
		if (!file.exists() || file.isDirectory()) // check whether the file exist
			file.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = br.readLine();

		String[] message = new String[10];
		while (temp != null) {
			String sbstring = temp.toString();
			int n = sbstring.length();
			for (int i = 0; i < 10; i++)
				message[i] = "";

			int k = 0;
			for (int i = 0; i < n; i++) {
				if (sbstring.charAt(i) == '~') // distinguish each character by '~'
				{
					k++;
				} else {
					message[k] += sbstring.charAt(i);
				}
			}

			String tempEquipmentInfo[] = new FileOperation().readEquipment(itemNum);// read the name of this item by its
																					// item number
			if (message[0].equals(username) && message[1].equals(tempEquipmentInfo[1]))// verify username and item name
			{
				return true;
			}
			temp = br.readLine();
		}
		br.close();

		return false;
	}

}
