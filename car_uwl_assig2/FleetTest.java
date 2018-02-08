package car_uwl_assig2;

public class FleetTest {

	public static void main(String[] args) {

		// Object instantiation: Fleet object containing future list of cars
		Fleet listOfCars = new Fleet();
		
		// Object instantiation: four different car objects
		Car c1 = new Car();// One object instantiated with default constructor
		
		// Four objects instantiated with parameterised constructor
		Car c2 = new Car("lg02xwk", "land rover", "red", "45000");
		Car c3 = new Car("gr03jdk", "mazda mx5", "blue", "12045");
		Car c4 = new Car("tn04lua", "audi a3", "green", "34055");
	
		//#Test_1: Adding four cars to the list and Display them.
		System.out.println("#Test_1: Adding four cars to the list. Display them.");
	
		listOfCars.addCar(c1);
		listOfCars.addCar(c2);
		listOfCars.addCar(c3);
		listOfCars.addCar(c4);
		listOfCars.details(); 
	
		// Test_2: Getting number of car objects in the list
		System.out.println("#Test_2: How many cars in stock?\nThe number of the cars in the list: "
				+ "" + listOfCars.getSize()+ "\n");		
		
		// Test_3: Display details of all cars in stock Before removing one of them
		System.out.println("\n#Test_3: Show details of all four cars BEFORE we remove one of them(lg02xwk): ");
		listOfCars.details();// Display objects that ArrayList contain before // remove()

		// --remove second car 
		System.out.println("We remove second(lg02xwk) car. The list should contain only first, third and fourth car");
		listOfCars.removeCar(c2);

		// --display state of the list After
		System.out.println("Print the list AFTER remove operation: ");
		listOfCars.details();// Display objects that ArrayList contain after remove()

		// Test_4: Find a car in stock
		System.out.println("#Test_4: Find car in stock: "); 
		System.out.println("Car found: " + listOfCars.findCarObj("tn04lua"));
	
		// Test_5 Move car to the sold car list
		System.out.print("\n#Test_5: Move car to the sold cars list: "); 
		listOfCars.addToSoldCar("tn04lua");
		
		//Test_6: Find car in sold car list
		System.out.print("#Test_6: Find car in the sold cars list: "); 
		Fleet.findSoldCar("tn04lua");
		
		// Test_7: Show list of sold cars:
		System.out.print("\n\n#Test_7: List of sold cars: \n"); 
		Fleet.showSoldList();
		
		//#Test_8: Update information
		System.out.print("#Test_8: Update car information: "); 
		listOfCars.updateCar("gr03jdk");
		listOfCars.details();
	}
}
