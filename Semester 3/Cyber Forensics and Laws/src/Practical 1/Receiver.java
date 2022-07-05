import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Receiver: Receives an encrypted message and key from the sender
 * and decrypts it.
 * Uses Sockets for communication.
 */
public class Receiver {
    public static void main(String[] args) {
        String message = "";
        int counter = 0;

        try {
            ServerSocket serverSocket = new ServerSocket(6017);
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String cipherText = dataInputStream.readUTF();
            String key = dataInputStream.readUTF();

            /*
             * Code for decryption.
             * Working:
             * 1. Split the key string using the ':' delimiter and convert it into an integer.
             * 2. Subtract the array values from the codePoints sequentially.
             * 3. Append the typecasted character to the message.
             */
            int[] keyArray = new int[cipherText.length()];
            for (String keyPart : key.split(":")) {
                keyArray[counter] = Integer.parseInt(keyPart);
                message += (char)(cipherText.charAt(counter) - keyArray[counter]);
                counter++;
            }

            System.out.println("Ciphertext: " + cipherText);
            System.out.println("Key: " + key);
            System.out.println("Message: " + message);

            dataInputStream.close();
            socket.close();
            serverSocket.close();
        }
        catch (IOException e) {
            System.err.println("IOError: Some I/O operations could not be performed");
            e.printStackTrace();
        }
    }
}