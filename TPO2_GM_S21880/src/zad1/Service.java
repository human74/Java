/**
 *
 *  @author Guzdek Maciej S21880
 *
 */

package zad1;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Service {
    public String city="Warsaw";
    public String country;
    public String a = "";
    public String kraj="Niemcy";
    public String apiKey = "cd1f9cf5677ef94bdb77d1cc8b2f45d6";
    StringBuffer sb = new StringBuffer();
    StringBuffer sb2 = new StringBuffer();
    StringBuffer sb3 = new StringBuffer();
    Service(String kraj){
        this.kraj=kraj;

    }

    public Service() {

    }

    public String getWeather(String italy) {
        try {
            URL url1 = new  URL ("http://api.openweathermap.org/data/2.5/weather?q=warsaw&appid=cd1f9cf5677ef94bdb77d1cc8b2f45d6");
            InputStream input = url1.openStream();
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {

                sb.append(scanner.nextLine());

            }
            a=sb.toString();
            //System.out.println(a);
            JSONParser parser = new JSONParser();
            Object jsonObj = parser.parse(a);
            JSONObject jsonObject = (JSONObject) jsonObj;
            System.out.println(jsonObject.get("main"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return a;
    }

    public double getRateFor(String usd) throws IOException, ParseException {
        URL url2 = new  URL ("https://api.exchangerate.host/latest?base=PLN&symbols="+usd);
        InputStream input2 = url2.openStream();
        Scanner scanner2 = new Scanner(input2);
        String b = "";
        while (scanner2.hasNextLine()) {
            sb2.append(scanner2.nextLine());
        }
        b=sb2.toString();
        JSONParser parser2 = new JSONParser();
        JSONObject jsonObject2 = (JSONObject) parser2.parse(b);
        JSONObject rates= (JSONObject)jsonObject2.get("rates");
        String cokolowiek = rates.get(usd).toString();
        double value = Double.parseDouble(cokolowiek);
        System.out.println(value);
        return value;
    }

    public double getNBPRate() {
     double value2 = 0;
     String kod="MYR";
        Currency.getInstance(Locale.US).getCurrencyCode();

        try {
            URL url3 = new  URL ("http://api.nbp.pl/api/exchangerates/rates/A/"+kod+"/?format=json");
            InputStream input3 = url3.openStream();
            Scanner scanner3 = new Scanner(input3);
            String c = "";
            while (scanner3.hasNextLine()) {
                sb3.append(scanner3.nextLine());
            }
            c=sb3.toString();

            JSONParser parser3 = new JSONParser();
            JSONObject jsonObject3 = (JSONObject) parser3.parse(c);
            JSONArray rates = (JSONArray) jsonObject3.get("rates");
            JSONObject object = (JSONObject) rates.get(0);
            value2 = (double) object.get("mid");
            System.out.println(c);

            return value2;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(value2);

        return 0;
    }
}