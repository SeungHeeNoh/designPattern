package domain.save;

import domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SaveFilesTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("test");
    }

    @Test
    void givenOneMemento_whenReloadOneMemento_thenReloadOneMemento() {
        // given
        assertThat(player.printPlayerLevel())
                .isEqualTo("Level 1");

        player.save();
        player.adjustExp(5000);
        assertThat(player.printPlayerLevel())
                .isEqualTo("Level 5");

        // when
        System.out.println("reload save file");
        player.restore();

        // then
        assertThat(player.printPlayerLevel())
                .isEqualTo("Level 1");
    }

    @Test
    void givenMementos_whenReloadMementos_thenReloadMementos() {
        // given
        assertThat(player.printPlayerLevel())
                .isEqualTo("Level 1");

        player.save();
        player.adjustExp(1000);
        assertThat(player.printPlayerLevel())
                .isEqualTo("Level 2");

        player.save();
        player.adjustExp(2000);
        assertThat(player.printPlayerLevel())
                .isEqualTo("Level 4");

        // when - then
        System.out.println("reload save file");
        player.restore();

        assertThat(player.printPlayerLevel())
                .isEqualTo("Level 2");

        System.out.println("reload save file");
        player.restore();

        assertThat(player.printPlayerLevel())
                .isEqualTo("Level 1");
    }

    @Test
    void givenNoSaveFile_whenReloadMemento_thenDoNothing() {
        // given
        assertThat(player.printPlayerLevel())
                .isEqualTo("Level 1");

        // when - then
        System.out.println("reload save file");
        player.restore();

        assertThat(player.printPlayerLevel())
                .isEqualTo("Level 1");
    }
}