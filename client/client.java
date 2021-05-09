
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

class C {

    private static Socket socket;

    public static void main(String args[]) {
        try {
            String host = args[0];
            int port = 5025;
            //InetAddress address = InetAddress.getByName(host);
            socket = new Socket(host, port);
            String s;

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            FileWriter fw = new FileWriter("client-data/history.txt", true);

            Scanner in = new Scanner(System.in);
            System.out.println("Enter a string");
            s = in.nextLine();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            while (!s.equals("END")) { // verify the syntax

                String sendMessage = s + "\n";
                bw.write(sendMessage);
                bw.flush();
                System.out.println("Message sent to the server : " + sendMessage);
                try {
                    fw.write(sendMessage + "\n");
                    fw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Get the return message from the server

                BufferedReader br = new BufferedReader(isr);
                String message = br.readLine();
                System.out.println("Message received from the server : " + message);

                if (s.equals("STOP")) // verify
                    break;

                System.out.println("Enter a string");
                s = in.nextLine();

            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            // Closing the socket
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
