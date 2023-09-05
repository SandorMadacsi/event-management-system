
//Most user inputs are intigers in a defined range so this custom exception is thrown when the input doesnt match the criteria
class WrongInputException extends Exception{

	private int i;
	private String message;


	public WrongInputException(String message, int i){

		super(message);
		this.i = i;

	}

	public int getLine(){

		return this.i;

	}
}