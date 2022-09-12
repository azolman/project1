/* This program randomly generates a 1D array then runs a sorting algorithm on it, putting it in largest to smallest
 * order.  After that, the user is asked if they'd like to search for a number and what number they'd like to look for.
 * This is used as the key for a searching algorithm that returns whether or not the number is found.  It should be
 * noted this combines both questions 7 and 8.
 *Authors: @Alexandra Zolman
 * */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class project1 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner scnr = new Scanner(System.in);
        int[] array = new int[r.nextInt(20)]; //random size used for testing purposes
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(100); //randomly populated array with values under 100
        }
        System.out.print("Original Array: " + Arrays.toString(array)); //prints array
        boolean doneSorting = my_sort(array); //runs sorting function
        System.out.println();
        System.out.print("New Array: " + Arrays.toString(array)); //reprints new, sorted array
        System.out.println();

        System.out.println("Would you like to search for a value?");
        String userInput = scnr.nextLine();
        if (userInput.equals("Yes") || userInput.equals("yes")) {
            System.out.println("What integer value would you like to search for?");
            int userNumber = scnr.nextInt();
            boolean numExists = fast_search(userNumber, array); //searches for input number in previously sorted array
            if (numExists) {
                System.out.println(userNumber + " exists."); //returns whether the value exists or not
            }
            else {
                System.out.println(userNumber + " does not exist.");
            }
        }
        else {
            System.out.println("Okay.");
        }
        System.exit(0);
    }

    //takes in a 1D array and compares two adjacent numbers.  If num1 is bigger than num2 then the numbers are swapped.
    //The array is run through in a nested loop in order to fully sort from largest to smallest.
    static boolean my_sort(int[] array) { //sorting function for a 1D array
        for (int i = 0; i < array.length; i++) { // n basic ops
            for (int j = 0; j < array.length - 1; j++) { // 5n + 5 basic ops
                int num1 = array[j]; // 1 basic op
                int num2 = array[j + 1]; // 1 basic op

                if (num2 > num1) { // 1 basic op
                    array[j] = num2; // 1 basic op
                    array[j + 1] = num1; // 1 basic op
                }
            }
        }
    return true; // 1 basic op
        //total basic ops comes to 5n^2 + 5n + 1
        //Through asymptotic analysis, 5n + 1 can be ignored, as well as the 5 constant
        //for the n^2 term.  This results in a worst case analysis of O(n^2).


    }

    //a sorted (largest to smallest) 1D array and a key 'k' are input.  k is compared to the midpoint of the sorted array.
    // If it is smaller, k is compared to every value on the right half of the array.  Conversely, if it is larger,
    // it is compared to the left half of the array.  If it is equal, the function returns as true.  In the worst case,
    //the number is never found and the search returns false.
    static boolean fast_search(int k, int[] array) {
        if (k < array[array.length / 2]) { // 2 basic ops --> total for else if statement is 2log(n)
            for (int i = array.length / 2; i < array.length; i++) { //log(n) basic ops
                if (k == array[i]) { //1 basic op
                    return true; //1 basic op
                }
            }
        }
        else if (k > array[array.length / 2]) { // 2 basic ops --> total for else if statement is 2log(n)
            for (int i = 0; i < array.length / 2; i++) { //log(n) basic ops
                if (k == array[i]) { //1 basic op
                    return true; //1 basic op
                }
            }
        }
        else {
            return true; //1 basic op
        }
        return false; //1 basic op

        //Case analysis shows that both the 'if' and 'else if' branches of the if statement have an equal
        //number of basic ops, at 2log(n).  The 'else' branch has only 1 basic op, meaning in worst case
        //analysis, it can be ignored.  When combined with the final return statement, the number of basic
        //ops becomes 2log(n) + 1.  With asymptotic analysis, the +1 and 2 constant can be ignored,
        //resulting in a worst case analysis of O(log(n)).
    }





}
