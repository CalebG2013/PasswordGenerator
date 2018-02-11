import java.util.ArrayList;
import java.util.Random;



public class Password {
/**
 * @summary
 */

	private int passwordLength;
	private boolean symbols;
	private boolean capitals;
	private boolean lower;
	

	private ArrayList<Integer> placeholderList;
	
	private StringBuilder finalPassword = new StringBuilder();
	
	
	/**
	 * 
	 * @return  returns the final created password 
	 */
	public StringBuilder getFinalPassword(){
		return this.finalPassword;
	}
	/**
	 * 
	 * @param pass sets the final password
	 */
	public void SetfinalPasssword(StringBuilder pass){
		this.finalPassword = pass;
	}
	
	
	
	Password() {
		this.passwordLength = 5;
	}

	/**
	 * @return the boolean that determines if there are lowercase letters included in
	 * the password
	 */
	public boolean isLower() {
		return lower;
	}

	/**
	 * @param Sets if there are going to be lower case letters included
	 */
	public void setLower(boolean lower) {
		this.lower = lower;
	}

	



	/**
	 * @return the passwordLength
	 */
	public int getPasswordLength() {
		return passwordLength;
	}

	/**
	 * @param passwordLength
	 *            the passwordLength to set
	 */
	public void setPasswordLength(int passwordLength) {
		this.passwordLength = passwordLength;
	}

	/**
	 * @return the symbols
	 */
	public boolean isSymbols() {
		return symbols;
	}

	/**
	 * @param symbols
	 *            the symbols to set
	 */
	public void setSymbols(boolean symbols) {
		this.symbols = symbols;
	}

	/**
	 * @return the capitals
	 */
	public boolean isCapitals() {
		return capitals;
	}

	/**
	 * @param capitals
	 *            the capitals to set
	 */
	public void setCapitals(boolean capitals) {
		this.capitals = capitals;
	}

	// rand.nextInt((max - min) + 1) + min;
	
	/**
	 * @summary creates place holder numbers to represent the final password. 
	 * length is dependent on the sent length
	 *  1=Cap 2=Numbers 3=Symbols 4=Lowercase letters
	 * 
	 */
	public void generatePlaceholders() {
		int i = 0;

		StringBuilder s = new StringBuilder();
		placeholderList = new ArrayList<Integer>();

		/**
		 * @summary conditions represent options available. options are uppercase, lowercase, and symbols.
		 */
		while (i < passwordLength) {

			if (symbols == true && capitals == true && lower == true) {
				Random rand = new Random();
				int random = rand.nextInt(5-1) + 1;
				placeholderList.add(random);
				i++;

				if (placeholderList.size() == passwordLength  && checkForLowerCapAndSym() == false) {
					placeholderList.clear();
					i = 0;
				}
			}

			else if (symbols == true && capitals == true && lower == false) {
				Random rand = new Random();
				int random = rand.nextInt(4) + 1;
				placeholderList.add(random);
				i++;

				if (placeholderList.size() == passwordLength && checkForLowerCapAndSym() == false) {
					placeholderList.clear();
					i = 0;
				
				}
			}

			else if (symbols == true && capitals == false && lower == true) {
				Random rand = new Random();

				int random = rand.nextInt(4-2) + 2;
				placeholderList.add(random);
				i++;
				if (placeholderList.size() == passwordLength && checkForSym() == false) {
					placeholderList.clear();
					i = 0;
				}
			}
			else if (symbols == false && capitals == true && lower == true) {
				// need 1, 4, 2
				Random rand = new Random();
				
				int random = rand.nextInt(4 - 1) + 1;
				System.out.print(random);
				if (random == 3) {
					random = 4;
				}
				
				placeholderList.add(random);
				i++;

				if ((placeholderList.size() == passwordLength == true) && (checkForCap()==false || checkForLower()==false)) {
					
					placeholderList.clear();
					i = 0;
				}
			}

			else if (this.isSymbols() == false && this.isCapitals() == false && lower == true) {
				// need 2-num, 4-lower
				Random rand = new Random();
				int random = rand.nextInt(3 - 1) + 1;
				System.out.print(random);
				if (random == 1) {
					random = 4;
				}

				placeholderList.add(random);
				i++;
				if (placeholderList.size() == passwordLength && checkForLower() == false) {
					placeholderList.clear();
					i = 0;
				}

			}
			
			else if (symbols == false && capitals == true && lower == false){
				Random rand = new Random();
				int random = rand.nextInt(3- 1) + 1;
				System.out.print(random);
				
				placeholderList.add(random);
				i++;
				
				if (placeholderList.size() == passwordLength && checkForCap() == false) {
					placeholderList.clear();
					i = 0;
				}
			}
			
			else if (symbols == true && capitals == false && lower == false){
				//need 2-num, 3-sym
				Random rand = new Random();
				int random = rand.nextInt(4- 2) + 2;
				System.out.print(random);
				
				placeholderList.add(random);
				i++;
				
				if (placeholderList.size() == passwordLength && checkForSym() == false) {
					placeholderList.clear();
					i = 0;
				}
			}

			else{
				placeholderList.add(2);
				i++;}
			
		}
		System.out.print(placeholderList);

		// return 1;
	}

	// 1=Cap 2=numbers 3=symbols 4=lower
	private boolean checkForLowerCapAndSym() {
		if (placeholderList.contains(1) == true && placeholderList.contains(2) == true && placeholderList.contains(3) == true
				&& placeholderList.contains(4) == true) {
			return true;
		} else

			return false;

	}

	private boolean checkForCap() {
		if (placeholderList.contains(1) && placeholderList.contains(2)) {
			return true;
		} else
			return false;
	}

	private boolean checkForSym() {
		if (placeholderList.contains(2) && placeholderList.contains(3)) {
			return true;
		}
		return false;

	}

	private boolean checkForLower() {
		if (placeholderList.contains(2) && placeholderList.contains(4)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 */
	public void convertToPassword() {
		int i = 0;
		while (i < passwordLength) {
			if (placeholderList.get(i) == 1) {
				// generate random capital letter and append it to Stringbuilder
				// placeholderList
				Random rand = new Random();
				int random = rand.nextInt(91-65)+65;
				char c = (char)random;
				finalPassword.append(c);
				i++;
				
				
			}
		
			else	if (placeholderList.get(i) == 2) {
				// generate random number and append to finalList

				Random rand = new Random();
				int random = rand.nextInt(10-0)+0;
						finalPassword.append(random);
						i++;
			}
			
			else if (placeholderList.get(i) == 3) {
				// generate random symbol and add it to finalList
				Random rand = new Random();
				int random = rand.nextInt(48-33)+33;
				char c = (char)random;
				finalPassword.append(c);
				i++;
			}
			
			else if (placeholderList.get(i) == 4){
				//generate lower case and add it to finalList 97 -122
				Random rand = new Random();
				int random = rand.nextInt(123-97)+97;
				char c = (char)random;
				finalPassword.append(c);
			i++;
			}
		}

	}

}
