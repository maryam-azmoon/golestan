package adminview;

public class Validation {
	public static boolean checkTextFieldString(String input) {

		return input.matches("[a-zA-Z]+");
	}

	public static boolean checkTextFieldNumber(String input) {

		return input.matches("[0-9]+");
	}
	public static boolean checkPhonePattern(String input){
		return input.matches("^[0-9]{3}-[0-9]{8}");
	}
	
	public static boolean checkEmailPattern(String input){
		return input.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}");
	}

	public static boolean checkTextFieldEmpty(String input) {
		return !input.equals("");
	}

	public static boolean checkLenghtTextField(String input) {
		return input.length() < 5;
	}

	public static boolean checkInputLenghtTextField(String input) {
		return input.length() == 8;
	}

}
