package code.yuki.game.file.util;

import java.io.File;
import java.nio.file.Path;

public class GameSettingsFileReader {

    public static void readFile(String fileName, String path) {

    }

    public static void readFile(File file) {
        readFile(file.getName(), file.getAbsolutePath());
    }

    public static void readFile(String fileName, Path path) {
        readFile(fileName, path.toAbsolutePath().toString());
    }

    public static String getSettingValue(File settingsFile, String settingName) {

        return "";
    }

    public static int getIntegerSettingValue(File settingsFile, String settingName) {

        return 0;
    }

    public static boolean getBooleanSettingValue(File settingsFile, String settingName) {

        return false;
    }




}
