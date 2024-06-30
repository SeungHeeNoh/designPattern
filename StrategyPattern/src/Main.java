import domain.Player;

public class Main {
    public static void main(String[] args) {

        try {
            Player player = new Player("nsh");

            System.out.println(player.printPlayerLevel());
            player.action(5);

            System.out.println("========================");

            player.adjustExp(100);
            System.out.println(player.printPlayerLevel());
            player.action(5);

            System.out.println("========================");

            player.adjustExp(1000);
            System.out.println(player.printPlayerLevel());
            player.action(5);

            System.out.println("========================");

            player.adjustExp(2000);
            System.out.println(player.printPlayerLevel());
            player.action(5);

            System.out.println("========================");

            player.adjustExp(3000);
            System.out.println(player.printPlayerLevel());
            player.action(5);

            System.out.println("========================");

            player.adjustExp(4000);
            System.out.println(player.printPlayerLevel());
            player.action(5);

            System.out.println("========================");

            player.adjustExp(5000);
            System.out.println(player.printPlayerLevel());
            player.action(5);

            System.out.println("========================");

            player.adjustExp(9000);
            System.out.println(player.printPlayerLevel());
            player.action(5);

            System.out.println("========================");

            player.adjustExp(-9000);
            System.out.println(player.printPlayerLevel());
            player.action(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}