import java.util.*;
/**
 * LuckyNumber
 */

public class LuckyNumber {
    //Counter
    static int counterGuesses;
    //Record
    static ArrayList<Integer> record = new ArrayList<Integer>();

    //Method to get Random Number ( answer ) with java.Random
    static int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        if (max >= min) {
            return random.ints(min, max)
            .findFirst()
            .getAsInt();
        } else {
            return random.ints(0, 100)
            .findFirst()
            .getAsInt();
        }
    }

    //Take guess and Condition
    static void guessesAndCondition(int min, int max, int answer) {
        //Count
        counterGuesses++;

        //Get guess
        Scanner sc = new Scanner(System.in);
        System.out.println("Take your guess from " + min + " to " + max);
        int num = sc.nextInt();
        System.out.println("Your guess is " + num);
        //Condition
        if (num > answer) {
            System.out.println("Your guess is greater than the answer. You have guess " + counterGuesses + " time(s)");
            guessesAndCondition(min, max, answer);
        }
        if (num < answer) {
            System.out.println("Your guess is smaller than the answer. You have guess " + counterGuesses + " time(s)");
            guessesAndCondition(min, max, answer);
        }
        if (num == answer) {
            System.out.println("Your guess is correct. You have guess " + counterGuesses + " time(s)");
        }
    }

    //Report
    static void report() {

        int totalGames = record.size();

        int sum = 0;
        for(int i = 0; i < record.size(); i++)
            sum += record.get(i);
        int totalGuess = sum;

        int guessAvg = sum / totalGames;

        int bestGame = Collections.min(record);

        System.out.println("Total games: " + totalGames + " games");
        System.out.println("Total guesses: " + totalGuess + " guesses");
        System.out.println("Average: " + guessAvg + " per game");
        System.out.println("Best game: " + bestGame + " guess(es)");

    }

    //Main method
    public static void main(String[] args) {
        //Scanner
        Scanner sc = new Scanner(System.in);

        //Intro
        System.out.println("Welcome to LuckyNumber!!!!");
        System.out.println("This game requires you to guess the right number randomly selected within Min and Max!!!");
        System.out.println("To Start playing please input command 'Yes' or 'Y' !!");
        String command = sc.next();

        //Game Start
        if (command.equalsIgnoreCase("yes") == true || command.equalsIgnoreCase("y") == true) {
            do {
                //Count
                counterGuesses = 0;

                //Get Min and Max
                System.out.println("Please input your designed Min and Max");
                System.out.println("Min: ");
                int min = sc.nextInt();
                System.out.println("Max: ");
                int max = sc.nextInt();
                if (min > max) {
                    System.out.println("Your MAX must be greater than MIN");
                    System.out.println("Your default value would be MIN = 0 and MAX = 100");        
                    min = 0;
                    max = 100;
                }
                System.out.println("Min: " + min);
                System.out.println("Max: " + max);
        
                //Assign random number
                int randomNum = getRandomNumberUsingInts(min, max);
                //System.out.println("Your answer is "+ randomNum); // For debug!!!
                
                //Run condition teller
                guessesAndCondition(min, max, randomNum);

                //Record
                record.add(counterGuesses);

                //Ask the user to continue
                System.out.println("To continue playing please input command 'Yes' or 'Y' !!");
                command = sc.next();

            } while (command.equalsIgnoreCase("yes") == true || command.equalsIgnoreCase("y") == true);
            {
                System.out.println("Thank you for playing with us!");
                System.out.println("Here is your record: ");
                report();
                sc.close();
            }
        } else {
            System.out.println("We will play in another time then!");
            sc.close();
    }
    }
}