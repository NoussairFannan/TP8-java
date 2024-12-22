import java.io.*;
import java.net.Socket;

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            out.println("Bienvenue sur le serveur de fichiers !");
            String fileName = in.readLine();
            System.out.println("Demande de fichier reçue : " + fileName);

            File file = new File(fileName);
            if (file.exists() && file.isFile()) {
                out.println("OK");
                try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = fileReader.readLine()) != null) {
                        out.println(line);
                    }
                }
                out.println("EOF");
                System.out.println("Fichier envoyé : " + fileName);
            } else {
                out.println("ERREUR : Fichier introuvable.");
                System.err.println("Fichier demandé introuvable : " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la communication avec le client : " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Erreur lors de la fermeture du socket client : " + e.getMessage());
            }
        }
    }
}