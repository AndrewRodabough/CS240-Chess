import chess.*;
import dataAccess.MySqlDataAccess;
import server.Server;

public class Main {
    public static void main(String[] args) {
        try {
            int port = 6969;
            if (args.length >= 1) {
                port = Integer.parseInt(args[0]);
            }

            var server = new Server().run(port);
            port = server.port();
            System.out.printf("Server started on port %d%n", port);
            return;
        } catch (Throwable ex) {
            System.out.printf("Unable to start server: %s%n", ex.getMessage());
        }
        System.out.println("""
                Pet Server:
                java ServerMain <port> [<dburl> <dbuser> <dbpassword> <dbname>]
                """);
    }
    }
}