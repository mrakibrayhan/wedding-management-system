package classes;

import java.util.Scanner;

import fileio.ClientFileReadWrite;

public class Chattogram {
	ClientFileReadWrite cr=new ClientFileReadWrite();

	private String[] venues = { "Agrabad Convention Hall(Location:Sheikh Mujib Road,Chattogram-4100,Contact no:01988988892)",
    		"SK Convention Hall(Location:Port Connecting Road,Chattogram-4100,Contact no:01328988892)", 
    		"Khulsi Convention Hall(Location:Chittagong Highway,Chattogram,Contact no:01418988822)" };
    private int[] venueCosts = { 70000, 80000, 73000 };
    private String[] foodOptions = { "Plain Polao+Roast+Beef+Prawn+Kabab+Borhani+Water+Firni",
    		"Plain Polao+Beef+Roast+Prawn+JordaAlu Bukhara Chatni+Salad (Mixed/Piece)+Mineral Water+Soft Drinks", 
    		"Mutton Katchi Biryani+Chicken Roast+Jali Kebab+"
    		+ "Shahi Jorda (with baby sweets)+Shahi Borhani/Soft Drinks+Mineral Water"};
    
    private int[] foodCosts = { 700, 850, 1000 };
    private String[] decorationOptions = { "200 Pink Roses+100 Orchid+Lighting", "300 Pink Roses+200 Orchid+Lighting", "400 Pink Roses+300 Orchid+Lighting" };
    private int[] decorationCosts = { 12000, 14500, 19000 };

    public int manageWedding() {
    	Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\tChattogram Region - Wedding Management");
        System.out.println();
        System.out.print("Number of Guests: ");
        int guest=input.nextInt();
        int venueChoice, foodChoice, decorationChoice;
        
        System.out.println();
        System.out.println("Select Venue Options:");
        for (int i = 0; i < venues.length; i++) {
            System.out.println(i + 1 + ". " + venues[i] + "-" + venueCosts[i]+"TK");
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
            System.out.println(i + 1 + ". " + foodOptions[i] + "-" + foodCosts[i]+"TK");
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
            System.out.println(i + 1 + ". " + decorationOptions[i] + "-" + decorationCosts[i]+"TK");
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

        int totalCost = venueCosts[venueChoice - 1] + (guest*foodCosts[foodChoice - 1]) + decorationCosts[decorationChoice - 1];
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

