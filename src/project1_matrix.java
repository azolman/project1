/* This program takes in a sorted n x n matrix (for the sake of testing, it uses a preset 4x4 matrix) and asks the user
* for a key to search for.  It then runs the find function that begins in the top right corner of the matrix
* (3 in this case) and compares the key to the value.  If the key is bigger, we move to the left.  If the key is smaller,
* we move down a row and repeat the process.  In the best case, the key is in the top right corner.  In the worst case,
* the key is not the matrix and is in between the nth and the n-1 rows in the first column.  For example, the worst
* case would fall in between 18 and 14 and is not in the matrix (15, for example).
 *Authors: @Alexandra Zolman
 * */

import java.util.Scanner;

public class project1_matrix {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int[][] matrix = {{60, 35, 10, 3}, //this sample matrix can be replaced and is simply used for testing.
                          {20, 16, 8, 1},
                          {18, 12, 3, -3},
                          {14, 3, -2, -9}};
        System.out.println("What number are you searching for?");
        int userNum = scnr.nextInt(); //gets key from user
        boolean numExists = MatrixFind(userNum, matrix); //runs find function and returns true or false if found
        if (numExists) {
            System.out.println(userNum + " exists.");
        }
        else {
            System.out.println(userNum + " does not exist.");
        }
    }

    //searches in the sorted 2D matrix for a given key 'k' beginning in the top right corner.  Returns true if k is
    //found anywhere in the matrix and false if it is not.
   static boolean MatrixFind(int k, int[][] matrix) {
        int row = matrix.length; //number of rows; 1 basic op
        int col = matrix[0].length; //number of columns; 1 basic ip

        int i = 0; //set i at 0 (first row); 1 basic op
        int j = col - 1; //set j at the far left column to begin with; 2 basic ops

        while (i < row && j >= 0) { //single loop that is still reliant on the size of the array --> basic ops of n
            if (matrix[i][j] == k) { //if k is found, return true; 1 basic op
                return true; //1 basic op
            }
            else if (k > matrix[i][j]) { //if k is bigger than the value; 1 basic op
                j--; //move to the left; 2 basic ops
            }
            else { //if k is smaller than the value
                i++; //move down a row; 2 basic ops
            }
        }

        return false; //1 basic op

       //Case analysis shows that the worst branch of the 'if' statement is either the 'else' branch with 3 basic ops.
       //When multiplied by the loop, this gives 3n basic ops.  Combined with the other lines of code gives 3n + 6 basic
       //ops.  Asymptotic analysis of the worst case says that any additions and constants can be dropped, resulting
       //in O(n).
   }
}
