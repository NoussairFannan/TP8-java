import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 123);
             InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(in));
             PrintWriter writer = new PrintWriter(out, true)) {

            Scanner scanner = new Scanner(System.in);
            boolean gameRunning = true;

            while (gameRunning) {
                System.out.print("Entrez un nombre entre 0 et 100 : ");
                int guess = scanner.nextInt();
                writer.println(guess); // Envoyer le nombre au serveur

                String serverResponse = reader.readLine(); // Lire la réponse du serveur
                System.out.println("Serveur : " + serverResponse);

                if (serverResponse.contains("Bravo")) {
                    gameRunning = false; // Terminer si le nombre est deviné
                }
            }

            System.out.println("Client : Jeu terminé.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
