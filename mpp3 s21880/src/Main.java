import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Data> teachData = new ArrayList<Data>();

        załadujdane("Teach/German", teachData, "German", 0, 10);
        załadujdane("Teach/English", teachData, "English", 1, 10);
        załadujdane("Teach/Polish", teachData, "Polish", 2, 10);

        Perceptron germanperceptron = new Perceptron(0);
        Perceptron englishperceptron = new Perceptron(1);
        Perceptron polishperceptron = new Perceptron(2);
        for (int j = 0; j < 10; j++)
            for (int i = 0; i < 3; i++) {
                englishperceptron.ucz(teachData.get(j + 10 * i));
                germanperceptron.ucz(teachData.get(j + 10 * i));
                polishperceptron.ucz(teachData.get(j + 10 * i));
            }

        System.out.println("Naciśnij 1 jeśli chcesz przetestować pliki załadowane w folderze test");
        System.out.println("Naciśnij 2 jeśli chcesz wprowadzić własny tekst");
        int wczytana = scanner.nextInt();
        if (wczytana == 1) {
            ArrayList<Data> testData = new ArrayList<Data>();
            załadujdane("Test/English", testData, "English", 0, 10);
            załadujdane("Test/German", testData, "German", 1, 10);
            załadujdane("Test/Polish", testData, "Polish", 2, 10);

            int liczbaangtest = 10;
            int liczbaniemtest = 10;
            int liczbapltest = 10;
            int zakwalifikowanyang = 0;
            int zakwalifikowanyniem = 0;
            int zakwalifikowanypol = 0;

            for (Data data : testData) {
                System.out.print(data.resault + " ---> ");
                if (englishperceptron.liczNet(data) == 1) {
                    System.out.print("English ");
                    zakwalifikowanyang++;
                }
                if (polishperceptron.liczNet(data) == 1) {
                    System.out.print("Polish ");
                    zakwalifikowanypol++;
                }
                if (germanperceptron.liczNet(data) == 1) {
                    System.out.print("German ");
                    zakwalifikowanyniem++;
                }
                System.out.println();
            }

            int niezakwalifikowanyang = liczbaangtest-zakwalifikowanyang;
            int niezakwalifikowanyniem = liczbaniemtest-zakwalifikowanyniem;
            int niezakwalifikowanypol = liczbapltest-zakwalifikowanypol;

            //macierz omyłek, dokładność, precyzję, pełność, F-miarę dla każdego języka
            int liczbatesktow=30;
            int angniepopr=liczbatesktow-zakwalifikowanyang;
            int niemniepopr=liczbatesktow-zakwalifikowanyniem;
            int polniepopr = liczbatesktow-zakwalifikowanypol;
            System.out.println();
            System.out.println("English");
            System.out.println("zakwalifikowane jako     wynik+      wynik-");
            System.out.print("faktycznie+");
            System.out.print("              "+zakwalifikowanyang+"           "+niezakwalifikowanyang);
            System.out.println();
            System.out.print("faktycznie-");
            System.out.print("              "+niezakwalifikowanyang+"           "+angniepopr);
            System.out.println();
            System.out.println();
            int dokladnoscang = (zakwalifikowanyang+angniepopr)/(zakwalifikowanyang+niezakwalifikowanyang+niezakwalifikowanyang+angniepopr);
            System.out.println("dokladnosc to "+dokladnoscang*100+"%");
            int precyzjaang = (zakwalifikowanyang/(zakwalifikowanyang+niezakwalifikowanyang));
            System.out.println("precyzja to "+precyzjaang);
            int pelnoscang = (zakwalifikowanyang/(zakwalifikowanyang+niezakwalifikowanyang));
            System.out.println("pelnosc to "+pelnoscang);
            int fang = ((2*precyzjaang*pelnoscang)/(precyzjaang+pelnoscang));
            System.out.println("fmiara to "+fang);
            System.out.println();

            System.out.println("German");
            System.out.println("zakwalifikowane jako     wynik+      wynik-");
            System.out.print("faktycznie+");
            System.out.print("              "+zakwalifikowanyniem+"           "+niezakwalifikowanyniem);
            System.out.println();
            System.out.print("faktycznie-");
            System.out.print("              "+niezakwalifikowanyniem+"           "+niemniepopr);
            System.out.println();
            System.out.println();

            int dokladnoscniem = (zakwalifikowanyniem+niezakwalifikowanyang)/(zakwalifikowanyniem+niezakwalifikowanyniem+niezakwalifikowanyniem+niemniepopr);
            System.out.println("dokladnosc to "+dokladnoscniem*100+"%");
            int precyzjaniem = (zakwalifikowanyniem/(zakwalifikowanyniem+niezakwalifikowanyniem));
            System.out.println("precyzja to "+precyzjaniem);
            int pelnoscniem = (zakwalifikowanyniem/(zakwalifikowanyniem+niezakwalifikowanyniem));
            System.out.println("pelnosc to "+pelnoscniem);
            int fniem = ((2*precyzjaniem*pelnoscniem)/(precyzjaniem+pelnoscniem));
            System.out.println("fmiara to "+fniem);
            System.out.println();

            System.out.println("Polish");
            System.out.println("zakwalifikowane jako     wynik+      wynik-");
            System.out.print("faktycznie+");
            System.out.print("              "+zakwalifikowanypol+"           "+niezakwalifikowanypol);
            System.out.println();
            System.out.print("faktycznie-");
            System.out.print("              "+niezakwalifikowanypol+"           "+polniepopr);
            System.out.println();
            System.out.println();

            int dokladnoscpol = (zakwalifikowanypol+niezakwalifikowanypol)/(zakwalifikowanypol+niezakwalifikowanypol+niezakwalifikowanypol+niezakwalifikowanypol);
            System.out.println("dokladnosc to "+dokladnoscpol*100+"%");
            int precyzjapol = (zakwalifikowanypol/(zakwalifikowanypol+niezakwalifikowanypol));
            System.out.println("precyzja to "+precyzjapol);
            int pelnoscpol = (zakwalifikowanypol/(zakwalifikowanypol+niezakwalifikowanypol));
            System.out.println("pelnosc to "+pelnoscpol);
            int fpol = ((2*precyzjapol*pelnoscpol)/(precyzjapol+pelnoscpol));
            System.out.println("fmiara to "+fpol);
            System.out.println();

        } else if (wczytana == 2) {
            System.out.println("podaj tekst w celu sprawdzenia języka ");
            StringBuilder text = new StringBuilder();
            String linia;
            scanner.nextLine();
            while((linia=scanner.nextLine()).length()>1){
                text.append(linia);
            }
            System.out.println(linia);

            Data data = new Data();
            data.loadFromString(text.toString());
            System.out.print("język to ---> ");
            if (englishperceptron.liczNet(data) == 1)
                System.out.print("angielski ");
            if (polishperceptron.liczNet(data) == 1)
                System.out.print("polski ");
            if (germanperceptron.liczNet(data) == 1)
                System.out.print("niemiecki ");
        }
    }

    public static void załadujdane(String path, ArrayList dataList, String resault, int resaultInt, int count) {
        for (int i = 1; i < count + 1; i++) {
            Data data = new Data();
            data.załadujzpliku(path + "/" + i + ".txt");
            data.setResault(resault);
            data.setResaultInt(resaultInt);
            dataList.add(data);
        }
    }
}