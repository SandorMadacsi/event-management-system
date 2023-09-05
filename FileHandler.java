import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;


public class FileHandler{

	public FileHandler(){

	}

	// Gets a list of events and writes each object into a file
    public void writeObjectToFile(String filepath, List<Event> events) {
    	 FileOutputStream os = null;
    	ObjectOutputStream oos = null;
    try {
        os = new FileOutputStream(filepath);
        oos = new ObjectOutputStream(os);
    	for(Event ev : events)
    	{

        oos.writeObject(ev);	
    	}
        
        System.out.println("The Object was succesfully written to a file");

    }
    catch (Exception e) {
        System.out.println(e);
    }
    finally{
		try{
			oos.close();
			os.close();	
		}
		catch(IOException e){
			System.out.println(e);
		}	
    }
}

	// Reads stored events from file and returns an arrayList of events
	// 
	public static List<Event> readObjectFromFile(String filepath)
	{
		FileInputStream is = null;
		ObjectInputStream ois = null;
		List<Event> events = new ArrayList<>();
		try{
			is = new FileInputStream(filepath);
			ois = new ObjectInputStream(is); 
			while (true) {
			  try{
			    Event ev =  (Event) ois.readObject();

			    if (ev != null) {
			      events.add(ev);
			    }
			  }
				
			  catch(IOException e){
			  	System.out.println("=Events successfully read from file=");
			  	System.out.println("||||||||||||||||||||||||||||||||||||");
			  	break;
			  }
			}
		 }
		 catch (FileNotFoundException e) {
		    System.out.println("File not found");
		 }
		 catch (ClassNotFoundException e) {
		    System.out.println(e);
		 }
		 catch (IOException e) {
		    System.out.println(e);
		 }
		finally{
			try{
				if(ois != null || is != null)
				{
					ois.close();
					is.close();
				}
	
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not found");
			}
			catch(IOException e){
				System.out.println(e);
			}	
		}

		 return events;
	}

}