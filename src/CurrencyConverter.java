public class CurrencyConverter{
    public double Convert(double amount,double rate){

        double targetCurrencyAmount;
        targetCurrencyAmount = amount*rate;
        return targetCurrencyAmount;

    }

}