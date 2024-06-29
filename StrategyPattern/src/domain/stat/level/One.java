package domain.stat.level;

import domain.stat.PlayerLevel;

public class One extends PlayerLevel {

    public final static int MIN_EXP=0;
    public final static int MAX_EXP=Two.MIN_EXP-1;

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
    public int getMinExp() {
        return MIN_EXP;
    }

    @Override
    public int getMaxExp() {
        return MAX_EXP;
    }

    @Override
    public String toString() {
        return "레벨 1";
    }


}
