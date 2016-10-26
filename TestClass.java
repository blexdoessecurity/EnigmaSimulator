
public class TestClass {

	public static void main(String[] args) {
		
		EnigmaMachine enig = new EnigmaMachine(new Rotor(EnigmaConstants.ROTORI, 'L', 'V', EnigmaConstants.NOTCHI), 
				new Rotor(EnigmaConstants.ROTORII, 'F', 'H', EnigmaConstants.NOTCHII), 
				new Rotor(EnigmaConstants.ROTORIII, 'J', 'N', EnigmaConstants.NOTCHIII), 
				new Reflector(EnigmaConstants.BTYPE),
				new Plugboard("AJ;FH;SY;DP;ZX"));
		
		//System.out.println(enig.getEncodedChar('A'));
		
		String test = "QXPVBXSWPJCSRWBBSGNSZIB";
		String output = "";
		for(int i = 0; i < test.length();i++) {
			
			output += enig.getEncodedChar(test.charAt(i));
		}
		
		System.out.println(output);

	} // END OF main METHOD

} // END OF TestClass METHOD
