import java.util.Random;
import java.util.Scanner;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {

    public static void main(String[] args){

        Random rnd = new Random(); //Declare random
        int mystery = rnd.nextInt(1,10); //Random number between 1 and 100
        int guess;
        int tries = 1;
        //System.out.println("Random number is " + mystery); //Check if random is working

        System.out.println("Take a guess...");
        Scanner num = new Scanner(System.in);

        guess = num.nextInt();

        if(guess == mystery){
            System.out.println("Congrats, you got it on the first try! It's " + mystery);
        } else {
            for (int i = 1; guess != mystery; i++) {     //will keep running until it's true
                if (guess < mystery) {
                    System.out.println("Too low, try again...");
                    Scanner num1 = new Scanner(System.in);
                    guess = num1.nextInt();
                    tries += 1;
                } else if (guess > mystery) {
                    System.out.println("Too high, try again...");
                    Scanner num2 = new Scanner(System.in);
                    guess = num2.nextInt();
                    tries += 1;
                    //} else if (guess == mystery){
                    //    System.out.println("You got it! The number was " + mystery + "You got it in " + i + " tries.");
                }
            }
            System.out.println("You got it! The number was " + mystery + "! You got it in " + tries + " tries.");
        }





    }
}
