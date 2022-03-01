import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {

    public static void main(String[] args){

        Random rnd = new Random(); //Declare random
        int mystery;
        int guess;
        int tries = 1;
        int min;
        int max;
        int[] numbers;
        boolean verify = false;
        //System.out.println("Random number is " + mystery); //Check if random is working

        System.out.println("Guess a number from x and y\n" +
                "It could be the min or the max....");
        System.out.println("Enter the lowest number...");
        Scanner in = new Scanner(System.in);
        min = in.nextInt();

        if ( min <= 0 ){
            System.out.println("Enter a value greater than 0");
            min = in.nextInt();
        }

        System.out.println("Enter the highest number...");
        max = in.nextInt();
        mystery = rnd.nextInt(min,max); //Random number between 1 and 100
        System.out.println("Random number is " + mystery); //Check if random is working
        numbers = new int[100+max];
        System.out.println("Take a guess...");
        guess = in.nextInt();

        if(guess == mystery){
            System.out.println("Congrats, you got it on the first try! It's " + mystery);
        } else {
            numbers[0] = guess;
            for (int i = 1; guess != mystery; i++) {     //will keep running until it's true
                if ((min < guess)&&(guess < mystery)) {
                    verify = Main.check(numbers, guess);
                    if (verify  && 1 < i){
                        System.out.println("You already said this number! Guess again");
                        guess = in.nextInt();
                        verify = false;
                    } else {
                        System.out.println("Too low, try again...");
                        numbers[i] = guess;
                        guess = in.nextInt();
                        tries += 1;
                    }
                } else if ( (mystery < guess) && (guess < max)) {
                    verify = Main.check(numbers, guess);
                    if ((guess < mystery) && 1 < i) {
                        System.out.println("You already said this number! Guess again");
                        guess = in.nextInt();
                        verify = false;
                    } else {
                        System.out.println("Too high, try again...");
                        numbers[i] = guess;
                        guess = in.nextInt();
                        tries += 1;
                        //} else if (guess == mystery){
                        //    System.out.println("You got it! The number was " + mystery + "You got it in " + i + " tries.");
                    }
                }
                verify = false;
            }
            System.out.println("You got it! The number was " + mystery + "! You got it in " + tries + " tries.");
        }





    }

    public static boolean check(final int [] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i ==key);

    }

    public static boolean contains(int[] array, int key) {
        for (int i : array) {
            if (i == key) {
                return true;

            }
        }
        return false;
    }
}
