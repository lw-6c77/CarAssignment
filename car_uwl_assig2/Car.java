package car_uwl_assig2;

import java.util.Scanner;

public class Car {
	// fields
	// mileage set to String as no arithmetic operations are required in this
	// application
	private String registrationNumber, carModel, carColor, mileage;
	private Scanner inp;

	// default, parameterless Constructor
	public Car() {
		registrationNumber = "??????";
		carModel = "Unknown";
		carColor = "Unknown";
		mileage = "Unknown";
	}

	// parameterised Constructor
	public Car(String numberPlate, String model, String color, String mileage) {
		this.registrationNumber = numberPlate;
		this.carModel = model;
		this.carColor = color;
		this.mileage = mileage;
	}

	// SETTERS
	public void setReg(String numPlate) {
		// white spaces and accepted due to  personalised
		// number plates having spaces in-between
		while (!numPlate.matches("[a-zA-Z0-9 ]{1,7}+")) {//(letters digits space) no spec.chars
			System.out.println(
					"\nData Entry Error: no input or illegal characters typed." + "\nMax length: 7 characters accepted."
							+ "\nRegistration number example: RG56LWX, K832DRG . Please try again...\n");
			System.out.print("Enter number plate: \n|>");
			numPlate = inp.nextLine(); //set number plate if condition is met
		}
		registrationNumber = numPlate;
	}
  // min = 1 char, max =17 chars, alphanumeric input accepted. No special chars except
  // space and hyphen.
	public void setModel(String aModel) {
		while (!aModel.matches("[a-zA-Z0-9 -]{1,17}+")) { //(letters digits space) no spec.chars
			System.out.println("\nData Entry Error: no input or illegal characters typed."
					+ "\nMax length: 17 characters accepted. Please try again...\n");
			System.out.print("Enter model: \n|>");
			aModel = inp.nextLine();
		}
		carModel = aModel; // //set car model if condition is met
	}

	public void setCarColor(String carColor) {
		while (!carColor.matches("[a-zA-Z0-9 -]{1,17}+")) {// as in setModel()
															// method
			System.out.println("\nData Entry Error: no input or illegal characters typed."
					+ "\nMax length: 17 characters accepted. Please try again...\n");
			System.out.print("Enter colour: \n|>");
			carColor = inp.nextLine();
		}
		this.carColor = carColor; //set colour if condition is met
	}

	public void setMileage(String carMileage) {
		mileage = carMileage; 
	}

	// GETTERS
	public String getReg() {
		return registrationNumber;
	}

	public String getModel() {
		return carModel;
	}

	public String getMileage() {
		return mileage;
	}

	public String getCarColor() {
		return carColor;
	}

	// This method prompts user to enter details of the car
	public void askCar(String addCar) {
		System.out.println(addCar);
		
		// REGISTRATION
		System.out.print("Enter number plate: \n|>");
		inp = new Scanner(System.in);
		setReg(inp.nextLine().toUpperCase());
		
		// MODEL
		System.out.print("\nEnter make and model: \n|>");
		setModel(inp.nextLine().toUpperCase());
		
		// COLOR
		System.out.print("\nEnter colour: \n|>");
		setCarColor(inp.nextLine().toUpperCase());
		
		// MILEAGE - USER INPUT VALIDATED
		System.out.print("\nEnter mileage: \n|>");
		
		// reject input if does not match requirements(digits only, at least one
		// no more than ten, no special chars or white space allowed)
		String mileage = inp.nextLine();
		while (!mileage.matches("[0-9]{1,10}+")) {//continue to check user input until condition is met by the ReGex rule
			System.out.println("\nData Entry Error: no input, " + "special characters or alphanumerics detected."
					+ "\nEnter digits only. Maximum digits allowed: 10\n");
			System.out.print("Enter mileage: \n|>");
			mileage = inp.nextLine(); //read the user input
		}
		setMileage(mileage);
	}
	
	// This method will be used to display car stock
	public void printCar() {
		System.out.printf("|%18s|%18s|%18s|%10s|\n", this.registrationNumber, this.carModel, this.carColor,
				this.mileage);
	}

	// This method will provide alternative display of the car details
	public void printCar2() {
		System.out.printf("\n|NumberPlate---|%s", registrationNumber);
		System.out.printf("\n|Model:--------|%s", carModel);
		System.out.printf("\n|Colour--------|%s", carColor);
		System.out.printf("\n|Mileage-------|%s", mileage);
		System.out.println();
	}

	// This method when called will display user commands
	public static void helpMenu() {
		System.out.println("\n\n\n\t\t\t***DESCRIPTION OF USER COMMANDS***:\n\n");
		System.out.println("ADD/REMOVE/SELL CAR:\n" + "A - Add new car. "
				+ "Type in number plate, car model, \n    colour and mileage when prompted."
				+ "\nU - Update car information or amend some details."
				+ "\nR - Remove car from stock by typing number plate."
				+ "\nS - Move car from existing stock to sold cars list."

				+ "\n\nSEARCHING FOR CAR DETAILS:"
				+ "\nI - Stock details. Display details of ALL cars currently held in stock."
				+ "\nSLD - Show details of sold cars." + "\nF - Find specific car in stock by typing number plate."
				+ "\nFS - Find specific car in sold cars list."
				+ "\nTIS - Show total number of cars currently held in stock." + "\nTS - Total number of sold cars."

				+ "\n\nHELP/EXIT" + "\nH - Display help options." + "\nE - Exit an application.\n");
	}

	@Override
	// toString method is to return String representation of the objects
	public String toString() {
		return "Number Plate: " + this.registrationNumber + ", Car model: " + this.carModel + ", Mileage: "
				+ this.mileage;
	}
}
