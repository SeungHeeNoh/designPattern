package domain.command;

import domain.Player;

public class FlyCommand implements Command {

    private final Player player;

    public FlyCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.fly();
    }
}
