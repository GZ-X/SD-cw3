package sd_prototype;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

import sd_prototype.Market;

public class Main {
	static int s;
	// static boolean huiyuan, xhuiyuan;
	// static String bke = "百事可乐", ke = "500ml可乐一瓶", m = "5公斤面粉", ss = "1个苏泊尔炒菜锅", o
	// = "欧莱雅爽肤水一瓶";
	static ArrayList<String> array = new ArrayList<String>();
	// static Preferences goodsnodes = Preferences.systemRoot().node("goods"); //
	// 创建节点
	// static Preferences goodschildnode = goodsnodes.node("goods"); // 创建子节点

	public static void main(String[] args) throws IOException, BackingStoreException {

		while (true) {

			// welcome interface
			System.out.println("----------------------------------------------\n");
			System.out.println("\tWelcome to WonderWorld");
			System.out.println("\t1.Login\n\t2.Register\n\t3.Exit\n ");
			System.out.println("----------------------------------------------\n");
			// scanner from keyboard
			Scanner sc = new Scanner(System.in);
			// claim LoginAndRegiter object as lr
			LoginAndRegister lr = new LoginAndRegister();
			// choose operation
			System.out.println("Please select operation:");
			String choiceString = sc.nextLine();

			// switch case
			switch (choiceString) {
			case "1":
				// login interface
				if (lr.login()) {
					Market.showMain();
				}
				break;
			case "2":
				lr.register();// register a new account
				break;
			case "3":
			default:
				System.out.println("Exited");
				System.exit(0); // exit the system
				break;
			}
		}

	}

}
