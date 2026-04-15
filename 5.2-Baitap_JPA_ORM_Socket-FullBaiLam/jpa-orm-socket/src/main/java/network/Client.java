package network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try(Socket socket = new Socket("H81M27", 9090);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
        ){

            int choice = 0;
            Request request = null;

            while (true){
                System.out.println("==Menu==");
                System.out.println("1. Find company by id");
                System.out.println("2. List companies");
                System.out.println("3. List candidates by skills");

                choice = scanner.nextInt();

                switch (choice){
                    case 1 -> {
                        CommandType commandType = CommandType.COMPANY_FIND_BY_ID;
                        String companyId = "CP2";
                        request = Request.builder()
                                .commandType(commandType)
                                .data(companyId)
                                .build();

                    }
                    case 2 -> {
                        CommandType commandType = CommandType.COMPANY_LOAD_ALL;
                        request = Request.builder()
                                .commandType(commandType)
                                .build();
                    }
                    case 3 -> {
                        CommandType commandType = CommandType.APPLICATION_FIND_BY_SKILL;
                        String skill = "Java";
                        request = Request.builder()
                                .commandType(commandType)
                                .data(skill)
                                .build();
                    }
                }

                out.writeObject(request);
                out.flush();

                Response response = (Response) in.readObject();
                System.out.println(response);

            }


        }catch (Exception ex){
            throw new RuntimeException(ex);
        }

    }
}
