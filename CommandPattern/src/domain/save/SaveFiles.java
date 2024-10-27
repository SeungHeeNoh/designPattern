package domain.save;

import domain.Player;

import java.util.Stack;

public class SaveFiles {
    private final static Stack<SaveFile> saveFiles = new Stack<>();

    public void createSaveFile(Player player) {
        SaveFile save = player.getPlayerSaveFile();
        System.out.println("save file : " + save.toString());
        saveFiles.push(save);
    }

    public void reloadSaveFile(Player player) {
        if(!saveFiles.isEmpty()) {
            player.usePlayerSaveFile(saveFiles.pop());
        } else {
            System.out.println("save file is not exist.");
        }

    }
}
