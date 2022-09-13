/* This program randomly generates a 1D array then runs a sorting algorithm on it, putting it in largest to smallest
 * order.
 *Authors: @Alexandra Zolman
 * */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class project1_sorting {
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






}
