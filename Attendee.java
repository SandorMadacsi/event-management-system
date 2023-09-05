import java.io.Serializable;
public class Attendee implements Serializable{

	private int id;
	private String name;
	private String phone;
	private String email;


	public Attendee(String name, String phone, String email){

		this.name = name;
		this.phone = phone;
		this.email = email;

	}

	public void setId(int id){

		this.id = id;

	}

	public void setName(String name){

		this.name = name;

	}

	public void setPhone(String phone){

		this.phone = phone;

	}

	public void setEmail(String email){

		this.email = email;

	}

	public int getId(){

		return this.id;

	}

	public String getName(){

		return this.name;

	}

	public String getPhone(){

		return this.phone;

	}

	public String getEmail(){

		return this.email;

	}

	@Override
	public String toString(){

		String id = this.getId() + ")";
		String name = "Name: " + this.getName();
		String phone = "Phone: " + this.getPhone();
		String email  = "Email: " + this.getEmail();
		return id + " | " + name + " | " + phone + " | " + email;
		
	}

}