package code.yuki.init;

import code.yuki.game.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum SettingsFileContents {
    VALORANT_CONFIG_FILE_LOCATION(Constants.DEFAULT_VALORANT_CONFIG_PATH),
    OVERWATCH_CONFIG_FILE_LOCATION(Constants.DEFAULT_OVERWATCH_SETTINGS_FILE);

    @Getter @Setter
    private String pathAsString;
}
