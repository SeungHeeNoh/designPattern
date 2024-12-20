package service;

import domain.Player;

public class JumpCommand implements Command {

    private final Player player;

    public JumpCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.jump();
    }
}
