package pricewatcher;
import java.util.Scanner;

/*

Created by Edgar Escobedo and Jorge Quinonez
HW2 2-D Graphics
Advanced Objects 3331
Dr. Cheon
03/06/2019


 */

public class ConsoleUI {
	private Item item;
	
	public ConsoleUI(Item item) {
		this.item = item;
	}
	
	public void showWelcome() {
		System.out.println("Welcome to Price Watcher!");
		
	}

	public void showItem() {
		Item item = new Item();
		System.out.println("Name: "+item.name);
		System.out.println("URL: "+item.url);
		System.out.println("Initial price: "+item.initialPrice);
		System.out.println("Current price: "+item.currentPrice);
		System.out.println("Change: "+item.change+"%");
	}
	
	public char promptUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select the option number that you want: ");
		System.out.println("-To check price again type number: 1\n-To visit webpage type number: 2");
		System.out.println("-To exit the program enter letter: e");
		char selection = sc.next().charAt(0);
		return selection;
	}

}