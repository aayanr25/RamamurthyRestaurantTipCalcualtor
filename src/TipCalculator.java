import java.util.Scanner;
import java.util.ArrayList;

public class TipCalculator {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the tip calculator, where you'll never have to calculate a tip again!");
        System.out.print("How many people are in your group? ");
        int numPeople = scan.nextInt();
        System.out.print("What percentage are you tipping? (0-100) ");
        double tipPercentage = scan.nextInt();
        tipPercentage /= 100;

        double totalCost = 0;
        double num = 0;
        ArrayList<String> foodItems  = new ArrayList<String>();
        while (num != -1) {
            System.out.print("Enter one food item you ordered: " );
            String item = scan.nextLine();
            foodItems.add(item);
            System.out.println();
            System.out.print("Enter a cost in dollars and cents (e.g. 12.50): ");
            num = scan.nextDouble();

            totalCost += num;
        }

        System.out.println(foodItems);

    }
}
