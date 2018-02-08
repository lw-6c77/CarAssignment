package car_uwl_assig2;

import java.util.ArrayList;

public class Fleet {

	// Declare an ArrayList<> where car object will be stored
	ArrayList<Car> carList;	
	// Declare an ArrayList<> where sold car objects will be stored
	static ArrayList<Car> soldCarList;

	// Constructor
	public Fleet() {
		carList = new ArrayList<Car>(); // in-stock cars
		soldCarList = new ArrayList<Car>(); // sold cars
	}

	// ADD/UPDATE/MOVE
	// Add new car to the ArrayList
	public void addCar(Car carObj) {
		carList.add(carObj); // add car to carList
	}

	// Update car details
	public void updateCar(String update) {
		System.out.println("\nPlease provide new information or amend the details:"
				+ "\n-------------------------------------------------------------");
		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getReg().equalsIgnoreCase(update)) {// find car
																	// by number
																	// plate
				carList.get(i).askCar("");// overwrite required information
				System.out.println("\nThe car information was updated\n");
			}
		}
	}

	// Move sold car from main list to separate list of sold cars
	public void addToSoldCar(String car) {
		boolean found = false;
		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getReg().equalsIgnoreCase(car)) {
				soldCarList.add(carList.get(i));
				System.out.println("\nThe car: " + carList.remove(i) + " " + "\nis in the sold cars list now\n");
				found = true;
			}
		}
		if (!found) {
			System.out.println("\nCar ***" + car + "*** not found. Please try again...\n");
		}
	}

	// SEARCH/GET INFO
	// Search for specific car in the list
	public Car findCarObj(String numPlate) {
		for (Car n : carList) {
			if (n.getReg().equalsIgnoreCase(numPlate)) {
				return n;
			}
		}
		return null;
	}

	// Find car in the list of cars in stock
	public void findCar(String carNumPlate) {
		boolean found = false;
		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getReg().equalsIgnoreCase(carNumPlate)) {
				System.out.println("\nThe car ***" + carNumPlate + "*** found");
				System.out.println("Car details:");
				System.out.print("------------------------------");
				carList.get(i).printCar2();
				found = true;
			}
		}
		if (!found) {
			System.out.println("Car ***" + carNumPlate + "*** not found. Please try again...\n");
		}
	}

	// Find car in the sold list of cars
	public static void findSoldCar(String carNumPlate) {
		boolean found = false;
		for (int i = 0; i < soldCarList.size(); i++) {
			if (soldCarList.get(i).getReg().equalsIgnoreCase(carNumPlate)) {
				System.out.println("\nThe car ***" + carNumPlate + "*** found");
				System.out.println("Car details:");
				System.out.print("------------------------------");
				soldCarList.get(i).printCar2();
				found = true;
			}
		}
		if (!found) {
			System.out.println("\nThe Car ***" + carNumPlate + "*** Not Found. Please try again...\n");

		}
	}

	// Obtain number of car objects currently in the list
	public int getSize() {
		return carList.size();
	}

	// DISPLAY
	// All details of all cars including number plate model and mileage (main
	// list)
	public void details() {
		System.out.println("|NumberPlate       |Make/Model        |Colour	    	 |Mileage   |");
		System.out.println("---------------------------------------------------------------------");
		for (Car c : carList) {
			c.printCar();
		}
		System.out.println("\n\n");
	}

	// This method will be used to show all sold cars list (second list)
	public static void showSoldList() {
		System.out.println("|NumberPlate       |Model             |Colour  	    	 |Mileage   |");// header
		System.out.println("---------------------------------------------------------------------");
		for (Car carobj : soldCarList) {
			carobj.printCar();
		}
		System.out.println("\n\n");
	}

	// DELETE/REMOVE
	// Remove specific car by entering number plate
	public void removeCar(String numplate) {
		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getReg().equalsIgnoreCase(numplate)) {
				System.out.println("\nThe car: " + carList.remove(i) + " was removed\n");
			}
		}
	}

	// Overloaded remove method accepts OBJECTS as parameter
	public void removeCar(Car c) {
		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).equals(c)) {
				carList.remove(i);
			}
		}
	}
}
