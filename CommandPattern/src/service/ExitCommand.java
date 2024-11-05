package service;

import domain.Player;
import repository.PlayerRepository;

import java.io.IOException;

public class ExitCommand implements Command {

    private final Player player;
    private final static PlayerRepository playerRepository = PlayerRepository.getInstance();

    public ExitCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        try {
            playerRepository.savePlayerInfo(player);
            System.out.println("게임을 종료합니다.");
            ExitHelper.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("데이터 저장에 실패했습니다.");
        }
    }

    private class ExitHelper {
        public static void exit(int status) {
            System.exit(status);
        }
    }
}
