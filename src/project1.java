import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class project1 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner scnr = new Scanner(System.in);
        int[] array = new int[r.nextInt(20)];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(100);
        }
        System.out.print("Original Array: " + Arrays.toString(array));
        boolean doneSorting = my_sort(array);
        System.out.println();
        System.out.print("New Array: " + Arrays.toString(array));
        System.out.println();

        System.out.println("Would you like to search for a value?");
        String userInput = scnr.nextLine();
        if (userInput.equals("Yes") || userInput.equals("yes")) {
            System.out.println("What integer value would you like to search for?");
            int userNumber = scnr.nextInt();
            boolean numExists = fast_search(userNumber, array);
            if (numExists) {
                System.out.println(userNumber + " exists.");
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

    static boolean my_sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                int num1 = array[j];
                int num2 = array[j + 1];

                if (num2 > num1) {
                    array[j] = num2;
                    array[j + 1] = num1;
                }
            }
        }
    return true;
    }

    static boolean fast_search(int k, int[] array) {
        if (k < array[array.length / 2]) {
            for (int i = array.length / 2; i < array.length; i++) {
                if (k == array[i]) {
                    return true;
                }
            }
        }
        else if (k > array[array.length / 2]) {
            for (int i = 0; i < array.length / 2; i++) {
                if (k == array[i]) {
                    return true;
                }
            }
        }
        else {
            return true;
        }

        return false;
    }





}
