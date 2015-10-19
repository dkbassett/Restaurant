package gui;

public abstract class Validator {

	public static boolean isType(String input, String type){
		try {
			if (type.equalsIgnoreCase("float")) {
				Float.parseFloat(input);
			} else if (type.equalsIgnoreCase("int")) {
				Integer.parseInt(input);
			} else if (type.equalsIgnoreCase("double")) {
				Double.parseDouble(input);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
