import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        GUI GUI1 = new GUI();
        String BaseCurrency = GUI1.getBaseCurrency();
        String QuoteCurrency = GUI1.getQuoteCurrency();
        double amount = GUI1.getAmount();

        RatesFetcher RatesFetcher1 = new RatesFetcher();
        double rate = RatesFetcher1.getExchangeRate(BaseCurrency,QuoteCurrency);

        CurrencyConverter CurrencyConverter1 = new CurrencyConverter();
        double targetCurrencyAmount = CurrencyConverter1.Convert(amount, rate);

        System.out.println(amount+" "+BaseCurrency+" entspricht aktuell "+targetCurrencyAmount+" "+QuoteCurrency);


    }
}