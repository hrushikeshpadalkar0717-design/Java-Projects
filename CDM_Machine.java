package BASICS.JAVA_PROJECTS;
import java.util.Scanner;

public class CDM_Machine {
    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);

        int balance = 10000; 
        int total_amount;
        char ch;

        while (true) {
            System.out.println("\n=============================");
            System.out.println("D - Deposit");
            System.out.println("W - Withdraw");
            System.out.println("B - Check Balance");
            System.out.print("Enter your choice: ");
            ch = z.next().charAt(0);

            switch (ch) {
                case 'D':
                case 'd':
                    System.out.print("Enter amount to deposit: ");
                    int deposit = z.nextInt();
                    if (deposit > 0) {
                        total_amount = deposit + balance;
                        System.out.println("Your new balance is: " + total_amount);
                        balance = total_amount;
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 'W':
                case 'w':
                    System.out.print("Enter amount to withdraw: ");
                    int withdraw = z.nextInt();
                    if (withdraw > 0 && withdraw <= balance) {
                        total_amount = balance - withdraw;
                        System.out.println("Your new balance is: " + total_amount);
                        balance = total_amount;
                    } else {
                        System.out.println("Invalid or insufficient balance.");
                    }
                    break;

                case 'B':
                case 'b':
                    System.out.println("Your balance is: " + balance);
                    break;

                default:
                    System.out.println("Please enter a valid input (D/W/B).");
                    break;
            }
        }
    }
}




