package sd_prototype;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileOperation {

	public void write(String[] info) throws IOException {
		File file = new File("UserAccount.txt"); // create file
		String infosum = "";
		for (int i = 0; i < 10; i++)
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

	public void updateBalanceByChar(String username, String itemNum) throws IOException {
		File file = new File("UserBalance.txt"); // create file
		int count1 = 0,count2 = 0;
		String[][] tempAllUserBalance = new String[20][20];
		int newBalance;
		int price;
		String tempCharacterInfo[] = readCharacter(itemNum);
		price = Integer.parseInt(tempCharacterInfo[2]);
		newBalance = Integer.parseInt(StaticVariable.balance) - price;// current balance minus the price of this item
		//infosum += username + "~" + newBalance + "~";
		try {
			if (!file.exists())
				file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		BufferedReader br = new BufferedReader(new FileReader(file));
		String tempUserBalance = br.readLine();
		while (tempUserBalance != null) { // read line by line
			String[] linedata = tempUserBalance.split("~"); // read one line of data
			
			for (count2 = 0; count2 < linedata.length; count2++) {
				tempAllUserBalance[count1][count2] = linedata[count2];
			}
			count1++;
			// Read next line
			tempUserBalance = br.readLine();
			// Clear the array
			linedata = null;
		}
		br.close();
        //System.out.println(count1);
        //System.out.println(count2);
		String[][] AllUserBalance = new String[count1][count2];
		for (int i = 0; i < count1; i++) {
			for (int j = 0; j < count2; j++) {
				AllUserBalance[i][j] = tempAllUserBalance[i][j];
			}
		}
			
		for (int i = 0; i < AllUserBalance.length; i++) {
			if (AllUserBalance[i][0].equals(username)) {
				AllUserBalance[i][1] = Integer.toString(newBalance);
				break;
			}
		}

		BufferedWriter write = new BufferedWriter(new FileWriter(file));
		int i,j;

		for(i = 0; i < AllUserBalance.length; i++){
			for(j = 0; j < AllUserBalance[i].length ; j++){
				write.write(AllUserBalance[i][j]+"");
				if(j < AllUserBalance[i].length - 1)
					write.write("~");
			}
			write.newLine();
		}
		write.flush();
		write.close();

	}
	
	public void updateBalanceByEquip(String username, String itemNum) throws IOException {
		File file = new File("UserBalance.txt"); // create file
		int count1 = 0,count2 = 0;
		String[][] tempAllUserBalance = new String[20][20];
		int newBalance;
		int price;
		String tempEquipmentInfo[] = readEquipment(itemNum);
		price = Integer.parseInt(tempEquipmentInfo[2]);
		newBalance = Integer.parseInt(StaticVariable.balance) - price;// current balance minus the price of this item
		//infosum += username + "~" + newBalance + "~";
		try {
			if (!file.exists())
				file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		BufferedReader br = new BufferedReader(new FileReader(file));
		String tempUserBalance = br.readLine();
		while (tempUserBalance != null) { // read line by line
			String[] linedata = tempUserBalance.split("~"); // read one line of data
			
			for (count2 = 0; count2 < linedata.length; count2++) {
				tempAllUserBalance[count1][count2] = linedata[count2];
			}
			count1++;
			// Read next line
			tempUserBalance = br.readLine();
			// Clear the array
			linedata = null;
		}
		br.close();
        //System.out.println(count1);
        //System.out.println(count2);
		String[][] AllUserBalance = new String[count1][count2];
		for (int i = 0; i < count1; i++) {
			for (int j = 0; j < count2; j++) {
				AllUserBalance[i][j] = tempAllUserBalance[i][j];
			}
		}
			
		for (int i = 0; i < AllUserBalance.length; i++) {
			if (AllUserBalance[i][0].equals(username)) {
				AllUserBalance[i][1] = Integer.toString(newBalance);
				break;
			}
		}

		BufferedWriter write = new BufferedWriter(new FileWriter(file));
		int i,j;

		for(i = 0; i < AllUserBalance.length; i++){
			for(j = 0; j < AllUserBalance[i].length ; j++){
				write.write(AllUserBalance[i][j]+"");
				if(j < AllUserBalance[i].length - 1)
					write.write("~");
			}
			write.newLine();
		}
		write.flush();
		write.close();

	}
	
	

	public void buyThisCharacter(String username, String itemNum) throws IOException {
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
		updateBalanceByChar(username, itemNum);
	}
	
	public void buyThisEquipment(String username, String itemNum) throws IOException {
		File file = new File("UserOwnEquipment.txt"); // create file
		String infosum = "";
		String tempEquipment[] = readEquipment(itemNum);
		infosum += username + "~" + tempEquipment[1] + "~";// write the username and item name together
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
		updateBalanceByEquip(username, itemNum);
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
	
	public String[] readEquipment(String itemNum) throws IOException {
		File file = new File("Equipment.txt");
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
	
	
	public String readBalance(String username) throws IOException {
		File file = new File("UserBalance.txt");
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
					k++;
				} else {
					message[k] += sbstring.charAt(i);
				}
			}
			if (message[0].equals(username)) // match the information
			{
				return message[1];
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
