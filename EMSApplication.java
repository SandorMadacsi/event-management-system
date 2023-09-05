

class EMSApplication{

	public EMSApplication(){

	}
	
	public static void main(String []args){

		//database contains arraylist of events
		System.out.println(" Event Management System Application");
		System.out.println("================== By Sandor Madacsi");
		Database d = new Database("events");

		CLI c = new CLI();
	
		// menu is running in a while loop with command line interface object 
		do{
			c.menuLogic(d);
		}
		//get state checks if the program was terminated
		while(c.getState());
		
	}


}