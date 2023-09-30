import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class TipCalculator {
    public static double roundNum(double num) {
        double temp = num * 100;
        temp = Math.round(temp);
        return temp / 100;
    }
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the tip calculator, where you'll never have to calculate a tip again!");
        System.out.print("How many people are in your group? ");
        int numPeople = scan.nextInt();
        System.out.print("What percentage are you tipping? (0-100) ");
        int tipPercentage = scan.nextInt();
        double realTip = (double) tipPercentage / 100;
        scan.nextLine();

        double subtotal = 0;
        double num = 0;
        int numItems = 0;
        ArrayList<String> foodItems  = new ArrayList<String>();
        String item = "";
        while (!item.equals("-1")) {
            System.out.print("Enter one food item you ordered (-1 to end): " );
            item = scan.nextLine();
            if (item.equals("-1")) {
                break;
            }
            foodItems.add(item);
            System.out.print("Enter a cost in dollars and cents (e.g. 12.50): ");
            num = scan.nextDouble();
            scan.nextLine();
            System.out.println();
            subtotal += num;
            numItems ++;
        }
        double totalTip = realTip * subtotal;
        double perPersonBeforeTip = (subtotal / numPeople);
        double tipPerPerson = (totalTip / numPeople);

        System.out.println("--------------------");
        System.out.println("Total before tip: $" + roundNum(subtotal));
        System.out.println("Total percentage: " + tipPercentage + "%");
        System.out.println("Total tip: $" + roundNum(totalTip));
        System.out.println("Total bill with tip: $" + roundNum((totalTip + subtotal)));
        System.out.println("Per person cost before tip: $" + roundNum(perPersonBeforeTip) );
        System.out.println("Tip per person: $" + roundNum(tipPerPerson));
        System.out.println("Total cost per person: $" + roundNum((perPersonBeforeTip + tipPerPerson)));

        System.out.println("--------------------");
        int i = 0;
        System.out.println("Items ordered: ");
        while (i < numItems) {
            System.out.println(foodItems.get(i));
            i ++;
        }



    }
}
