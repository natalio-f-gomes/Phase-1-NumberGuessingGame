/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numberguessinggame;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author nataliogomes
 * This program was 100% written by the @author
 */
public class NumberGuessingGame {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Welcome to Number Guessing Game");
       System.out.println("Please choose the option below");
       System.out.println("1. Human Guess Number");
       System.out.println("2. Computer Guess Number");
       System.out.print("3. Quit Game\nA:");
       int userChoice = scanner.nextInt();
       scanner.nextLine();
       switch(userChoice){
           case 1: humanGuess(scanner); break;
           case 2: computerGuess(scanner); break;
           case 3: break;
           default: System.out.println("Invalid Option"); break;
       } 
    }
    
    public static void humanGuess(Scanner scanner){
        int guesses = 0;
        int randomNumber = new Random().nextInt(100);

        System.out.println(randomNumber);
        while (true){
            try{
                System.out.print("Please enter your guess between 0 and 100\nA: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine();
                guesses++;
                if(userGuess < randomNumber){
                    System.out.println("Higher");
                }else if(userGuess > randomNumber){
                    System.out.println("Lower");
                }
                else{
                    System.out.println("Congratulations. You guessed the correct number in " + guesses + " guesses");
                    break;
                }
                
            }catch(Exception e){
                System.out.println(e);
                break;
                
            }
        }
    }
    
    public static void computerGuess(Scanner scanner){
        int guesses = 0;
        int lower = 0;
        int high = 100;
        
        boolean guessed = false;
        while(!guessed){
            int randomNumber = new Random().nextInt(high - lower +1) + lower;
            System.out.println("High END: " + high + "\nLower END: " + lower);
            System.out.println("I guessed " + randomNumber);
            System.out.println("Is That correct? ");
            System.out.println("H - Higher ");
            System.out.println("L -  Lower ");
            System.out.println("C - Correct ");
            String humanAnswer  = scanner.nextLine();
            guesses ++;
            switch(humanAnswer){
                case "H": 
                    lower = randomNumber;
                    break;
                case "L":
                    high = randomNumber;
                    break;
            
                case "C":
                    System.out.println("I guessed the correct number in " + guesses + " guesses");
                    guessed = true;
                    break;
                default: System.out.println("Invalid Feedback!");
            }
        }
    }
}

