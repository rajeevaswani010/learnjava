package org.learnjava.filetransfer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void start() {
        try(Socket socket = new Socket("localhost",5000)){
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while (true) {
                System.out.print("input> ");
                String message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
                if(message.equalsIgnoreCase("exit()"))
                    break;
            }

        }catch (Exception e){
            System.out.println(e.toString());
        }    	
    }
}
