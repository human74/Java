package zad1;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Angielski {

    public static void main(String[] arg){
        int ANGServerPort = 5003;
        Angielski angServer = new Angielski();
        angServer.server(ANGServerPort);
    }

    private Socket socket = null;
    private Socket socketSend = null;
    private ServerSocket serversocket = null;
    private DataInputStream inDataInputServer = null;
    private DataInputStream inputdataServer = null;
    private DataOutputStream outputdataServer = null;

    private Map<String, String> mapWords = Map.of
            ("auto", "car",
             "rower", "bike",
             "samolot", "plane",
             "tir", "truck");

    public void server(int port) {

        try {
            serversocket = new ServerSocket(port);
            System.out.println("Server angielski wystartował");
            System.out.println("Oczekiwanie na klienta");

            String line = "";
            while (!line.equals("Koniec")) {
                socket = serversocket.accept();
                System.out.println("Akceptacja klienta");
                inDataInputServer = new DataInputStream(
                        new BufferedInputStream(socket.getInputStream()));
                line = inDataInputServer.readUTF();
                String[] splitLine = line.split(";");
                System.out.println("serwwer rus staje sie klientem");
                socketSend = new Socket("localhost", Integer.parseInt(splitLine[1]));
                inputdataServer = new DataInputStream(System.in);
                outputdataServer = new DataOutputStream(socketSend.getOutputStream());
                try {
                    outputdataServer.writeUTF(mapWords.get(splitLine[0]));
                }catch (NullPointerException a){
                    outputdataServer.writeUTF("Slowa nie znaleziono w slowniku Angielskim");
                }
            }
            System.out.println("Koniec połączenia");
            socket.close();
            inDataInputServer.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }
}