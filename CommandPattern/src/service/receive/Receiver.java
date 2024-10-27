package service.receive;

import domain.Player;
import domain.command.*;

import java.util.HashMap;
import java.util.Map;

public class Receiver {
    Map<Integer, Command> commands = new HashMap<>(5);

    public static final int WALK_COMMAND_ID = 1;
    public static final int JUMP_COMMAND_ID = 2;
    public static final int RUN_COMMAND_ID = 3;
    public static final int DASH_COMMAND_ID = 4;
    public static final int FLY_COMMAND_ID = 5;

    public Receiver(Player player) {
        WalkCommand walkCommand = new WalkCommand(player);
        JumpCommand jumpCommand = new JumpCommand(player);
        RunCommand runCommand = new RunCommand(player);
        DashCommand dashCommand = new DashCommand(player);
        FlyCommand flyCommand = new FlyCommand(player);

        commands.put(WALK_COMMAND_ID, walkCommand);
        commands.put(JUMP_COMMAND_ID, jumpCommand);
        commands.put(RUN_COMMAND_ID, runCommand);
        commands.put(DASH_COMMAND_ID, dashCommand);
        commands.put(FLY_COMMAND_ID, flyCommand);
    }

    public void executeCommand(int i) {
        try {
            commands.get(i).execute();
        } catch (NullPointerException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }
}
