/* This program takes a sorted 1D array.  After that, the user is asked what number they'd like to look for.
 * This is used as the key for a searching algorithm that returns whether or not the number is found.
 *Authors: @Alexandra Zolman
 * */


import java.util.Scanner;

public class project1_searching {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int[] array = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; //random sorted array used for testing purposes

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
