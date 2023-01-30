package code.yuki.game.overwatch;

import code.yuki.game.error.AddMissingSetting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class LookUpOverwatchSetting {

    public String lookUpSetting(OverwatchSetting setting) {

        try {
            return lookUpSetting(setting.getSettingName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String prettyPrint(OverwatchSetting setting) {
        return setting.getCleanSettingName() + ": " + lookUpSetting(setting);
    }


    private String lookUpSetting(String settingName) throws IOException {
        System.out.println("Setting Name: " + settingName);
        File file = OverwatchFileInfo.getOverwatchSettingsFileLocation();
        System.out.println(file.getAbsolutePath());

        List<String> linesInFile = Files.readAllLines(file.toPath().toAbsolutePath());

        if (linesInFile.contains(settingName)) {
            return linesInFile.get(linesInFile.lastIndexOf(settingName));
        } else {

            System.out.println("Settings file doesn't contain the setting we were looking for. Adding it now.");
            AddMissingSetting.addOverwatchSetting(settingName);
            System.out.println("Added!");
            System.out.println("Attempting process again!");
            lookUpSetting(settingName);
        }

        System.out.println("???????????");
        //AddMissingSetting.addSetting(settingName, "RiotUserSettings.ini");
        return null;
    }
}
