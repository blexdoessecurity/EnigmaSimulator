
public class TestClass {

	public static void main(String[] args) {
		
		EnigmaMachine enig = new EnigmaMachine(new Rotor(EnigmaConstants.ROTORI, 'L', 'V', EnigmaConstants.NOTCHI), 
				new Rotor(EnigmaConstants.ROTORII, 'F', 'H', EnigmaConstants.NOTCHII), 
				new Rotor(EnigmaConstants.ROTORIII, 'J', 'N', EnigmaConstants.NOTCHIII), 
				new Reflector(EnigmaConstants.BTYPE));
		
		
		//System.out.println(enig.getEncodedChar('A'));
		
		String test = "LZDPBOYLDACYJRVWTNQSAJ";
		String output = "";
		for(int i = 0; i < test.length();i++) {
			
			output += enig.getEncodedChar(test.charAt(i));
		}
		
		System.out.println(output);

	} // END OF main METHOD

} // END OF TestClass METHOD
