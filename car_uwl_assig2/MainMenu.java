package car_uwl_assig2;

import java.util.Date;

public class MainMenu {

	public static void main(String[] args) {

		// declare car object
		Car carobj;
		
		// initialise new Fleet object
		Fleet carObjectsList = new Fleet();

		// To see current date and time may be useful in the commercial
		// application
		System.out.println(new Date());

		// Display Logo and Name of the application
		// car picture comes from the web page: http://ascii.co.uk/art/car
		// accessed: Sat Nov 25 22:34:30 GMT 2017
		System.out.println(
				"_____________________________________CarManager__________________________________________________");
		System.out.println("\n" + "                                 _..-------++._\n"
				+ "                             _.-'/ |      _||  \\\"--._\n"
				+ "                       __.--'`._/_\\j_____/_||___\\    `----.\n"
				+ "                  _.--'_____    |          \\     _____    /\n"
				+ "                _j    /,---.\\   |        =o |   /,---.\\   |_\n"
				+ "               [__]==// .-. \\\\==`===========/==// .-. \\\\=[__]\n"
				+ "                 `-._|\\ `-' /|___\\_________/___|\\ `-' /|_.'     hjw\n"
				+ "                       `---'                     `---'\n" + "\n");

		
		String userCommand;	// Declare character type variable used in the switch statement
		while (true) { // Continually iterate over available user options
			// Prompt user to choose an option
			userCommand = Console.askString(""
					+ "\n ______________________________________________________________________________________________\n"
					+ "					Menu												\n"
					+ " ______________________________________________________________________________________________"
					+ "\n| [A] Add |[U] Update [I] In-Stock | [F] Find  | [R] Remove        	  	               |"
					+ "\n| [S] Sell cars  | [SLD] Sold cars  |  [FS] Find sold car             		               |\n"
					+ "| [TIS] Total In-Stock | [TS] Total Sold |[H] Help | [E] Exit                                  |\n"
					+ "|______________________________________________________________________________________________|\n|>");

			// switch statement
			switch (userCommand.toUpperCase()) {

			// ADD NEW CAR
			case "A":
				carobj = new Car();
				carobj.askCar("\n-----------------------------\n"
						+ "Please enter new car details.\n-----------------------------");
				if (carObjectsList.findCarObj(carobj.getReg()) != null) {
					System.out.println("\nCar with such number plate already exists.");
					System.out.println("Try to enter different car or amend details.");
				} else {
					carObjectsList.addCar(carobj);
					System.out.print("\nThank You. Car added to the list\n\n");
				}
				break;

			case "U":
				String update = Console.askString("\nTo update car information, type the number plate |>");
				if (carObjectsList.findCarObj(update) != null) {
					carObjectsList.updateCar(update);
				} else {
					System.out.println("\nThe Car ***" + update + "*** Not Found. Please try again...\n");
				}
				break;

				// DISPLAY EXISTING IN-STOCK CARS
			case "I":
				if (carObjectsList.getSize() == 0) {
					System.out.println("\n\n\n\t\t\t***There are no cars in the list***\n\n");
				} else {
					System.out.println("\n\n\n\t\t\t***Cars-in-Stock:***\n\n");
					carObjectsList.details();
				}
				break;
				
			// FIND CAR IN STOCK
			case "F":
				String registration = Console.askString("\nFind cars in stock by number plate |>");
				if (carObjectsList.findCarObj(registration) != null) {
					carObjectsList.findCar(registration);
				} else {
					System.out.println("\nThe Car ***" + registration + "*** Not Found. Please try again...\n");
					
				}
				break;
				
			// REMOVE CAR
			case "R":
				String numplate = Console.askString("\nPlease enter " + "the number plate to remove car |>");
				if (carObjectsList.getSize() == 0) {
					System.out.println("\n\n\n\t\t\t***List is empty***\n\n");
				} else if (carObjectsList.findCarObj(numplate) == null) {
					System.out.println("\nCar ***" + numplate + "*** Not Found. Please try again...\n");
				} else {
					carObjectsList.removeCar(numplate);
				}
				break;

			// MOVE CAR FROM THE STOCK TO SOLD LIST
			case "S":
				String sellinp = Console.askString("\nPlease enter details of the sold car: ");
				carObjectsList.addToSoldCar(sellinp);// add car to sold car list
				break;

			// DISPLAY SOLD CARS LIST
			case "SLD":
				if (Fleet.soldCarList.size() == 0) {
					System.out.println("\n\n\n\t\t\t***There are no cars in the list***\n\n");
				} else {

					System.out.println("\n\n\n\t\t\t***List Of Sold Cars:***\n\n");

					Fleet.showSoldList();
				}
				break;

			// SEARCH LIST OF SOLD CARS
			case "FS":
				String registrationSold = Console.askString("\nFind sold cars by number plate |>");
				Fleet.findSoldCar(registrationSold);
				break;
				
			// TOTAL IN-STOCK
			case "TIS":
				System.out.println("\nNumber of cars in stock: " + carObjectsList.getSize());
				break;

			// TOTAL SOLD CARS
			case "TS":
				System.out.println("\nNumber of sold cars: " + Fleet.soldCarList.size());
				break;

			// HELP
			case "H":
				Car.helpMenu();
				break;

			// EXIT
			case "E":
				System.out.println("\n\n\n\t\t\t***Thank You For Using CarManager***\n\n");
				System.exit(0);
				break;

			// DELETE ALL
			case "DELETEALL":
				String a = Console.askString(
						"Are you sure you want to delete all details Y|N? " + "This action cannot be undone.\n|>");
				if (a.equalsIgnoreCase("y")) {

					if (carObjectsList.getSize() == 0) {
						System.out.println("\n\n\n\t\t\t***List empty***\n\n");

					} else {
						carObjectsList.carList.clear();// clear in-stock list
						Fleet.soldCarList.clear(); // clear sold car list
						System.out.println("\n\n\n\n\t\t\t***All cars have been deleted***\n\n");
					}
				}
				break;
				
			// NOTIFY USER OF SELECTED OPTION THAT DOES NOT EXIST
			default:
				System.out.println("\nSorry, this option is not available.\n" + "Try again. For Help press 'H'.");
				break;
			}
		}
	}
}
