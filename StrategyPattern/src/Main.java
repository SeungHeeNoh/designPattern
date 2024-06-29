import domain.Player;

public class Main {
    public static void main(String[] args) {

        Player player = new Player("nsh");

        System.out.println(player.printPlayerLevel());
        player.action(5);
    }
}