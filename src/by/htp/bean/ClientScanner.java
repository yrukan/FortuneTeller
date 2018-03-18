package by.htp.bean;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientScanner {
	private Scanner scan = new Scanner(System.in);

	public ClientScanner() {

	}

	public String enterString() {
		String s = scan.next();
		return s;
	}

	public int enterInt() {
		int i = 0;
		try {
			i = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("ќшибка: ¬ведено число не целого типа");
			System.exit(1);
		}
		return i;
	}
	
	public int selectTopic(){
		System.out.println("Enter number of the topic for fortune teller");
		System.out.println("1 - Love");
		System.out.println("2 - Work");
		System.out.println("3 - Finance");
		System.out.println("0 - Exit from program");
		return enterInt();
	}
	
	public String enterName(){
		System.out.println("Enter your first name");
		return enterString();
	}
	
	public String enterSurname(){
		System.out.println("Enter your last name");
		return enterString();
	}
	
	public int selectExit(){
		System.out.println("Would you like to get another prediction?");
		System.out.println("1 - Yes");
		System.out.println("0 - No");		
		return enterInt();
	}
	
}
