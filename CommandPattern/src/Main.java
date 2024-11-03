import domain.Player;
import repository.PlayerRepository;
import service.receive.Receiver;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private final static PlayerRepository playerRepository = PlayerRepository.getInstance();

    public static void main(String[] args) throws IOException {
        Player player = playerRepository.loadPlayerInfo();
        Receiver receiver = new Receiver(player);

        try(Scanner scanner = new Scanner(System.in)) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.isEmpty()) continue;

                receiver.executeCommand(Integer.parseInt(line));
            }

        }

    }

}
