package code.yuki.game.error;

import code.yuki.game.overwatch.OverwatchSetting;
import code.yuki.game.valorant.ValorantFileInfo;
import code.yuki.game.valorant.ValorantSetting;
import code.yuki.init.SettingsFileContents;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddMissingSetting {

    public static void addOverwatchSetting(OverwatchSetting missingSetting) {
        addOverwatchSetting(missingSetting.getSettingName());
    }
    public static void addOverwatchSetting(String missingSettingName) {

    }
    public static void addValorantSetting(ValorantSetting missingSetting) {
        addValorantSetting(missingSetting.getExactSettingName(), missingSetting.getSettingsFileName());
    }

    public static void addValorantSetting(String missingSettingName, String fileName) {
        File settingsFile = new File(SettingsFileContents.VALORANT_CONFIG_FILE_LOCATION.getPathAsString() + ValorantFileInfo.getLastKnownUserDirectory() + "\\Windows\\" + fileName);
        System.out.println(settingsFile.getAbsolutePath());

        FileWriter fw;
        try {
            fw = new FileWriter(settingsFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("Writing: " + missingSettingName);
            bw.write("\n" + missingSettingName);
            System.out.println("Done!");
            bw.close();
            System.out.println("Closed writer!");
        } catch (IOException e) {
            System.out.println("Failed to write: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
