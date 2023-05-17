import java.util.Scanner;
    public class InputAsker {
        private Scanner scanner;

        public InputAsker() {
            scanner = new Scanner(System.in);
        }

        public String[] askForCurrencies() {
            System.out.print("Enter the base currency:");
            String baseCurrency = scanner.nextLine();

            System.out.print("Enter the target currency:");
            String targetCurrency = scanner.nextLine();

            return new String[]{baseCurrency, targetCurrency};
        }

        public double askForAmount(){
            System.out.println("Enter the amount:");
            double amount = scanner.nextDouble();
            return amount;
        }

        }
