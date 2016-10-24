
public class Rotor {
	
	private String rotorConfig;
	private int wheelPosition;
	private int notchPosition;
	private int ringSetting;
	
	public Rotor (String rotorConfig, char wheelPosition, char ringSetting, char notchPosition) {
		
		this.rotorConfig = rotorConfig;
		
		if (Character.isLetter(wheelPosition)) {
			
			wheelPosition = Character.toUpperCase(wheelPosition);
			this.wheelPosition = EnigmaConstants.PLAINTEXT.indexOf(wheelPosition);
		} else {
			
			throw new IllegalArgumentException("The character is not a letter!");
		}
		
		if(Character.isLetter(notchPosition)) {
			
			notchPosition = Character.toUpperCase(notchPosition);
			this.notchPosition = EnigmaConstants.PLAINTEXT.indexOf(notchPosition) ;
		} else {
			
			throw new IllegalArgumentException("The character is not a letter!");
		}
		
		if(Character.isLetter(ringSetting)) {
			
			ringSetting = Character.toUpperCase(ringSetting);
			this.ringSetting = EnigmaConstants.PLAINTEXT.indexOf(ringSetting) ;
		}
	} // END OF CONSTRUCTOR

	// dir = 0 means R->L
	// dir = 1 means L->R
	public int getEncodedChar(int dir, int number) {
		
		number = number - ringSetting;
		number = normaliseNumber(number);
		
		number = number + wheelPosition;
		number = normaliseNumber(number);
		if(dir == 0) {
			
			char c = rotorConfig.charAt(number);
			number = EnigmaConstants.PLAINTEXT.indexOf(c);
		} else {
			
			char c = EnigmaConstants.PLAINTEXT.charAt(number);
			number = rotorConfig.indexOf(c);
		}
		number = number - wheelPosition;
		number = normaliseNumber(number);
		
		number = number + ringSetting;
		number = normaliseNumber(number);
		
		return number;
	} // END getEncodedChar METHOD
	
	public int normaliseNumber(int number) {
		
		if (number > 26) {
		
			number = number - 26;
		} else if(number < 1) {
			
			number = 26 + number;
		}
		
		return number;
	} // END OF validateLetterIndex METHOD
	
	public void incrementWheelPosition() {
		
		wheelPosition ++;
		if(wheelPosition > 26) {
			wheelPosition = 1;
		}
	} // END OF incrementWheelPosition METHOD
	
	public int getWheelPosition() {
		
		return wheelPosition;
	} // END OF getWheelPosition METHOD
	
	public int getNotchPosition() {
		
		return notchPosition;
	} // END OF getNotchPosition METHOD
	
} // END OF Rotor CLASS
