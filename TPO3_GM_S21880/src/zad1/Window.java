package zad1;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Window extends JPanel {
    static Map<String, Integer> mapServer = HeadServer.mapServer;
    private static String wynik;

    public static String intialize() {

        JFrame jframe = new JFrame();
        JPanel jpanel = new JPanel(new BorderLayout(5, 5));
        JPanel napis = new JPanel(new GridLayout(0, 1, 2, 2));
        napis.add(new JLabel("Jezyk", SwingConstants.RIGHT));
        napis.add(new JLabel("Slowo", SwingConstants.RIGHT));
        jpanel.add(napis, BorderLayout.WEST);

        System.out.println("okno ruszyl");
        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField slowodotlumaczenia = new JTextField();
        JComboBox jcomboBox = new JComboBox();

        for (String arg :
                mapServer.keySet()) {
            jcomboBox.addItem(arg);
        }
        controls.add(jcomboBox);
        controls.add(slowodotlumaczenia);
        jpanel.add(controls, BorderLayout.CENTER);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(
                jframe, jpanel, "Translator", JOptionPane.QUESTION_MESSAGE);
        System.out.println("okno dziala");
        wynik = jcomboBox.getSelectedItem() + ";" + slowodotlumaczenia.getText();
        //System.out.println(slowodotlumaczenia.getText());
        return wynik;
    }
}