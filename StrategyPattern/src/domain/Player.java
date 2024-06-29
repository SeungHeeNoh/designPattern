package domain;

import domain.stat.PlayerLevel;
import domain.stat.level.*;

public class Player {
    private String name;
    private PlayerLevel playerLevel = new One();
    private int exp = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String printPlayerLevel() {
        return playerLevel.toString();
    }

    public void adjustExp(int exp) {
        exp += exp;
    }

    public void action(int count) {
        playerLevel.action(count);
    }
}
