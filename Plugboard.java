
public class Plugboard {
	
	private int[] plugboardConfig; // This array will keep the plugboardConfig
	public Plugboard(String plugboardConfig) {
		
		this.plugboardConfig = new int[27]; // we want to start from 1 and end with 26
		for(int i = 1; i < this.plugboardConfig.length; i++) {
			
			// Initially every letter is plugged to itself
			this.plugboardConfig[i] = i;
		}
		
		// The string for the plugboard will come in the form LL;LL
		String[] auxStrings = plugboardConfig.split(";");
		// For every pair of letters we change the plugboardConfig
		for(int j = 0; j < auxStrings.length; j++) {
			
			String auxString = auxStrings[j];
			int firstIndex = EnigmaConstants.PLAINTEXT.indexOf(auxString.charAt(0));
			int secondIndex = EnigmaConstants.PLAINTEXT.indexOf(auxString.charAt(1));
			
			// But first we check if the letters are not plugged to other letters
			validatePlugboardConfig(firstIndex, secondIndex);
			this.plugboardConfig[firstIndex] = secondIndex;
			this.plugboardConfig[secondIndex] = firstIndex;
		}
		
	} // END OF CONSTRUCTOR

	public int getEncodedChar(int number) {
		
		return plugboardConfig[number];
	} // END OF getEncodedChar METHOD
	
	public void validatePlugboardConfig(int firstIndex, int secondIndex) {
		
		if(plugboardConfig[firstIndex] != firstIndex || plugboardConfig[secondIndex] != secondIndex) {
			
			throw new IllegalArgumentException("You already specified a plugboard setting for one of the letters");
		}
	} // END OF validatePlugboardConfig METHOD
	
} // END OF Plugboard CLASS
