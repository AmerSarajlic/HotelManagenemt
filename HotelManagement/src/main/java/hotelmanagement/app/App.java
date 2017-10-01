package hotelmanagement.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import hotelmanagement.dao.CustomersDAOImplementation;
import hotelmanagement.dao.EmployesDAOImplementation;
import hotelmanagement.dao.RoomsDAOImplementation;
import hotelmanagement.dao.ServicesDAOImplementation;
import hotelmanagement.data.Customers;
import hotelmanagement.data.Employes;
import hotelmanagement.data.Rooms;
import hotelmanagement.data.Services;

/**
 * Just simple app funcionality. Soon this application will be switched to web
 * app
 * 
 * @author amer
 *
 */

public class App {

	public static CustomersDAOImplementation cdi = new CustomersDAOImplementation();
	public static RoomsDAOImplementation rdi = new RoomsDAOImplementation();
	public static ServicesDAOImplementation sdi = new ServicesDAOImplementation();
	public static EmployesDAOImplementation edi = new EmployesDAOImplementation();
	public static Employes employee = new Employes();
	public static Customers customer = new Customers();
	public static Services service = new Services();
	public static Rooms room = new Rooms();
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		boolean on = true;
		while (on) {
			System.out.print("!!! HOTEL MANAGEMENT !!!");
			System.out
					.print("\n\n1. Customer app\n2. Rooms app\n3. Services app\n4. Employee app\n\nInsert option: ");
			int option = input.nextInt();

			switch (option) {
			case 1:
				customerApp();
				break;
			case 2:
				roomsApp();
				break;
			case 3:
				servicesApp();
				break;
			case 4:
				employeeApp();
				break;

			default:
				break;
			}
		}
	}

	/**
	 * Part of app that allows to manipulate with services
	 */
	private static void employeeApp() {
		System.out.println("\nEMPLOYES APP\n\n1. Add employee\n2. Remove employee\n3. Show all employes\n4. Back");

		boolean on = true;

		while (on) {
			System.out.print("Insert your option: ");

			int option = input.nextInt();

			switch (option) {
			case 1:
				addEmployee();
				employeeApp();
				break;
			case 2:
				removeEmployee();
				employeeApp();
				break;
			case 3:
				showAllEmployes();
				employeeApp();
				break;
			case 4:
				on = false;
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Showing all employee
	 */
	private static void showAllEmployes() {

		List<Employes> employee = edi.displayAllEmployess();

		for (Employes employes : employee) {
			System.out.println("First Name: " + employes.getFirstName() + " Last Name: " + employes.getLastName()
					+ " Position: " + employes.getPosition() + " Salary: " + employes.getSalary());
		}
	}

	/**
	 * Removing employee
	 */
	private static void removeEmployee() {

		System.out.print("Insert employee first name: ");
		String firstName = input.next();

		System.out.print("Insert employee last name: ");
		String lastName = input.next();

		edi.removeEmployee(firstName, lastName);

	}

	/**
	 * Adding new employee
	 */
	private static void addEmployee() {

		System.out.print("Insert employee first name: ");
		String firstName = input.next();

		System.out.print("Insert employee last name: ");
		String lastName = input.next();

		System.out.print("Insert employee position: ");
		String position = input.next();

		System.out.print("Insert employee salary: ");
		int salary = input.nextInt();

		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setPosition(position);
		employee.setSalary(salary);

		edi.addEmployee(employee);

	}

	/**
	 * Part of app that allows to manipulate with services
	 */
	private static void servicesApp() {
		System.out.println("\nSERVICES APP\n\n1. Add service\n2. Remove service\n3. Show all services\n4. Back");

		boolean on = true;

		while (on) {
			System.out.print("Insert your option: ");

			int option = input.nextInt();

			switch (option) {
			case 1:
				addService();
				servicesApp();
				break;
			case 2:
				removeService();
				servicesApp();
				break;
			case 3:
				showAllServices();
				servicesApp();
				break;
			case 4:
				on = false;
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Displaying all services
	 */
	private static void showAllServices() {
		List<Services> services = sdi.displayAllServices();

		for (Services services2 : services) {
			System.out.println("Type: " + services2.getServiceName() + " Price: " + services2.getServicePrice());
		}
	}

	/**
	 * Removing services
	 */
	private static void removeService() {
		showAllServices();

		System.out.print("Insert name of the service that you want to remove: ");
		String serviceName = input.next();

		if (sdi.removeService(serviceName)) {
			System.out.println("Service remover");
		} else {
			System.out.println("Service not removed");
		}
	}

	/**
	 * Adding new services
	 */
	private static void addService() {

		System.out.print("Insert service name: ");
		String serviceName = input.next();

		System.out.print("Insert service price: ");
		int price = input.nextInt();

		service.setServiceName(serviceName);
		service.setServicePrice(price);

		sdi.addService(service);
	}

	/**
	 * Part of app that allows to manipulate with rooms
	 */
	private static void roomsApp() {
		System.out.println("\nROOMS APP\n\n1. Add room\n2. Remove room\n3. Show all rooms\n4. Back");

		boolean on = true;

		while (on) {
			System.out.print("Insert your option: ");

			int option = input.nextInt();

			switch (option) {
			case 1:
				addRoom();
				roomsApp();
				break;
			case 2:
				removeRoom();
				roomsApp();
				break;
			case 3:
				showAllRooms();
				roomsApp();
				break;
			case 4:
				on = false;
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Displaying all rooms (available and not available)
	 */
	private static void showAllRooms() {

		List<Rooms> rooms = rdi.listAllRooms();

		for (Rooms rooms2 : rooms) {
			System.out.println("Room Number: " + rooms2.getRoomNumber() + "Type: " + rooms2.getType() + " Price: "
					+ rooms2.getPrice() + " Avilable: " + rooms2.isAvilable());
		}
	}

	/**
	 * Removing room from database
	 */
	private static void removeRoom() {

		showAllRooms();
		System.out.print("Insert room number that you want to remove: ");
		String roomNumber = input.next();

		if (rdi.removeRoom(roomNumber)) {
			System.out.println("Room remover");
		} else {
			System.out.println("Room not removed");
		}

	}

	/**
	 * Adding new room to database
	 */
	private static void addRoom() {

		System.out.print("Insert room number: ");
		String roomNumber = input.next();

		System.out.print("Insert room type: ");
		String roomType = input.next();

		System.out.print("Insert room price: ");
		int price = input.nextInt();

		room.setPrice(price);
		room.setRoomNumber(roomNumber);
		room.setType(roomType);
		room.setAvilable(true);

		rdi.addRoom(room);

	}

	/**
	 * Simple part of application used by receptionist for registering new
	 * customers, and checking them out.
	 */
	public static void customerApp() {
		System.out.println(
				"\nCUSTOMER APP\n\n1. Add Customer\n2. Search by name\n3. Search by ID number\n4. Check out\n5. Back");

		boolean on = true;

		while (on) {
			System.out.print("Insert your option: ");

			int option = input.nextInt();

			switch (option) {
			case 1:
				addCustomer();
				customerApp();
				break;
			case 2:
				searchByName();
				customerApp();
				break;
			case 3:
				searchByIdNumber();
				customerApp();
				break;
			case 4:
				checkOut();
				customerApp();
				break;
			case 5:
				on = false;
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Searching customers by theire ID card number
	 */
	private static void searchByIdNumber() {

		System.out.print("Insert ID card number: ");
		String idCard = input.next();

		customer = cdi.findCustomerByIdCard(idCard);

		System.out.println(customer);

	}

	/**
	 * Searching customers by their name
	 */
	public static void searchByName() {

		System.out.print("Insert first name: ");
		String firstName = input.next();

		System.out.print("Insert last name:");
		String lastName = input.next();

		customer = cdi.findCustomerByName(firstName, lastName);

		System.out.println(customer);

	}

	/**
	 * Adding new customers
	 */
	public static void addCustomer() {

		System.out.print("Insert customer first name: ");
		String firstName = input.next();

		System.out.print("Insert customer last name: ");
		String lastName = input.next();

		System.out.print("Insert customer ID card number: ");
		String idCard = input.next();

		displayFreeRooms();

		System.out.print("Insert room number for customer: ");
		String roomNumber = input.next();

		room = rdi.getRoom(roomNumber);
		room.setAvilable(false);

		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setIdCard(idCard);
		customer.setDateIn(new Date());
		customer.setRooms(room);

		addServices(customer);

		cdi.addCustomer(customer);
		rdi.updateStatus(roomNumber, false);

	}

	/**
	 * Displaying free rooms for new customers
	 */
	public static void displayFreeRooms() {

		List<Rooms> roomList = rdi.listAllRoomsWithStatus(true);

		for (Rooms rooms : roomList) {
			System.out.println("Room number: " + rooms.getRoomNumber() + ", Room type: " + rooms.getType() + ", Price: "
					+ rooms.getPrice());
		}
	}

	/**
	 * Showing services
	 */
	public static void displayServices() {

		List<Services> servicesList = sdi.displayAllServices();

		for (Services services : servicesList) {
			System.out.println("Name: " + services.getServiceName() + ", Price: " + services.getServicePrice());
		}

	}

	/**
	 * Adding new service to customers
	 * 
	 * @param customer
	 */
	public static void addServices(Customers customer) {

		Services service = new Services();
		List<Services> serviceList = new ArrayList<>();
		List<Services> allServices = sdi.displayAllServices();
		displayServices();

		for (int i = 0; i < allServices.size(); i++) {
			service = allServices.get(i);
			System.out.print(
					"Do you want to add: " + service.getServiceName() + ", as aditional service ? (Enter Y or N)");
			char option = input.next().charAt(0);

			if (option == 'Y') {
				serviceList.add(service);
			}
		}
		customer.setServiceList(serviceList);
	}

	/**
	 * Checking out customers and calculating final bill, and returning room that
	 * they were using to avilable
	 */
	public static void checkOut() {

		System.out.print("Insert customer ID card number: ");
		String idCard = input.next();

		customer = cdi.findCustomerByIdCard(idCard);
		customer.setDateOut(new Date());

		Date dateIn = customer.getDateIn();
		Date dateOut = customer.getDateOut();

		long diff = dateOut.getTime() - dateIn.getTime();
		long diffdays = diff / (60 * 60 * 1000) / 24;

		System.out.println("You have spend " + diffdays + " days in our hotel. ");

		room = customer.getRooms();
		int roomPrice = room.getPrice();

		List<Services> allServices = customer.getServiceList();

		int servicePrice = 0;
		for (Services services : allServices) {
			System.out.println("You have used " + services.getServiceName() + " in our hotel by price of "
					+ services.getServicePrice() + " per day.");
			servicePrice += services.getServicePrice();
		}

		if (diffdays < 1) {
			diffdays = 1;
		}
		customerApp();

		double finalBill = diffdays * (roomPrice + servicePrice);

		System.out.println("Your total bill is: " + finalBill + " €.");

		cdi.setDateOut(customer.getIdCard());
		rdi.updateStatus(room.getRoomNumber(), true);

	}
}
