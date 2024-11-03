package domain.stat.level;

import domain.stat.Experience;

import java.util.List;

public class PlayerLevels {
    private final static List<PlayerLevel> levels = List.of(new One(), new Two(), new Three(), new Four(), new Five());

    private PlayerLevels() {}

    public static PlayerLevel getNextLevel(PlayerLevel nowLevel, Experience exp) {
        int startLevel = getNowLevelIndex(nowLevel);

        PlayerLevel nextLevel = levels.stream()
                .skip(startLevel)
                .filter(level -> level.getMinExp() <= exp.getExperience() && exp.getExperience() <= level.getMaxExp())
                .findFirst()
                .orElse(nowLevel);
        int endLevel = levels.indexOf(nextLevel);

        if(startLevel < endLevel) {
            for(int i = startLevel; i < endLevel; i++) {
                System.out.println("level up!! : " + levels.get(i).toString() + "->" + levels.get(i+1).toString());
            }
        }

        return nextLevel;
    }

    private static int getNowLevelIndex(PlayerLevel nowLevel) {
        int levelIndex = levels.indexOf(nowLevel);

        if(levelIndex < 0) {
            throw new IllegalArgumentException("잘못된 레벨 정보입니다.");
        }

        return levelIndex;
    }

    public static PlayerLevel getFirstLevel() {
        return levels.get(0);
    }

    public static int getMaxExperience() {
        return levels.get(levels.size() - 1).getMaxExp();
    }
}
