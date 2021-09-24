package hw.ArraysHW;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraysHW {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scan = new Scanner(System.in);
        int secretNumber = rnd.nextInt(101);
        int userChoice = -1000;
        int[] userPrevChoices = new int[300];
        int counter = 0;
        System.out.println("What is your name, bro?");
        String name = scan.next();
        System.out.println("Let the game begin!");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t(подсказка для режима тестирования: secretNumber= " + secretNumber + ")\n\n");

        while (userChoice != 1000) {
            userChoice = getNumber(scan);
            userPrevChoices[counter] = userChoice;
            if (userChoice == secretNumber) {
                congratulation(name, counter, userPrevChoices);
                break;
            } else if (userChoice < secretNumber) {
                System.out.println("Your number is too small. Please, try again.");
            } else if (userChoice > secretNumber) {
                if (userChoice != 1000) {
                    System.out.println("Your number is too large. Please, try again.");
                }
            }
            counter++;
        }
    }

    private static void congratulation(String name, int counter, int[] userPrevChoices) {
        System.out.println("Congratulations, " + name + "!");
        System.out.println("Your numbers:");
        int[] outputGuessings = new int[counter];
        System.arraycopy(userPrevChoices, 0, outputGuessings, 0, counter);
        System.out.println(Arrays.toString(outputGuessings));
        System.out.println( arrSortDescending(outputGuessings));

    }

    private static String arrSortDescending(int[] outputGuessings){
        Arrays.sort(outputGuessings);
        int[] finalArr = new int[outputGuessings.length];
        for (int i = 0; i < outputGuessings.length; i++) {
            finalArr[i] = outputGuessings[outputGuessings.length - 1 - i];
        }
        return Arrays.toString(finalArr);
    };

    private static int getNumber(Scanner scan) {
        System.out.println("What would be your next guessing? (range: 0 to 100)");
        if (scan.hasNextInt()) {
            int input = scan.nextInt();
            if (input >= 0 && input <= 100) {
                return input;
            } else {
                System.out.println("out of range. Repeat your choice:");
                return getNumber(scan);
            }
        } else {
            if (scan.next().equalsIgnoreCase("exit")) {
                return 1000;
            } else {
                System.out.println("incorrect input, repeat your choice:");
                return getNumber(scan);
            }
        }
    }
}
