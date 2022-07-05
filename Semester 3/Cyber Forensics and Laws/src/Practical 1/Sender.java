import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

/**
 * Sender: Sends an encrypted message and generated key 
 * to the receiver.
 * Uses Sockets for communication.
 */
public class Sender {
    /**
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        int counter = 0;
        String cipherText = "", key = "";
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 6017);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Enter message: ");
            String message = scanner.nextLine();

            /*
             * Code for encryption.
             * Working:
             * 1. Generate an array of n (length of the message) random numbers.
             * 2. Add the codePoints of the message with the array sequentially.
             * 3. Append the typecasted character to the ciphertext.
             */
            int[] keyArray = new int[message.length()];
            for (char messagePart : message.toCharArray()) {
                keyArray[counter] = random.nextInt(50);
                key += Integer.valueOf(keyArray[counter]) + ":";
                cipherText += (char)(messagePart + keyArray[counter]);
                counter++;
            }

            System.out.println("Message: " + message);
            System.out.println("Generated key: " + key);
            System.out.println("Encrypted message: " + cipherText);

            dataOutputStream.writeUTF(cipherText);
            dataOutputStream.writeUTF(key);

            scanner.close();
            dataOutputStream.flush();
            dataOutputStream.close();
            socket.close();
        }
        catch (UnknownHostException e) {
            System.err.println("Error: Host not found.");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.err.println("IOError: Some I/O operations could not be performed.");
            e.printStackTrace();
        }
    }
}