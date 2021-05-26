package zad1;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class gui{

    public static void startApp (Service service)  {
            String string1 ="";
            JFXPanel jpanel = new JFXPanel();
            JButton button1 = new JButton();
            JButton button2 = new JButton();
            JButton button3 = new JButton();
            JFrame jframe = new JFrame(service.city);
            jframe.setLayout(new BorderLayout());
            JTextArea textArea = new JTextArea();
            textArea.setText("text ");
            Platform.runLater(()->{
            WebView webView = new WebView();
            WebEngine engine = webView.getEngine();
            engine.load("https://"+"en.wikipedia.org/wiki/" + service.city);
            button1.setText("POGODA");
            button2.setText("Waluta");
            button3.setText("NBP");
            jframe.add(textArea,BorderLayout.PAGE_START);
            jframe.add(button1,BorderLayout.LINE_START);
            jframe.add(button2,BorderLayout.LINE_END);
            jframe.add(button3,BorderLayout.PAGE_END);
            Pane root = new FlowPane();
            root.getChildren().addAll(webView);
            Scene scene = new Scene(root);
            jpanel.setScene(scene);
            jframe.add(jpanel,BorderLayout.CENTER);
            jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jframe.pack();
            jframe.setVisible(true);
                   // button1.setActionCommand(service.getWeather(String italy));
                    try {
                            textArea.setText(String.valueOf(service.getRateFor("USD")));
                            button2.setActionCommand(String.valueOf(service.getRateFor("USD")));
                    } catch (IOException e) {
                            e.printStackTrace();
                    } catch (ParseException e) {
                            e.printStackTrace();
                    }
                    textArea.setText(String.valueOf(service.getNBPRate()));
                    button3.setActionCommand(String.valueOf(service.getNBPRate()));


        });
    }
}