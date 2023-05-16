import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class RatesFetcher {
    public static void main(String[] args) {
        String[] currencies = {"GBP", "USD", "EUR"};

        for (String baseCurrency : currencies) {
            for (String resultCurrency : currencies) {
                if (!baseCurrency.equals(resultCurrency)) {
                    String endpoint = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;

                    try {
                        // Create a URL object with the API endpoint
                        URL url = new URL(endpoint);

                        // Create an HttpURLConnection object and open a connection
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");

                        // Get the response code
                        int responseCode = connection.getResponseCode();

                        if (responseCode == HttpURLConnection.HTTP_OK) {
                            // Read the response using a BufferedReader
                            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                            StringBuilder response = new StringBuilder();
                            String line;

                            while ((line = reader.readLine()) != null) {
                                response.append(line);
                            }
                            reader.close();

                            // Parse the JSON response
                            JSONObject jsonResponse = new JSONObject(response.toString());
                            JSONObject rates = jsonResponse.getJSONObject("rates");

                            // Get the exchange rate
                            double exchangeRate = rates.getDouble(resultCurrency);

                            // Print the exchange rate
                            System.out.println("1 " + baseCurrency + " = " + exchangeRate + " " + resultCurrency);
                        } else {
                            System.out.println("Error: " + responseCode);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
