package code.yuki.game.file.util;

import java.io.File;
import java.nio.file.Path;

public class GameSettingsApplier {

    public static boolean applySetting(String fileName, String path) {

        return false;
    }

    public static boolean applySetting(File file) {

        return applySetting(file.getName(), file.getAbsolutePath());
    }

    public static boolean applySetting(String fileName, Path path) {
        return applySetting(fileName, path.toAbsolutePath().toString());
    }


}
