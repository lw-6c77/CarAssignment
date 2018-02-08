package car_uwl_assig2;

public class CarTest {
	public static void main(String[] args) {
		// INSTANTIATE CAR OBJECT WITH DEFAULT CONSTRUCTOR
		Car carobj1 = new Car();
		System.out.println("#Test_1: Instantiating first car object using default constructor:");
		carobj1.printCar(); // freshly created carobj1 with default constructor

		// TESTING SETTERS
		// carobj1 changes default values for those provided by setter methods
		System.out.println("\n\n#Test_2: Setter methods printCar() printCar2() in action: ");
		carobj1.setReg("x117eaa");
		carobj1.setModel("vw");
		carobj1.setCarColor("red");
		carobj1.setMileage("178567");
		
		// carobj1 should now display values changed to those provided by setter
		// methods
		System.out.println("-printCar() method: \n-------------------"); 
		carobj1.printCar();
		System.out.print("\n-printCar2() method:\n--------------------"); 
		carobj1.printCar2();

		// TESTING ask() METHOD
		// once more we change carobj1 values these time testing askCar() method.
		carobj1.askCar("\n\n#Test_3  Testing ask() method: ");

		// TESTING GETTERS
		System.out.println("\n\n#Test_4  Getter methods: ");
		System.out.println("Registration: " + carobj1.getReg());
		System.out.println("Model: " + carobj1.getModel());
		System.out.println("Colour: " + carobj1.getCarColor());
		System.out.println("Mileage: " + carobj1.getMileage());

		// TESTING toString METHOD
		System.out.println("\n\n#Test_5 toString() method");
		System.out.println(carobj1.toString());

		// INSTANTIATE SECOND CAR OBJECT WITH PARAMETERISED CONSTRUCTOR
		System.out.println("\n\n#Test_6  Testing parameterised constructor: ");
		Car carobj2 = new Car("RN17WXL", "Audi A6", "blue", "178656");
		carobj2.printCar();

		// TESTING getHelp() METHOD
		System.out.println("\n\n#Test7: Help Menu");
		Car.helpMenu();
	}
}
