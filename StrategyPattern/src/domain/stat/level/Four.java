package domain.stat.level;

import java.util.Objects;

public class Four extends PlayerLevel {

    public static final int MIN_EXP=3000;
    public static final int MAX_EXP=Five.MIN_EXP - 1;

    private final int level = 4;

    @Override
    public int getMinExp() {
        return MIN_EXP;
    }

    @Override
    public int getMaxExp() {
        return MAX_EXP;
    }

    @Override
    public void walk() {
        System.out.println("빠르게 걷습니다.");
    }

    @Override
    public void jump() {
        System.out.println("2단 점프!!");
    }

    @Override
    public void run() {
        System.out.println("엄청 빠르게 달립니다.");
    }

    @Override
    public void dash() {
        System.out.println("질주합니다.");
    }

    @Override
    public String toString() {
        return "Level 4";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof Four;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(level);
    }
}
