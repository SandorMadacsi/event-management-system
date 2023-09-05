import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CLI{

	 private boolean isRunning;

	public CLI(){

	this.isRunning = true;

	}

	public static void exceptionLoop(int bundary){

}

	public static void displayMenu(){
		System.out.println("=================Menu===============");
		System.out.println("Select from the options below: ");
		System.out.println("====================================");
		System.out.println("1) List all events");
		System.out.println("2) List an individual Event");
		System.out.println("3) Edit an event");
		System.out.println("4) Add an event");
		System.out.println("5) Delete an event");
		System.out.println("6) List attendees attending an event");
		System.out.println("7) Add an attendee to an event");
		System.out.println("8) Delete an attendee from an event");
		System.out.println("0) Terminate program");
		System.out.println("====================================");
	}

	// Display edit options
	public static void displayEditOptions(){
		System.out.println("1) Edit name");
		System.out.println("2) Edit type");
		System.out.println("3) Edit description");
	}

	// Display after action options
	public  void backToMainMenu(Database d){
		System.out.println("1) Back to main menu");
		System.out.println("2) Exit");
		switch(choose("an action",2)){
		case 1:
			break;
		case 2:
			terminate(d);
			break;
		}
	}

	// Responsible for user input and exception handling related to input when user chooses a menu point
	public static int choose(String s, int bundary){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter " + s + ": ");

		while(true){
			try{
				int option = input.nextInt();
				
				if(option > bundary || option < 0)
				{
					WrongInputException e = new WrongInputException("You can only choose from the given options! Try again: ", option);
					throw e;
				}
			return option;
			}
		catch(InputMismatchException exc){
				input.nextLine();
				//System.out.println(exc);
				System.out.println("You can only enter numbers! Try again: ");
				continue;
		}
		catch(WrongInputException exc){

				System.out.println(exc);
				// System.out.println("try again");
				continue;
			}
		}
	}

	// get state of the app
	public boolean getState(){
		return this.isRunning;
	}

	//1. method list all events
	public void printAllEvents(Database d){
		System.out.println("===1) List all Events=======");
		d.printAllEvents();
	}

	//2. method prints one event based on the list of events
	public void printOneEvent(Database d){
		System.out.println("===2) List an individual Event=======");
		d.printAllEvents();
		int choice = 0;
		System.out.println(d.getOneEvent(choose(" an event to list",d.getSize())));
	}

	//3. edits event
	public void editEvent(Database d){
		Scanner input = new Scanner(System.in);
		String newAttribute;
		System.out.println("===3) Edit an event=======");
		d.printAllEvents();
		int index = choose(" an event to edit ", d.getSize());
		displayEditOptions();
		int option = choose(" an attribute to edit", 3);
		switch(option)
		{
			case 1: 
				System.out.println("Input new name: ");
				newAttribute = input.nextLine();
				d.editName(index, newAttribute );
				break;

			case 2: 
				System.out.println("Input new type: ");
				newAttribute = input.nextLine();
				d.editType(index, newAttribute );	
				break;

			case 3: 
				System.out.println("Input new description: ");
				newAttribute = input.nextLine();
				d.editDescription(index, newAttribute );
				break;
		}
		d.printAllEvents();
	}

	
	//4. method delete event
	public void addEvent(Database d)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("===4) Add an Event============");
		d.printAllEvents();
		System.out.println("Add name: ");
		String name = input.nextLine();
		System.out.println("Add type: ");
		String type = input.nextLine();
		System.out.println("Add description: ");
		String description = input.nextLine();
		d.add(new Event(name,type,description));
		System.out.println("Event added");
		d.printAllEvents();

	} 

	//5. method delete event
	public void deleteEvent(Database d){
		System.out.println("===5) Delete an event=======");
		d.printAllEvents();
		d.delete(choose("an event to delete", d.getSize()));
		System.out.println("Event removed");
		d.printAllEvents();
	}

	//6. method list all attendees at a choosen event
	public void listAttendees(Database d){
		System.out.println("===5) List attendees attending an event=======");
		d.printAllEvents();
		Event e =  d.getOneEvent(choose( "an event to list attendees from", d.getSize()));
		System.out.println("List of attendees at " + e);
		e.printAllAttendees();
	}


	//7. method add attendee to a choosen event
	public void addAttendee(Database d)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("===7) Add an attendee to an event=======");

		d.printAllEvents();
		Event ea = d.getOneEvent(choose( "an event to add an attendee to", d.getSize()));
		System.out.println("Add name: ");
		String name = input.nextLine();
		System.out.println("Add phone: ");
		String phone = input.nextLine();
		System.out.println("Add email: ");
		String email = input.nextLine();
		ea.add(new Attendee(name,phone,email));
		System.out.println("Attendee added");
		ea.printAllAttendees();

	}
	//8. method deletes attendee from a choosen event
	public void deleteAttendee(Database d){
		System.out.println("===8) Delete an attendee from an event=======");
		d.printAllEvents();

		Event ed = d.getOneEvent(choose("an event to delete an attendee from", d.getSize()));
		ed.printAllAttendees();
		ed.delete(choose("an index of an attendee to delete", ed.getSize()));
		System.out.println("Attendee deleted");
		ed.printAllAttendees();
	}

	// Switch case to choose from the main menu methods
	public void menuLogic(Database d ){
		
		displayMenu();	
	
		switch(choose(" an option: ", 8)){
			case 1:
				printAllEvents(d);
				backToMainMenu(d);
			break;
			case 2:
				printOneEvent(d);
				backToMainMenu(d);
			break;
			case 3:
				editEvent(d);
				backToMainMenu(d);
			break;
			case 4:
				addEvent(d);
				backToMainMenu(d);
			break;
			case 5:
				deleteEvent(d);
				backToMainMenu(d);
			break;
			case 6:
				listAttendees(d);
				backToMainMenu(d);
			break;
			case 7:
				addAttendee(d);
				backToMainMenu(d);
			break;
			case 8:
				deleteAttendee(d);
				backToMainMenu(d);
			break;
			case 0:
				terminate(d);
			break;	
			default:
				terminate(d);
				break;
		}
	}

	// Terminates app as well as writing all objects to a file
	public void terminate(Database d){

		d.writeToFile();
		this.isRunning = false;
		System.out.println("Thank you for using EMS_app! See you soon and have a wonderful day!");

	}

}