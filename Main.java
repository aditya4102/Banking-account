import java.util.Scanner;

class Main{
    public static void main(String[] args){

        boolean isActivityGoingOn = true;
        PerformTransaction performTransaction = new PerformTransaction();
        SelectedChoices selectedChoices = new SelectedChoices();
        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        while (isActivityGoingOn) {
            System.out.println("Please select an option: ");
            System.out.println("1. Credit");
            System.out.println("2. Debit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scan.nextInt();

            if(choice == selectedChoices.credit){
                System.out.println("Enter the amount to be credited into your account: ");
                String amount = scan.next();
                performTransaction.deposit(amount);
                System.out.println();
            }
            else if(choice == selectedChoices.debit){
                System.out.println("Enter the amount to be debited from your account:");
                String amount = scan.next();
                performTransaction.withdraw(amount);
                System.out.println();
            }
            else if(choice == selectedChoices.checkBalance){
                System.out.println("Current balance is " + performTransaction.check_balance());
                System.out.println();
            }
            else if(choice == selectedChoices.exit){
                System.out.println("Thank You for banking with us!");
                scan.close();
                isActivityGoingOn = false;
            }
            else{
                System.out.println("Please make a valid choice.");
            }
        }
    }
}