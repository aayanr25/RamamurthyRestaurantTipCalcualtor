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
        double totalTip = 0;
        double realTipPercent = 0.0;
        int tipPercentage = 0;
        String tipType;
        while (true) {
            System.out.println("Do you want to tip as a percentage or set value? (1) Percentage (2) Set Value: ");
            int choice = scan.nextInt();
            if (choice == 1) {
                tipType = "Percentage";
                System.out.print("What percentage are you tipping? (0-100) ");
                tipPercentage = scan.nextInt();
                break;
            } else if (choice == 2) {
                tipType = "Set Value";
                System.out.print("How much do you want to tip? Enter a cost in dollars and cents (e.g. 12.50): ");
                totalTip = scan.nextDouble();
                break;
            } else {
                System.out.println("Please enter either a 1 or a 2.");
            }
        }

        scan.nextLine();

        double subtotal = 0;
        double num;
        int numItems = 0;
        ArrayList<String> foodItems  = new ArrayList<>();
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

        if (totalTip == 0) {
            realTipPercent = (double) tipPercentage / 100;
            totalTip = realTipPercent * subtotal;
        }
        double perPersonBeforeTip = (subtotal / numPeople);
        double tipPerPerson = (totalTip / numPeople);

        System.out.println("--------------------");
        System.out.println("Total before tip: $" + roundNum(subtotal));
        if (tipType.equals("Percentage")) {
            System.out.println("Total percentage: " + tipPercentage + "%");
        } else {
            System.out.println("Customer chose to tip a set amount.");
        }
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
