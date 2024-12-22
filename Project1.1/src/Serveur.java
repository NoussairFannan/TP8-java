import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import static java.lang.Math.random;

public class Serveur {
    static int nmbMagic = (int) (random() * 101);

    public static void main(String[] args) {
        System.out.println("Serveur : Nombre magique généré : " + nmbMagic);

        try (ServerSocket serverSocket = new ServerSocket(123)) {
            Socket client = serverSocket.accept();
            System.out.println("Serveur : Client connecté.");

            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            PrintWriter writer = new PrintWriter(out, true);

            boolean guessed = false;
            while (!guessed) {
                String clientMessage = reader.readLine(); // Lire la réponse du client
                if (clientMessage == null) break;

                int guess = Integer.parseInt(clientMessage);
                if (guess == nmbMagic) {
                    writer.println("Bravo ! Vous avez deviné le nombre.");
                    guessed = true;
                } else if (guess < nmbMagic) {
                    writer.println("Trop petit !");
                } else {
                    writer.println("Trop grand !");
                }
            }

            System.out.println("Serveur : Jeu terminé.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
