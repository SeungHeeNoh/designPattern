package domain;

import domain.save.SaveFile;
import domain.save.SaveFiles;
import domain.stat.Experience;
import domain.stat.level.PlayerLevel;
import domain.stat.level.PlayerLevels;

public class Player {
    private String name;
    private PlayerLevel playerLevel;
    private final Experience exp;
    private final SaveFiles saveFiles;

    public Player(String name) {
        this.name = name;
        this.playerLevel = PlayerLevels.getFirstLevel();
        this.exp = new Experience();
        this.saveFiles = new SaveFiles();
    }

    public String getName() {
        return name;
    }

    public String printPlayerLevel() {
        return playerLevel.toString();
    }

    public void adjustExp(int exp) {
        System.out.println(exp + " 경험치를 얻었습니다.");

        if(this.exp.setExperience(exp)) {
            playerLevel = PlayerLevels.getNextLevel(playerLevel, this.exp);
        }
    }

    public void action(int count) {
        playerLevel.action(count);
    }


    /**
     * player save/reload 처리
     */
    public void save() {
        saveFiles.createSaveFile(this);
    }

    public void restore() {
        saveFiles.reloadSaveFile(this);
    }

    public SaveFile getPlayerSaveFile() {
        return new SaveFile(exp.copy(), playerLevel);
    }

    public void usePlayerSaveFile(SaveFile saveFile) {
        this.playerLevel = saveFile.playerLevel();
        this.exp.restore(saveFile.exp());
    }
}
