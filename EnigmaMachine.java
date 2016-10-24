
public class EnigmaMachine {
	
	private Rotor lrotor;
	private Rotor mrotor;
	private Rotor rrotor;
	private Reflector reflector;
	
	// CONSTRUCTOR
	public EnigmaMachine(Rotor lrotor, Rotor mrotor, Rotor rrotor, Reflector reflector) {
		
		this.lrotor = lrotor;
		this.mrotor = mrotor;
		this.rrotor = rrotor;
		this.reflector = reflector;
	} // END OF CONSTRUCTOR
	
	public char getEncodedChar(char c) {
		
		if (Character.isLetter(c)) {
			
			c = Character.toUpperCase(c);
		} else {
			
			throw new IllegalArgumentException("The character is not a letter!");
		}
		

		int characterIndex = EnigmaConstants.PLAINTEXT.indexOf(c);

		incrementRotors(lrotor, mrotor, rrotor);
		characterIndex = rrotor.getEncodedChar(0, characterIndex);
		characterIndex = mrotor.getEncodedChar(0, characterIndex);
		characterIndex = lrotor.getEncodedChar(0, characterIndex);
		characterIndex = reflector.getEncodedChar(characterIndex);
		characterIndex = lrotor.getEncodedChar(1, characterIndex);
		characterIndex = mrotor.getEncodedChar(1, characterIndex);
		characterIndex = rrotor.getEncodedChar(1, characterIndex);
		
		c = EnigmaConstants.PLAINTEXT.charAt(characterIndex);
		return c;
	}
	
	public void incrementRotors(Rotor lrotor, Rotor mrotor, Rotor rrotor) {
		
		if(rrotor.getWheelPosition() == rrotor.getNotchPosition()) {
			
			if(mrotor.getWheelPosition() == mrotor.getNotchPosition()) {
				
				lrotor.incrementWheelPosition();
			}
			
			mrotor.incrementWheelPosition();
		}
		rrotor.incrementWheelPosition();
	}
	
	
} // END OF EnigmaMachine CLASS
