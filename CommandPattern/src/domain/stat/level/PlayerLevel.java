package domain.stat.level;

public abstract class PlayerLevel {

    public abstract int getMinExp();
    public abstract int getMaxExp();

    public abstract void walk();
    public abstract void jump();
    public abstract void run();

    public void dash() {
    }

    public void fly() {

    }

}
