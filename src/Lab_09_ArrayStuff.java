import java.util.Random;
import java.util.Scanner;

public class Lab_09_ArrayStuff {
    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Random rand = new Random();

        // Task 2: Initialize the array with random values between 1 and 100
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1;
        }

        // Task 3: Display the dataPoints values
        for (int value : dataPoints) {
            System.out.print(value + " | ");
        }
        System.out.println();

        // Task 4: Calculate and display the sum and average of the values in dataPoints
        int sum = 0;
        for (int value : dataPoints) {
            sum += value;
        }
        double average = (double) sum / dataPoints.length;
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.println("The average of the random array dataPoints is: " + average);

        // Task 5: Get a ranged int value from the user
        Scanner in = new Scanner(System.in);
        int userValue = SafeInput.getRangedInt(in, "Enter a value between 1 and 100", 1, 100);

        // Task 6: Count occurrences of the user's value in the array
        int count = 0;
        for (int value : dataPoints) {
            if (value == userValue) {
                count++;
            }
        }
        System.out.println("The value " + userValue + " was found " + count + " times in the array.");

        // Task 7: Find the first occurrence of the user's value in the array
        boolean found = false;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                System.out.println("The value " + userValue + " was found at array index " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The value " + userValue + " was not found in the array.");
        }

        // Task 8: Find and display the minimum and maximum values in the array
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int value : dataPoints) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        System.out.println("The minimum value in the array is: " + min);
        System.out.println("The maximum value in the array is: " + max);

        // Task 9: Display the average using the static method
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }

    public static double getAverage(int values[]) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }
}

class SafeInput {
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                if (retVal >= low && retVal <= high) {
                    valid = true;
                } else {
                    System.out.println("Error: Input out of range.");
                }
            } else {
                System.out.println("Error: Invalid input.");
                pipe.next(); // clear invalid input
            }
        } while (!valid);

        return retVal;
    }
}