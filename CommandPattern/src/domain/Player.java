package domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import domain.save.SaveFile;
import domain.save.SaveFiles;
import domain.stat.Experience;
import domain.stat.level.PlayerLevel;
import domain.stat.level.PlayerLevels;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Player {
    private String name;
    private PlayerLevel playerLevel = PlayerLevels.getFirstLevel();
    private final Experience exp = new Experience();
    private final SaveFiles saveFiles = new SaveFiles();

    /**
     * Player 정보
     */
    private Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int exp, List<SaveFile> saveFiles) {
        this.name = name;
        this.adjustExp(exp);
        this.saveFiles.init(saveFiles);
    }

    public String getName() {
        return name;
    }

    public String printPlayerLevel() {
        return playerLevel.toString();
    }

    /**
     * player 경험치 처리 
     */
    public void adjustExp(int exp) {
        System.out.println(exp + " 경험치를 얻었습니다.");

        if(this.exp.setExperience(exp)) {
            playerLevel = PlayerLevels.getNextLevel(playerLevel, this.exp);
        }
    }

    /**
     * player 동작 처리
     */
    public void walk() {
        playerLevel.walk();
    }

    public void jump() {
        playerLevel.jump();
    }

    public void run() {
        playerLevel.run();
    }

    public void dash() {
        playerLevel.dash();
    }

    public void fly() {
        playerLevel.fly();
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
