package domain.stat.level;

import domain.stat.PlayerLevel;

public class Two extends PlayerLevel {

    public final static int MIN_EXP=1000;
    public final static int MAX_EXP=Three.MIN_EXP - 1;

    @Override
    public void walk() {
        System.out.println("느리게 걷습니다.");
    }

    @Override
    public void jump() {
        System.out.println("1단 점프!!");
    }

    @Override
    public void run() {
        System.out.println("느리게 달립니다.");
    }

    @Override
    public int getMinExp() {
        return MIN_EXP;
    }

    @Override
    public int getMaxExp() {
        return MAX_EXP;
    }

    @Override
    public String toString() {
        return "레벨 2";
    }
}
