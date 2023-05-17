import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class RatesFetcher {

    public double getExchangeRate(String baseCurrency, String targetCurrency) {
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
                JSONObject ratesJson = jsonResponse.getJSONObject("rates");

                // Get the exchange rate
                double exchangeRate = ratesJson.getDouble(targetCurrency);

                return exchangeRate;
            } else {
                System.out.println("Error: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0.0; // Return a default value if exchange rate retrieval fails
    }
}
