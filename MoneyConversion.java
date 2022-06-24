class MoneyConversion {

    //-50D 20C -> -50.2
    Response response = new Response();
    public Response convertMoneyFromStringToNumber(String money){
        String[] unitOfMoney = money.split(" ");
        long dollars = 0;
        long cents = 0;
        int itr2, tmpAmt, amtLength;

        for(int itr1 = 0; itr1 < unitOfMoney.length; itr1++){
            itr2 = 0;
            tmpAmt = 0;
            amtLength = unitOfMoney[itr1].length();
            boolean negation = false;
            if(unitOfMoney[itr1].charAt(amtLength-1) != 'D' || unitOfMoney[itr1].charAt(amtLength-1) != 'C'){
                response.success = false;
                return response;
            }
            if(unitOfMoney[itr1].charAt(0) == '-'){
                negation=true;
                itr2++;
            }
            while(itr2 < amtLength-1){
                if(!Character.isDigit(unitOfMoney[itr1].charAt(itr2))){
                    response.success = false;
                    return response;
                }
                tmpAmt = tmpAmt*(10) + (unitOfMoney[itr1].charAt(itr2)-'0');
                itr2++;
            }
            tmpAmt = negation ? tmpAmt*(-1) : tmpAmt;

            if(unitOfMoney[itr1].charAt(amtLength-1) == 'D'){
                dollars = tmpAmt;
            }
            else{
                cents = tmpAmt;
            }
        }
        response.amtGiven = (dollars + (cents/(double)100));
        return response;
    }

    public String convertMoneyFromNumberToString(double money){
        long dollar,cent;
        //50.2
        if(money < 0){
            dollar = Math.round(Math.ceil(money));
            cent = Math.round((money - dollar)*100);
        }
        else{
            dollar = Math.round(Math.floor(money));
            cent = Math.round((money - dollar)*100);
        }
        if(cent >= 100){
            dollar+=1;
            cent-=100;
        }
        String moneyInString = Long.toString(dollar) + "D " + Long.toString(cent)+ "C";
        return moneyInString;
    }

}