package com.tasktwo.numberguessingame;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        // Create a random object to generate random numbers
        Random random = new Random();

        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Initialize the score and the round number
        int score = 0;
        int round = 1;

        // Loop until the user wants to quit
        boolean play = true;
        while (play) {
            // Generate a random number between 1 and 100
            int number = random.nextInt(100) + 1;

            // Initialize the number of attempts and the user's guess
            int attempts = 0;
            int guess = 0;

            // Display the round number and prompt the user to guess
            System.out.println("Round " + round + ": Guess a number between 1 and 100");

            // Loop until the user guesses the number or runs out of attempts
            boolean guessed = false;
            while (!guessed && attempts < 10) {
                // Read the user's guess from the scanner
                guess = scanner.nextInt();

                // Increment the number of attempts
                attempts++;

                // Check if the guess is correct, too high or too low
                if (guess == number) {
                    // The user guessed the number correctly
                    guessed = true;
                    System.out.println("You got it! The number was " + number);
                } else if (guess > number) {
                    // The user's guess was too high
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    // The user's guess was too low
                    System.out.println("Your guess is too low. Try again.");
                }
            }

            // Check if the user guessed the number or ran out of attempts
            if (guessed) {
                // The user guessed the number
                // Calculate the points based on the number of attempts
                int points = 20 - attempts;

                // Update the score and display it
                score += points;
                System.out.println("You earned " + points + " points. Your total score is " + score);
            } else {
                // The user ran out of attempts
                System.out.println("Sorry, you ran out of attempts. The number was " + number);
            }

            // Increment the round number
            round++;

            // Ask the user if they want to play another round or quit
            System.out.println("Do you want to play another round? (y/n)");
            String answer = scanner.next();

            // Check if the user wants to quit
            if (answer.equalsIgnoreCase("n")) {
                play = false;
                System.out.println("Thank you for playing. Your final score is " + score);
            }
        }

        // Close the scanner object
        scanner.close();
    }
}