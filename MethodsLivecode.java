
import java.util.Scanner;

public class MethodsLivecode {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        do {

            System.out.println("------ MAthzilla 2.0 -------");
            System.out.println("1. Student Grade Evaluator");
            System.out.println("2. Electricity Bill Calculator");
            System.out.println("3. Array Statistics Analyzer");
            System.out.println("0. Exit");

            System.out.println("SELECT AN OPTION:");

            option = input.nextInt();

            if (option < 0) {
                System.out.println("Enter a positive whole number");
            } else if (option > 3) {
                System.out.println("Enter a number from 1 to 3 only");
            } else {
                switch (option) {
                    case 1 -> {

                        System.out.println("Enter your grade:(prelim, midterms, finals)");

                        System.out.println("Enter your prelim grade");
                        double prelim = input.nextDouble();
                        System.out.println("Enter your midterm grade");
                        double midterm = input.nextDouble();
                        System.out.println("Enter your finals grade");
                        double finals = input.nextDouble();

                        double averageGrade = calcAve(prelim, midterm, finals);

                        System.out.println("Average Grade: " + averageGrade);

                        char equiG = gradeequi(averageGrade);

                        System.out.println("Grade Equivalent: " + equiG);

                        System.out.println(ispasado(averageGrade) ? "Passed" : "Failed");

                    }
                    case 2 -> {
                        System.out.println("Enter the Electricty Consumption kWh:");
                        double ec = input.nextDouble();
                        System.out.println("Enter the Rate per kWh:");
                        double rate = input.nextDouble();
                        System.out.println("Enter the Additional Charge(%):");
                        double addc = input.nextDouble();

                        double conscharge = calcConsumption(ec, rate);
                        double addcharge = calcADDCharge(conscharge, addc);
                        double billtotal = Calctotalbill(conscharge, addcharge);

                        System.out.println("Consumption Charge: Php" + conscharge);
                        System.out.println("Additional Charge: Php" + addcharge);
                        System.out.println("Total Electricity Bill: Php" + billtotal);
                    }

                    case 3 -> {

                        System.out.print("Enter the number of students: ");
                        int size = input.nextInt();

                        if (size <= 0) {
                            System.out.println("The number of students must be greater than 0.");
                            break;
                        }

                        int[] scores = new int[size];

                        for (int i = 0; i < scores.length; i++) {

                            System.out.print("Enter score of student " + (i + 1) + ": ");
                            scores[i] = input.nextInt();
                        }

                        int sum = calculateSum(scores);

                        double arrayAverage = calculateAverage(scores);

                        int highest = findHighest(scores);

                        int lowest = findLowest(scores);

                        int passing = countPassed(scores);

                        System.out.println("Total Number of Scores: " + scores.length);

                        System.out.println("Sum of Scores: " + sum);

                        System.out.println("Average Score: " + arrayAverage);

                        System.out.println("Highest Score: " + highest);

                        System.out.println("Lowest Score: " + lowest);

                        System.out.println("Number of Passing Students: " + passing);
                    }

                    case 0 -> {
                        System.out.println("Thank you for using Mathzilla 2.0");
                    }

                    default -> {
                        System.out.println("Invalid input. Try again.");
                    }

                }

            }

        } while (option != 0);

    }

//METHOS SECTION:    
    //Let p=prelims, m=midterms, f=finals
    public static double calcAve(double p, double m, double f) {
        double ave = (p + m + f) / 3;
        return ave;
    }

    public static char gradeequi(double ave) {
        if (ave >= 90 && ave <= 100) {
            return 'A';
        } else if (ave >= 85 && ave <= 89.99) {
            return 'B';
        } else if (ave >= 80 && ave <= 84.99) {
            return 'C';
        } else if (ave >= 75 && ave <= 79.99) {
            return 'D';
        } else {
            return 'F';
        }

    }

    public static boolean ispasado(double grade) {
        if (grade >= 75) {
            return true;
        } else {
            return false;
        }
    }

    //for prob2
    public static double calcConsumption(double consumption, double rate) {
        return consumption * rate;
    }

    public static double calcADDCharge(double concharge, double percentage) {
        return concharge * (percentage / 100);
    }

    public static double Calctotalbill(double concharge, double addcharge) {
        return concharge + addcharge;
    }

    //for prob 3
    public static int calculateSum(int[] scores) {
        //sum
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        return sum;
    }

    //ave
    public static double calculateAverage(int[] scores) {

        int sum = calculateSum(scores);

        return (double) sum / scores.length;
    }

    //highest
    static int findHighest(int[] scores) {

        int highest = scores[0];

        for (int i = 1; i < scores.length; i++) {

            if (scores[i] > highest) {
                highest = scores[i];
            }
        }

        return highest;
    }

    //lowest
    static int findLowest(int[] scores) {

        int lowest = scores[0];

        for (int i = 1; i < scores.length; i++) {

            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }

        return lowest;
    }

    // count students who passed
    static int countPassed(int[] scores) {

        int count = 0;

        for (int i = 0; i < scores.length; i++) {

            if (scores[i] >= 75) {
                count++;
            }
        }

        return count;
    }

}
