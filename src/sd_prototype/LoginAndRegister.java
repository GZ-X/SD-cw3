package sd_prototype;

import java.io.IOException;
import java.util.Scanner;

public class LoginAndRegister {

	Scanner sc = new Scanner(System.in);

	public boolean login() throws IOException {
		boolean flag = false;
		// login interface
		System.out.println("--------------------Login--------------------");
		System.out.println("Please enter your username:");
		String username = sc.nextLine();
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		if (new Verify().verifyCorrectness(username, password)) {
			System.out.println("Login successful");
			flag = true;
		} else {
			System.out.println("Login failed,username or password isn't correct\n");
		}
		return flag;

	}

	// Register
	public void register() throws IOException {

		// register page
		System.out.println("--------------------Register--------------------");
		System.out.println("Please enter your username:");
		String newUserName = sc.nextLine();
		System.out.println("Please enter your password:");
		String newPassword = sc.nextLine();
		System.out.println("Please enter your password again:");
		String confirmPassword = sc.nextLine();
		if (newPassword.equals(confirmPassword)) {

			String[] info = new String[5];
			info[0] = newUserName;
			info[1] = newPassword;
			if (!new Verify().verifyExist(info[0])) {
				
				new FileOperation().write(info);// write user information to file
				System.out.println("Registration success");
			} else {
				System.out.println("Registration failed,username exists\n");
			}
		} else {
			System.out.println("Registration failed,password doesn't match\n");
		}

	}

}
