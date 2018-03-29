package sd_prototype;

import java.io.IOException;
import java.util.Scanner;

public class LoginAndRegister {

	Scanner sc = new Scanner(System.in);

	public boolean login() throws IOException {
		boolean flag = false;
		// login interface
		System.out.println("--------------------Login---------------------\n");
		System.out.println("Please enter your username and press 'enter':");
		StaticVariable.username = sc.nextLine();
		System.out.println("Please enter your password and press 'enter':");
		StaticVariable.password = sc.nextLine();
		if (new Verify().verifyCorrectness(StaticVariable.username, StaticVariable.password)) {
			System.out.println("Login successful\n");
			flag = true;
		} else {
			System.out.println("Login failed,username doesn't exist or incorrect password\n");
		}
		return flag;

	}

	// Register
	public void register() throws IOException {

		// register page
		System.out.println("--------------------Register------------------\n");
		System.out.println("Please enter your username and press 'enter':");
		String newUserName = sc.nextLine();
		System.out.println("Please enter your password and press 'enter':");
		String newPassword = sc.nextLine();
		System.out.println("Please enter your password again and press 'enter':");
		String confirmPassword = sc.nextLine();
		if (newPassword.equals(confirmPassword)) {

			String[] info = new String[10];
			info[0] = newUserName;
			info[1] = newPassword;
			if (!new Verify().verifyExist(info[0])) {
				
				new FileOperation().write(info);// write user information to file
				new FileOperation().writeBalance(info);//create initial balance for user
				System.out.println("Registration success\n");
			} else {
				System.out.println("Registration failed,username exists\n");
			}
		} else {
			System.out.println("Registration failed,password doesn't match\n");
		}

	}

}
