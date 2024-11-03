package domain.save;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import domain.Player;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class SaveFiles {
    @JsonSerialize(using = SaveFilesSerializer.class)
    private final Stack<SaveFile> saveFiles = new Stack<>();

    public void createSaveFile(Player player) {
        SaveFile save = player.getPlayerSaveFile();
        System.out.println("save file : " + save.toString());
        saveFiles.push(save);
    }

    public void reloadSaveFile(Player player) {
        if(!saveFiles.isEmpty()) {
            player.usePlayerSaveFile(saveFiles.pop());
        } else {
            System.out.println("save file is not exist.");
        }
    }

    public static class SaveFilesSerializer extends JsonSerializer<Stack<SaveFile>> {

        @Override
        public void serialize(Stack<SaveFile> saveFiles, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartArray();
            for (SaveFile saveFile : saveFiles) {
                jsonGenerator.writeObject(saveFile);
            }
            jsonGenerator.writeEndArray();
        }
    }
}
