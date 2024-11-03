import domain.Player;
import repository.PlayerRepository;
import controller.PlayerController;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private final static PlayerRepository playerRepository = PlayerRepository.getInstance();

    public static void main(String[] args) throws IOException {
        Player player = playerRepository.loadPlayerInfo();
        PlayerController playerController = new PlayerController(player);

        try(Scanner scanner = new Scanner(System.in)) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.isEmpty()) continue;

                playerController.executeCommand(Integer.parseInt(line));
            }

        }

    }

}
