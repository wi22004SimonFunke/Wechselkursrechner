import java.util.Currency;

public class Main {
    public static void main(String[] args) {
        InputAsker InputAsker1 = new InputAsker();
        String[] currencies = InputAsker1.askForCurrencies();
        double amount = InputAsker1.askForAmount();

        RatesFetcher RatesFetcher1 = new RatesFetcher();
        double rate = RatesFetcher1.getExchangeRate(currencies[0],currencies[1]);

        CurrencyConverter CurrencyConverter1 = new CurrencyConverter();
        double targetCurrencyAmount = CurrencyConverter1.Convert(amount, rate);

        System.out.println("amount"+" "+currencies[0]+" entspricht aktuell "+targetCurrencyAmount+currencies[1]);
    }
}