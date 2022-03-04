package _01_TestMatchingBrackets;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	boolean returned = false;
    	int matchCount = 0;
    	for (int i = b.length(); i > 0; i--) {
    		if ((b.charAt(i) == '{')&&(b.charAt(i++) == '}')) {
			}
				
    	
    	}
    	if (matchCount == 0) {
			returned = true;
		}
        return returned;
    }
}