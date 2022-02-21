package commonInterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

//This solution is highly inefficient and not recommended to anybody.
//I had difficulty generating all possible parentheses pairing of size n,
//so I made a stupidGen() method that generates n^3 possibilities in hope of 
//finding every one (with duplicates), then filter out the duplicates after 
//testing for validity.

public class generateParentheses {

	// Given an integer n, generate all the valid combinations of n pairs of
	// parentheses
	public static void main(String[] args) {
		int n = 3;
		generateParentheses gp = new generateParentheses();
		gp.execute(n);
	}

	private void execute(int n) {
		String[] solutions = new String[n * n * n]; // extra space needed due to stupid code
		String[] possibilities = generate(n);
		int index = 0;

		// check validity of solutions
		for (int i = 0; i < possibilities.length; i++) {
			if (isValid(possibilities[i].toCharArray())) {
				solutions[index] = possibilities[i];
				index++;
			}
		}

		// remove duplicates
		List<String> list = Arrays.asList(solutions);
		List<String> newList = list.stream().distinct().collect(Collectors.toList());
		String[] updatedSol = newList.toArray(new String[0]);

		// print solutions
		for (int i = 0; i < updatedSol.length; i++) {
			if (i == updatedSol.length - 1)
				System.out.print(updatedSol[i]);
			else
				System.out.print(updatedSol[i] + ", ");
		}
	}

	private String[] generate(int n) {
		String[] ans = new String[n * n * n];

		for (int i = 0; i < n * n * n; i++) { // Excessively stupid solution. Running n^3 times should generate
			String poss = stupidGen(n); // all possible solutions, right????
			ans[i] = poss;
		}

		return ans;
	}

	private String stupidGen(int n) { // An excessively stupid way to generate possible pairings of parentheses
		int length = n * 2;
		int open = 1;
		int closed = 0;

		String output = "(";
		for (int i = 1; i < length; i++) {
			if (open == n) {
				output += ")";
				closed++;
			} else if (open == closed) {
				output += "(";
				open++;
			} else {
				double random = Math.random();
				if (random < 0.5) {
					output += "(";
					open++;
				} else {
					output += ")";
					closed++;
				}
			}
		}
		return output;
	}

	// checks for validity of solution
	private boolean isValid(char[] c) {
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '(')
				s.push(c[i]);
			else if (s.empty())
				return false;
			else
				s.pop();
		}
		if (s.empty() == false)
			return false;
		return true;
	}

}
