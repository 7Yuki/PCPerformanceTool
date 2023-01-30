package code.yuki.game.overwatch;

import code.yuki.game.constants.Constants;

import java.io.File;

public class OverwatchFileInfo {
    public static File getOverwatchSettingsFileLocation() {
        return new File(Constants.USER_HOME + "\\Documents\\Overwatch\\Settings\\Settings_v0.ini");
    }
}
