public class Main {
    public static void main(String[] args) {

        GUI GUI1 = new GUI();

        // Wait for the user to click OK button
        while (GUI1.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String BaseCurrency = GUI1.getBaseCurrency();
        String QuoteCurrency = GUI1.getQuoteCurrency();
        double amount = GUI1.getAmount();

        RatesFetcher RatesFetcher1 = new RatesFetcher();
        double rate = RatesFetcher1.getExchangeRate(BaseCurrency,QuoteCurrency);

        Converter CurrencyConverter1 = new Converter();
        double targetCurrencyAmount = CurrencyConverter1.Convert(amount, rate);

        System.out.println(amount+" "+BaseCurrency+" entspricht aktuell "+targetCurrencyAmount+" "+QuoteCurrency);


    }
}