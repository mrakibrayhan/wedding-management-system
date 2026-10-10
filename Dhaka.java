package classes;

import java.util.Scanner;

import fileio.ClientFileReadWrite;

public class Dhaka {
	ClientFileReadWrite cr=new ClientFileReadWrite();

	private String[] venues = { "XINXIAN(Location:Uttara-1,Dhaka-1205,Contact no:01892791891)",
			"WHite House Convention Centre (Location:Shantinagar Rd,Dhaka-1219,Contact no:01891791891)",
			"Friend's Convention Centre (Location:Khilgaon,Dhaka-1219,Contact no:01999288911)",
			"Abacus Convention Centre (Eskaton Road,Dhaka-1000,Contact no:017289399911)" };
	private int[] venueCosts = { 120000, 100000, 80000, 130000 };

	private String[] foodOptions = { "Roast+Polao+Beef+Prawn+Kabab+Borhani+Water+Firni",
			"Jasmine Rice+Beef+Roast+Prawn+coke+Jorda+Mineral Water+Coke",
			"Mutton Katchi Biryani+Chicken Roast+Jali Kebab+"
					+ "Shahi Jorda (with baby sweets)+Shahi Borhani/Soft Drinks+"
					+ "Alu Bukhara Chatni+Salad (Mixed/Piece)+Mineral Water" };
	private int[] foodCosts = { 800, 700, 1100 };

	private String[] decorationOptions = { "200 Pink Roses+100 Orchid+Lighting", "300 Pink Roses+200 Orchid+Lighting",
			"400 Pink Roses+300 Orchid+Lighting" };
	private int[] decorationCosts = { 18000, 25000, 30000 };

	public int manageWedding() {

		Scanner input = new Scanner(System.in);
		System.out.println("\t\t\t\t\t\tDhaka Region - Wedding Management");
		System.out.println();
		System.out.print("Number of Guests: ");
		int guest = input.nextInt();
		int venueChoice, foodChoice, decorationChoice;

		System.out.println();
		System.out.println("Select Venue Options:");
		for (int i = 0; i < venues.length; i++) {
			System.out.println(i + 1 + ". " + venues[i] + "-" + venueCosts[i] + "TK");
		}

		while (true) {
			System.out.print("Option: ");
			venueChoice = input.nextInt();
			if (venueChoice >= 1 && venueChoice <= venues.length) {
				break;
			} else {
				System.out.println("Invalid venue choice!");
				System.out.print("Please choose a valid Venue ");
			}
		}

		System.out.println();
		System.out.println("Select Food Option:");
		for (int i = 0; i < foodOptions.length; i++) {
			System.out.println(i + 1 + ". " + foodOptions[i] + "-" + foodCosts[i] + "TK");
		}

		while (true) {
			System.out.print("Option: ");
			foodChoice = input.nextInt();
			if (foodChoice >= 1 && foodChoice <= foodOptions.length) {
				break;
			} else {
				System.out.println("Invalid food choice!");
				System.out.print("Please choose a valid Food ");
			}
		}
		System.out.println();
		System.out.println("Select Decoration Option:");
		for (int i = 0; i < decorationOptions.length; i++) {
			System.out.println(i + 1 + ". " + decorationOptions[i] + "-" + decorationCosts[i] + "TK");
		}

		while (true) {
			System.out.print("Option: ");
			decorationChoice = input.nextInt();
			if (decorationChoice >= 1 && decorationChoice <= decorationOptions.length) {
				break;
			} else {
				System.out.println("Invalid decoration choice");
				System.out.print("Please choose a valid decoration ");
			}
		}

		int totalCost = venueCosts[venueChoice - 1] + (guest * foodCosts[foodChoice - 1])
				+ decorationCosts[decorationChoice - 1];
		System.out.println();
		System.out.println();
		System.out.println("Selected Venue: " + venues[venueChoice - 1]);
		cr.writeInFile("Selected Venue           : "+venues[venueChoice - 1]);
		System.out.println("Selected Food Items: " + foodOptions[foodChoice - 1]);
		cr.writeInFile("Selected Food Items      : "+foodOptions[foodChoice - 1]);
		System.out.println("Selected Decorations: " + decorationOptions[decorationChoice - 1]);
		cr.writeInFile("Selected Decoration Type : "+decorationOptions[decorationChoice - 1]);
		System.out.println("Number of Guests: " + guest);
		cr.writeInFile("Total Guest Number       : "+""+guest);
		

		System.out.println();
		System.out.println();
		System.out.println("Venue Cost: " + venueCosts[venueChoice - 1] + "TK");
		cr.writeInFile("Venue Cost : "+venueCosts[venueChoice - 1]+"Taka");
		System.out.println("Food Cost: " + (guest * foodCosts[foodChoice - 1]) + "TK");
		cr.writeInFile("Food Cost : "+(guest * foodCosts[foodChoice - 1])+"Taka");
		System.out.println("Decoration Cost: " + decorationCosts[decorationChoice - 1] + "TK");
		cr.writeInFile("Decoration Cost : "+decorationCosts[decorationChoice - 1]+"Taka");
		cr.writeInFile(" Cost : "+totalCost+" Taka");
		cr.writeInFile("Photography Cost : "+50000+" Taka");

		return totalCost;

	}
}
