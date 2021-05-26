/**
 *
 *  @author Guzdek Maciej S21880
 *
 */

package zad1;


import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException, ParseException {
    Service s = new Service("Poland");
    String weatherJson = s.getWeather("Warsaw");
    Double rate1 = s.getRateFor("USD");
    Double rate2 = s.getNBPRate();
    // ...
    // część uruchamiająca GUI
    gui.startApp(s);

  }
}