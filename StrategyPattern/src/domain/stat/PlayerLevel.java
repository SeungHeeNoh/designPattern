package domain.stat;

public abstract class PlayerLevel {

    public abstract void walk();
    public abstract void jump();
    public abstract void run();
    public abstract int getMinExp();
    public abstract int getMaxExp();


    public void dash() {
    }

    public void fly() {

    }

    public void action(int count) {
        walk();

        for(int i=0; i<count; i++) {
            jump();
        }

        run();
        dash();
        fly();
    }
}
