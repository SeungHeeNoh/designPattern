package service.receive;

import domain.Player;
import domain.command.*;

import java.util.HashMap;
import java.util.Map;

public class Receiver {
    Map<Integer, Command> commands = new HashMap<>(5);

    public Receiver(Player player) {
        WalkCommand walkCommand = new WalkCommand(player);
        JumpCommand jumpCommand = new JumpCommand(player);
        RunCommand runCommand = new RunCommand(player);
        DashCommand dashCommand = new DashCommand(player);
        FlyCommand flyCommand = new FlyCommand(player);

        commands.put(1, walkCommand);
        commands.put(2, jumpCommand);
        commands.put(3, runCommand);
        commands.put(4, dashCommand);
        commands.put(5, flyCommand);
    }

    public void executeCommand(int i) {
        try {
            commands.get(i).execute();
        } catch (NullPointerException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }
}
