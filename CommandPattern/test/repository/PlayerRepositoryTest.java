package repository;

import domain.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerRepositoryTest {

    private final String filePath = "player.json";


    @AfterEach
    void cleanup() {
        // 테스트가 끝난 후 파일 삭제
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }
    @Test
    void givenSaveFile_whenSavePlayerInfo_thenSaveJsonFile() throws IOException {
        Player player = new Player("witch");
        player.adjustExp(500);
        player.save();
        player.adjustExp(5000);
        player.save();

        PlayerRepository.getInstance().savePlayerInfo(player);

        File file = new File(filePath);
        assertTrue(file.exists(), "파일이 생성되지 않았습니다.");

        String fileContent = Files.readString(Path.of(filePath));
        System.out.println(fileContent);
        Player loadedPlayer = PlayerRepository.getInstance().loadPlayerInfo();

        // 저장된 내용이 예상한 Player 객체와 일치하는지 검증
        assertEquals(player.getName(), loadedPlayer.getName());
        loadedPlayer.restore();
        loadedPlayer.walk();
        loadedPlayer.jump();
        loadedPlayer.run();

        loadedPlayer.restore();
        loadedPlayer.walk();
        loadedPlayer.jump();
        loadedPlayer.run();
    }
}