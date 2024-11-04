// Imports
import java.util.InputMismatchException;
import java.util.Scanner;

/** 
* A class that gets the user's weekly income and calculates their weekly income tax withholding amount.
* 
* @author  Joshua Borck
*/
public class TaxWithholder {

	public static void main(String[] args) {
		// Initialize properties
		Scanner scnr = new Scanner(System.in);
		double weeklyIncome = 0.0;
		boolean hasValidInput = false;
		
		// Output to the user to enter a weekly income in the correct format.
		System.out.println("Please your weekly income as a decimal number without any currency symbols. An example is 203.45 for $203.45 a week.");
		
		// While hasValidInput is false, continue to attempt to get a valid value from the user.
		while (!hasValidInput) {
			
			// Try to get a double from the user's input and if successful, set hasValidInput to true to exit the loop. Otherwise handle the error.
			try {
				weeklyIncome = scnr.nextDouble();
				hasValidInput = true;
			} catch (InputMismatchException e) {
				// If the user has not entered a valid input, inform them, and try again.
				System.out.println("The input is invalid. Please try again:");
				scnr.nextLine();
			}
		}
		
		// Output to the user the correct weekly income tax amount, their weekly income, and the tax percentage based on that income.
		System.out.println(calculateWeeklyIncomeTaxOutput(weeklyIncome));
		scnr.close();
	}
	
	 /** 
	    * This method calculates a user output for a weekly income input.
	    * @param weeklyIncome This is a double representing the user's weekly income.
	    * @return String This returns the output summary string of the user's weekly income tax.
	    */
	public static String calculateWeeklyIncomeTaxOutput(double weeklyIncome) {
		// Initialize properties and set a base output to be used.
		String mainOutput = "With a weekly income of $%.2f, the tax is %d%%, and $%.2f will be taken out weekly.";
		double taxedIncome = 0.0;
		int taxPercent = 10;
		
		// Check the weekly income and calculate the correct weekly income tax.
		if (weeklyIncome <= 0) {
			// If the user enters $0 or less for weekly income, inform them the tax would always be $0.
			return "The weekly income tax on $0.00 or less will always be $0.00.";
		} else if (weeklyIncome < 500) {
			taxedIncome = weeklyIncome * 0.1;
			taxPercent = 10;
		} else if ((weeklyIncome >= 500) && (weeklyIncome < 1500)) {
			taxedIncome = weeklyIncome * 0.15;
			taxPercent = 15;
		} else if ((weeklyIncome >= 1500) && (weeklyIncome < 2500)) {
			taxedIncome = weeklyIncome * 0.2;
			taxPercent = 20;
		} else if (weeklyIncome >= 2500) {
			taxedIncome =  weeklyIncome * 0.3;
			taxPercent = 30;
		} else {
			// If weekly income does not fit into these ranges, inform the user of an invalid input.
			return "The weekly income was invalid.";
		}
		
		
		// Return the formatted string containing all the correct tax and income values.
		return String.format(mainOutput, weeklyIncome, taxPercent, taxedIncome);
	}
}