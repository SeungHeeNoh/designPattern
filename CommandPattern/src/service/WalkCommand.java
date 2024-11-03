package service;

import domain.Player;

public class WalkCommand implements Command {

    private final Player player;

    public WalkCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.walk();
    }
}
