package zad1;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class HeadServer {

    public static void main(String args[]) {
        int headServerPort = 5000;
        HeadServer headServer = new HeadServer();
        headServer.server(headServerPort);
    }

    private Socket socket = null;
    private Socket socketSend = null;
    private ServerSocket serversocket = null;
    private DataInputStream inDataInputServer = null;
    private DataInputStream inputdataServer = null;
    private DataOutputStream outputdataServer = null;

    public static Map<String, Integer> mapServer = Map.of
            ("RUS", 5001,
             "FR", 5002,
             "ANG", 5003);

    public void server(int port) {
        try {
            serversocket = new ServerSocket(port);
            System.out.println("Serwer główny został uruchomiony");
            System.out.println("Oczekiwanie na klienta");
            socket = serversocket.accept();
            inDataInputServer = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            System.out.println("Akceptacja klienta");
            String line = "";
            while (!line.equals("Koniec")) {
                line = inDataInputServer.readUTF();
                String[] splitLine = line.split(";");

                System.out.println();
                try {
                    socketSend = new Socket("localhost", mapServer.get(splitLine[0]));
                    inputdataServer = new DataInputStream(System.in);
                    outputdataServer = new DataOutputStream(socketSend.getOutputStream());
                    outputdataServer.writeUTF(splitLine[1] + ";" + splitLine[2]);
                    System.out.println("head dziala");
                }catch (NullPointerException a){
                    System.out.println("Koniec połączenia");
                }
            }
            socket.close();
            inDataInputServer.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }
}