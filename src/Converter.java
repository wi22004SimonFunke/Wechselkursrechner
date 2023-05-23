public class Converter {
    private double targetCurrencyAmount;
    public double Convert(double amount,double rate){


        targetCurrencyAmount = amount*rate;
        return targetCurrencyAmount;

    }

}