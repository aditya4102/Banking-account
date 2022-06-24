class PerformTransaction extends Account{
    private double availableBalance = 0.00;
    private final double maxBalanceLimit =  1e9;
    MoneyConversion moneyConversion = new MoneyConversion();
    public void deposit(String amount){

        Response response = moneyConversion.convertMoneyFromStringToNumber(amount);
        double amountToBeDeposited = response.amtGiven;
        if(!response.success){
            System.out.println("Please give us the proper input.");
        }
        else if((availableBalance + amountToBeDeposited) >  maxBalanceLimit){
            System.out.println("Given amount cannot be deposited to your bank account as it exceeds the maximum balance limit");

        }
        else {
            availableBalance+= amountToBeDeposited;
            System.out.println("Deposit successful.");
        }
    }

    public void withdraw(String amount){
        Response response = moneyConversion.convertMoneyFromStringToNumber(amount);
        if(!response.success){
            System.out.println("Please give us the proper input.");
        }
        else{
            double amountToBeWithdrawn = response.amtGiven;
            availableBalance-= amountToBeWithdrawn;
            System.out.println("Withdraw successful");
        }
    }

    public String check_balance() {
        String availableMoney = moneyConversion.convertMoneyFromNumberToString(availableBalance);
        return availableMoney;
    }
}