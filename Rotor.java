
public class Rotor {
	
	private String rotorConfig;
	private int wheelPosition;
	private int notchPosition;
	private int ringSetting;
	
	public Rotor (String rotorConfig, char wheelPosition, char ringSetting, char notchPosition) {
		
		// The rotor configuration is constant for every type of rotor and is a string
		this.rotorConfig = rotorConfig;
		
		this.wheelPosition = EnigmaConstants.getCharIndex(wheelPosition);
		this.notchPosition = EnigmaConstants.getCharIndex(notchPosition);
		this.ringSetting = EnigmaConstants.getCharIndex(ringSetting);
	} // END OF CONSTRUCTOR

	public int getEncodedChar(int dir, int number) {
		
		// We subtract from our number index the ringstellung
		// because it rotates counter-clockwise (looking from right)
		// Then we normalise the number (put it between 1 and 26)
		number = number - ringSetting;
		number = normaliseNumber(number);
		
		// We add the grundstellung to the index
		// because it rotates clockwise (looking from right)
		// Then we normalise the number
		number = number + wheelPosition;
		number = normaliseNumber(number);
		
		// dir = 0 means R->L
		// dir = 1 means L->R
		if(dir == 0) {
			
			char c = rotorConfig.charAt(number);
			number = EnigmaConstants.PLAINTEXT.indexOf(c);
		} else {
			
			char c = EnigmaConstants.PLAINTEXT.charAt(number);
			number = rotorConfig.indexOf(c);
		}
		
		// We do the inverse of our opperations to obtain the character
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
