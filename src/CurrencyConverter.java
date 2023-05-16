import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;
public class CurrencyConverter {


 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);



 System.out.println("Währungsumrechner");
 System.out.println("Verfügbare Währungen: EUR, USD, GBP");


 System.out.print("Geben Sie den Betrag ein: ");
 double amount = scanner.nextDouble();



 System.out.print("Geben Sie die Ausgangswährung ein (z.B. EUR): ");
 String sourceCurrency = scanner.next().toUpperCase();



 System.out.print("Geben Sie die Zielwährung ein (z.B. USD): ");
 String targetCurrency = scanner.next().toUpperCase();



 double conversionRate = getConversionRate(sourceCurrency, targetCurrency);
 double convertedAmount = convertCurrency(amount, conversionRate);



 System.out.println("Umgerechneter Betrag: " + convertedAmount + " " + targetCurrency);



 scanner.close();
 }


 public static double getConversionRate(String sourceCurrency, String targetCurrency) {
 try {
 String apiKey = "69uwA1AY09LmliVKV6OSxmwCfig3xId1";


 String url = "https://api.exchangeratesapi.io/latest?base=" + sourceCurrency + "&symbols=" + targetCurrency;
 URL apiUrl = new URL(url);
 HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
 connection.setRequestMethod("GET");


 // Überprüfung der API-Antwort
 int responseCode = connection.getResponseCode();
 if (responseCode == HttpURLConnection.HTTP_OK) {
 Scanner scanner = new Scanner(apiUrl.openStream());
 String jsonText = scanner.useDelimiter("\\A").next();
 scanner.close();

  // print JSON answer
  System.out.println("JSON Response: " + jsonText);

  // Verarbeitung der JSON-Antwort
JSONObject jsonObject = new JSONObject(jsonText);
 JSONObject ratesObject = jsonObject.getJSONObject("rates");
 double conversionRate = ratesObject.getDouble(targetCurrency);



 return conversionRate;
 } else {
 throw new IOException("Fehler beim Abrufen des Wechselkurses. Response-Code: " + responseCode);
 }
 } catch (Exception e) {
 e.printStackTrace();
 return 0.0;
 }
 }
 public static double convertCurrency(double amount, double conversionRate) {
 return amount * conversionRate;
 }
    }