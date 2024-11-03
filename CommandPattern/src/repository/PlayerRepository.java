package repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Player;
import domain.save.SaveFile;
import domain.stat.Experience;
import domain.stat.level.PlayerLevel;
import domain.stat.level.PlayerLevels;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final PlayerRepository instance;

    private final String filePath = "player.json";

    static {
        instance = new PlayerRepository();
    }

    private PlayerRepository() {}

    public static PlayerRepository getInstance() {
        return instance;
    }

    public void savePlayerInfo(Player player) throws IOException {
        mapper.writeValue(new File(filePath), player);
    }

    public Player loadPlayerInfo() throws IOException {
        JsonNode rootNode = mapper.readTree(new File(filePath));

        // JSON 문자열을 JSONObject로 파싱
        String name = rootNode.get("name").asText();
        int exp = rootNode.get("exp").get("experience").asInt();
        JsonNode playerSaveFileNodes = rootNode.get("saveFiles").get("saveFiles");
        List<SaveFile> playerSaveFile = new ArrayList<>();

        for(JsonNode node : playerSaveFileNodes) {
            Experience saveExp = mapper.convertValue(node.get("exp"), Experience.class);
            int levelExp = node.get("playerLevel").get("minExp").asInt();

            PlayerLevel savePlayerLevel = PlayerLevels.getNextLevel(PlayerLevels.getFirstLevel(), new Experience(levelExp));
            SaveFile saveFile = new SaveFile(saveExp, savePlayerLevel);

            playerSaveFile.add(saveFile);
        }

        return new Player(name, exp, playerSaveFile);
    }
}
