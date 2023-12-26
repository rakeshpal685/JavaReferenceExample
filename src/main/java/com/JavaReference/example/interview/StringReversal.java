package com.JavaReference.example.interview;

public class StringReversal {
	
	public static void main(String[] args) {
		
		// 1st way
		String input = "Rakesh";
		// convert String to character array
		char[] try1 = input.toCharArray();
		for (int i = try1.length - 1; i >= 0; i--) {
			// System.out.print(try1[i]);
		}
		
		// 2nd way
		StringBuilder input1 = new StringBuilder(input);
		// reverse StringBuilder input1
		input1.reverse();
		// print reversed String
		System.out.println(input1);
	}
	
}
