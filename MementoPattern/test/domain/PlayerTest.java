package domain;

import domain.stat.Experience;
import domain.stat.level.PlayerLevel;
import domain.stat.level.PlayerLevels;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PlayerTest {

    Player player;

    @BeforeEach
    void setUp() {
        player = new Player("nsh");
    }

    @Test
    void IllegalExp() {
        // given

        // when && then
        assertThatThrownBy(() -> player.adjustExp(-9000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("experience must be greater than or equal to 0");
    }

    @Test
    void IllegalLevel() {
        // given

        // when && then
        assertThatThrownBy(() -> PlayerLevels.getNextLevel(new Temp(), new Experience(999)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 레벨 정보입니다.");
    }

    class Temp extends PlayerLevel {

        @Override
        public int getMinExp() {
            return 0;
        }

        @Override
        public int getMaxExp() {
            return 0;
        }

        @Override
        public void walk() {

        }

        @Override
        public void jump() {

        }

        @Override
        public void run() {

        }
    }


}