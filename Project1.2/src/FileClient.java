import java.io.*;
import java.net.*;

public class FileClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println(in.readLine());

            System.out.print("Entrez le nom du fichier à demander : ");
            String fileName = consoleReader.readLine();
            out.println(fileName);

            String serverResponse = in.readLine();
            if ("OK".equals(serverResponse)) {
                System.out.println("Contenu du fichier reçu :");
                String line;
                while (!(line = in.readLine()).equals("EOF")) {
                    System.out.println(line);
                }
            } else {
                System.err.println(serverResponse);
            }
        } catch (IOException e) {
            System.err.println("Erreur client : " + e.getMessage());
        }
    }
}
