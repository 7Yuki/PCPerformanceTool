package code.yuki.game.valorant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@AllArgsConstructor
public enum GameSettingsFile {
    GAME_USER(null),
    RIOT_USER(null);

    @Getter @Setter
    public File file;
}
