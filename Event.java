import java.util.List;
import java.util.LinkedList;
import java.io.Serializable;

public class Event implements Serializable{

	private int id;
	private String name;
	private String type;
	private List<Attendee> attendees;
	private String description;


	public Event(String name, String type, String description){

		this.name = name;
		this.type = type;
		this.description = description;
		this.attendees = new LinkedList<>();

	}

	public void setId(int id){

		this.id = id;

	}

	public int getId(){

		return this.id;

	}

	public void setName(String name){

		this.name = name;

	}

	public void setType(String type){

		this.type = type;

	}

	public void setDescription(String description){

		this.description = description;

	}

	public String getName(){

		return this.name;

	}

	public String getType(){

		return this.type;

	}

	public String getDescription(){

		return this.description;

	}

	@Override
	public String toString(){

		String id = this.getId() + ")";
		String name = "Event name: " + this.getName();
		String type = "Event type: " + this.getType();
		String description = "Event description: " + this.getDescription();
		String breakLine = "=================================";
		return id + "\n" +  name + "\n" + type + "\n" + description + "\n" + breakLine;
	
	}

	public void printAllAttendees(){

		for(Attendee a : this.attendees){

			int id = this.attendees.indexOf(a);
			a.setId(id);
			System.out.println(a);

		}

	}

	public void add(Attendee a){

		this.attendees.add(a);
		int id = this.attendees.indexOf(a);
		a.setId(id);
		
	}
		

	public void delete(int i){

		this.attendees.remove(this.attendees.get(i));
		
	}

	public int getSize(){

		return this.attendees.size();

	}

}