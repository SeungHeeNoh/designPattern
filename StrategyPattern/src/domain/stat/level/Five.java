package domain.stat.level;

import domain.stat.PlayerLevel;

public class Five extends PlayerLevel {

    public static final int MIN_EXP=5000;
    public static final int MAX_EXP=9999;

    @Override
    public void walk() {
        System.out.println("빠르게 걷습니다.");
    }

    @Override
    public void jump() {
        System.out.println("3단 점프!!");
    }

    @Override
    public void run() {
        System.out.println("엄청 빠르게 달립니다.");
    }

    @Override
    public void dash() {
        System.out.println("쾌속질주합니다.");
    }

    @Override
    public void fly() {
        System.out.println("창공을 납니다.");
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
        return "레벨 5";
    }
}
