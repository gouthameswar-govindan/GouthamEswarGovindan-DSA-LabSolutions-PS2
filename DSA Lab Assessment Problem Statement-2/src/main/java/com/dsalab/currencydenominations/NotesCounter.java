package com.dsalab.currencydenominations;

import java.util.Scanner;

public class NotesCounter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Size Of Currency Denominations:");
		int noOfDenominations = sc.nextInt(); // Getting Array Size From The User
		int[] arr = new int[noOfDenominations]; // Array Creation Syntax
		System.out.println("Enter The Currency Denomination Values:");
		for (int i = 0; i < arr.length; i++) { // Getting Array Values From The User(Random Order)
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter The Amount You Want To Pay");
		int payment = sc.nextInt(); // Getting Payable Amount From The User
		sortArray(arr); // Calling Sorted Array Method (in descending order using BUBBLE Sort
						// Algorithm).
		countNotes(arr, payment); // Calling NotesCounter Method ( minimum number of notes needed to pay the Net
									// Amount).

	}

	private static void countNotes(int[] arr, int payment) {
		int[] notesCounter = new int[arr.length];
		try {
			for (int i = 0; i < arr.length; i++) {// Calculation Part For ( minimum number of notes needed to pay the
													// Net Amount).
				if (payment >= arr[i]) {
					notesCounter[i] = payment / arr[i];
					payment = payment - notesCounter[i] * arr[i];
				}
			}
			if (payment > 0) {
				System.out.println("Your Payment Amount Cannot Be Achieved With The Highest Denomination");

			} else {
				System.out.println("Your Payment Approach In Order To Give Minimum Number Of Notes Will Be:");
				for (int i = 0; i < arr.length; i++) {
					if (notesCounter[i] != 0) {
						System.out.println(arr[i] + ":" + notesCounter[i]);
					}
				}
			}
		} catch (ArithmeticException e) {
			System.out.println("Denominations Cannot Be Zero");
		}

	}

	private static void sortArray(int[] arr) { // Array Values Sorting Using BUBBLE SORT ALGORITHM.
		for (int i = 0; i < arr.length - 1; i++) { // In Descending Order
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] < arr[j + 1]) {
					int temp = arr[j]; // Swapping Values by Using Temporary Variable temp.
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}

	}

}
