import java.io.*;

public class Data {

    int[] info;//0-a,1-b...
    int liczlitery;
    String resault;
    int resaultInt;

    public void załadujzpliku(String fileName) {
        int[] tablicaliter = new int[26];
        try {
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
            while (bufferedreader.ready()) {
                int litera = bufferedreader.read();
                if (litera < 97)
                    litera += 32;
                if(litera>96 && litera<123) {
                    tablicaliter[litera - 97]++;
                    liczlitery++;
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        info=tablicaliter;
    }
        //użytkownika dane
    public void loadFromString(String text){
        int [] litery=new int[26];
        for(int i=0;i<text.length();i++){
            int litera=(int)text.charAt(i);
            if (litera < 97)
                litera += 32;
            if(litera>96 && litera<123) {
                litery[litera - 97]++;
                liczlitery++;
            }
            info=litery;
        }
    }

    public int[] getInfo() {
        return info;
    }

    public void setInfo(int[] info) {
        this.info = info;
    }

    public String getResault() {
        return resault;
    }

    public void setResault(String resault) {
        this.resault = resault;
    }

    public int getResaultInt() {
        return resaultInt;
    }

    public void setResaultInt(int resaultInt) {
        this.resaultInt = resaultInt;
    }
}