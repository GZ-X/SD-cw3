package sd_prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileOperation {

	public void write(String[] info) throws IOException {
		File file = new File("UserAccount.txt"); // create file
		String infosum = "";
		for (int i = 0; i < 5; i++)
			infosum += info[i] + "~";
		try {
			if (!file.exists())
				file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileOutputStream out = new FileOutputStream(file, true); // create output object
		StringBuffer sb = new StringBuffer();
		sb.append(infosum + "\n");
		out.write(sb.toString().getBytes("gb2312")); // write StringBuffer to file
		out.close(); // close stream
	}

	public void writeBalance(String[] info) throws IOException {
		File file = new File("UserBalance.txt"); // create file
		String infosum = "";
		String balance = "10000";
		infosum += info[0] + "~" + balance + "~";
		try {
			if (!file.exists())
				file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileOutputStream out = new FileOutputStream(file, true); // create output object
		StringBuffer sb = new StringBuffer();
		sb.append(infosum + "\n");
		out.write(sb.toString().getBytes("gb2312")); // write StringBuffer to file
		out.close(); // close stream
	}

	public void updateBalance(String username, String itemNum) throws IOException {
		File file = new File("UserBalance.txt"); // create file
		String infosum = "";
		int newBalance;
		int price;
		String tempCharacterInfo[] = readCharacter(itemNum);
		price = Integer.parseInt(tempCharacterInfo[2]);
		newBalance = Integer.parseInt(StaticVariable.balance) - price;//current balance minus the price of this item
		infosum += username + "~" + newBalance + "~";
		try {
			if (!file.exists())
				file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		String tempUserBalance = raf.readLine();
		String[] message = new String[10];
		while (tempUserBalance != null) {
			String sbstring = tempUserBalance.toString();
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

			if (message[0].equals(username)) // match the information
			{
				raf.write(infosum.getBytes());
			}
			tempUserBalance = raf.readLine();
		}
		raf.close();
	}

	public void buyThisItem(String username, String itemNum) throws IOException {
		File file = new File("UserOwnCharacter.txt"); // create file
		String infosum = "";
		String tempCharacter[] = readCharacter(itemNum);
		infosum += username + "~" + tempCharacter[1] + "~";// write the username and item name together
		try {
			if (!file.exists())
				file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileOutputStream out = new FileOutputStream(file, true); // create output object
		StringBuffer sb = new StringBuffer();
		sb.append(infosum + "\n");
		out.write(sb.toString().getBytes("gb2312")); // write StringBuffer to file
		out.close(); // close stream
		updateBalance(username, itemNum);
	}

	public String[] readCharacter(String itemNum) throws IOException {
		File file = new File("Character.txt");
		if (!file.exists() || file.isDirectory())
			throw new FileNotFoundException();
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
					// System.out.println("@"+message[k]);
					k++;
				} else {
					message[k] += sbstring.charAt(i);
				}
			}

			if (message[0].equals(itemNum)) // match the information
			{
				return message;
			}
			temp = br.readLine();
		}
		br.close();

		return null;
	}



	public String[] read(String account) throws IOException {
		File file = new File("UserAccount.txt");
		if (!file.exists() || file.isDirectory())
			throw new FileNotFoundException();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = br.readLine();

		String[] message = new String[5];
		while (temp != null) {
			String sbstring = temp.toString();
			int n = sbstring.length();
			for (int i = 0; i < 5; i++)
				message[i] = "";

			int k = 0;
			for (int i = 0; i < n; i++) {
				if (sbstring.charAt(i) == '~') // distinguish each character by '~'
				{
					// System.out.println("@"+message[k]);
					k++;
				} else {
					message[k] += sbstring.charAt(i);
				}
			}
			if (message[0].equals(account)) // match the information
			{
				return message;
			}
			temp = br.readLine();
		}
		br.close();

		return null;
	}

}
