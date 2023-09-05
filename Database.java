import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileNotFoundException;

public class Database implements Serializable{

	private	List <Event> events;


	public Database(String filepath){

		//reads all events from file
		this.events = FileHandler.readObjectFromFile(filepath);
		//in case file doesn't exist or empty get some dummy data
		if(this.events.size() == 0)
		{
			Event e1 = new Event("Golf match", "sport", "A nice golf match");
			Event e2 = new Event("Tennis match", "sport", "A football golf match");
			Attendee a1 = new Attendee("Sandor", "08876", "a1@mail.com");
			Attendee a2 = new Attendee("Jim", "08876", "a2@mail.com");
			Attendee a3 = new Attendee("Ed", "08844", "a3@mail.com");
			Attendee a4 = new Attendee("James", "18876", "a4@mail.com");
			e1.add(a1);
			e1.add(a2);
			e2.add(a3);
			e2.add(a4);
			this.events.add(e1);
			this.events.add(e2);
		}
		

	}

	public void add(Event e){

		this.events.add(e);
		int id = this.events.indexOf(e);
		e.setId(id);
		

	}

	public void delete(int i){

		this.events.remove(this.events.get(i));

	}

	public void editName(int i, String s){

			Event e = this.events.get(i);
			e.setName(s);
			this.events.set(i,e);

	}

	public void editType(int i, String s){

			Event e = this.events.get(i);
			e.setType(s);
			this.events.set(i,e);

	}

	public void editDescription(int i, String s){

			Event e = this.events.get(i);
			e.setDescription(s);
			this.events.set(i,e);

	}

	public void printAllEvents(){

		for(Event e : this.events){

			int id = this.events.indexOf(e);
			e.setId(id);
			System.out.println(e);

		}
		
	}

	public Event getOneEvent(int i){
		
		return this.events.get(i);
	}

	public void  writeToFile(){

	FileHandler out = new FileHandler();
	out.writeObjectToFile("events",this.events);
        
	}

	public int getSize(){

		return this.events.size();
	}

}