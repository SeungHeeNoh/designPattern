package domain.stat.level;

import java.util.Objects;

public class One extends PlayerLevel {

    public final static int MIN_EXP=0;
    public final static int MAX_EXP=Two.MIN_EXP-1;

    private final int level = 1;

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
        System.out.println("느리게 걷습니다.");
    }

    @Override
    public void jump() {

    }

    @Override
    public void run() {

    }

    @Override
    public String toString() {
        return "Level 1";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof One;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(level);
    }
}
