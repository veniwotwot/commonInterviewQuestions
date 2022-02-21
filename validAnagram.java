package commonInterviewQuestions;

//A O(n^2) solution by Vincent Wong
public class validAnagram {

	// Two strings are anagrams if they're made of the same letters with the same
	// frequencies
	public static void main(String[] args) {
		String s1 = "danger";
		String s2 = "garden";

		validAnagram v = new validAnagram();
		v.execute(s1, s2);
		
		String s3 = "nameless";
		String s4 = "salesmen";
		v.execute(s3,s4);
	}

	private void execute(String s1, String s2) {
		boolean valid;
		valid = testValidity(s1, s2);
		System.out.println("S1 and S2 are anagrams: " + valid);
	}

	private boolean testValidity(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		//int index1, index2;
		//index1 = index2 = 0;
		int c1_length = c1.length;
		int c2_length = c2.length;
		
		if(c1_length != c2_length)
			return false;
	
		boolean found;
		for(int i = 0; i < c1_length; i++) {
			found = false;
			for (int j = 0; j < c2_length; j++) {
				if(c1[i]==c2[j]) {
					found = true;
					c2[j] = ' ';
					j = c2_length;
				}
			}
			if (found == false)
				return false;
		}
		return true;
	}

}
