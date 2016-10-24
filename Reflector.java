
public class Reflector {
	
	private String reflectorConfig;
	
	// Constructor
	public Reflector(String reflectorConfig) {
		
		this.reflectorConfig = reflectorConfig;
	} // END OF CONSTRUCTOR

	public int getEncodedChar(int number) {
		
		char c = reflectorConfig.charAt(number);
		number = EnigmaConstants.PLAINTEXT.indexOf(c);
		
		return number;
	} // END OF getEncodedChar METHOD
} // END OF Reflector CLASS
