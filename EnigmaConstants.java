
public abstract class EnigmaConstants {
	
	public static final String PLAINTEXT = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	// ROTOR I settings
	public static final String ROTORI = " EKMFLGDQVZNTOWYHXUSPAIBRCJ";
	public static final char NOTCHI = 'Q';
	
	// ROTOR II settings
	public static final String ROTORII = " AJDKSIRUXBLHWTMCQGZNPYFVOE";
	public static final char NOTCHII = 'E';
	
	// ROTOR III settings
	public static final String ROTORIII = " BDFHJLCPRTXVZNYEIWGAKMUSQO";
	public static final char NOTCHIII = 'V';
	
	// REFLECTORS
	public static final String BTYPE = " YRUHQSLDPXNGOKMIEBFZCWVJAT";
	public static final String CTYPE = " FVPJIAOYEDRZXWGCTKUQSBNMHL";
	
	// Returns the index of the char regarding the PLAINTEXT string
	public static int getCharIndex(char c) {
		
		if(!Character.isLetter(c)) {
			
			throw new IllegalArgumentException("The character is not a letter!");
		}
		
		int charIndex = PLAINTEXT.indexOf(c);
		
		return charIndex;
	}
}
