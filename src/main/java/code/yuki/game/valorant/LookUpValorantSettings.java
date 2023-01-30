package code.yuki.game.valorant;

import code.yuki.game.error.AddMissingSetting;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class LookUpValorantSettings {


    public String lookUpSettingToString(ValorantSetting setting) {
        try {
            return lookUpSettingToString(setting.getExactSettingName(), setting.getSettingsFileName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean lookUpSettingValueBoolean(ValorantSetting setting) {
        String settingString = lookUpSettingToString(setting);
        String[] arr = settingString.split("=");
        return Boolean.parseBoolean(arr[1]);
    }

    public int lookUpSettingValueInt(ValorantSetting setting) {

        String settingString = lookUpSettingToString(setting);
        String[] arr = settingString.split("=");
        return Integer.parseInt(arr[1]);
    }

    public double lookUpSettingValueDouble(ValorantSetting setting) {

        String settingString = lookUpSettingToString(setting);
        String[] arr = settingString.split("=");
        return Double.parseDouble(arr[1]);
    }

    public String prettyPrint(ValorantSetting setting) {
        return setting.getName() + ": " + lookUpSettingToString(setting);
    }


    private String lookUpSettingToString(String settingName, String settingsFileName) throws IOException {
        System.out.println("Setting Name: " + settingName);
        File file = ValorantFileInfo.getValorantSettingsFile(settingsFileName);
        if (file == null) return null;
        System.out.println(file.getAbsolutePath());

        List<String> linesInFile = Files.readAllLines(file.toPath().toAbsolutePath());

        if (linesInFile.contains(settingName)) {
            return linesInFile.get(linesInFile.lastIndexOf(settingName));
        } else {

            System.out.println("Settings file doesn't contain the setting we were looking for. Adding it now.");
            AddMissingSetting.addValorantSetting(settingName, settingsFileName);
            System.out.println("Added!");
            System.out.println("Attempting process again!");
            lookUpSettingToString(settingName,settingsFileName);
        }
        System.out.println("???????????");
        return null;
    }

    public void printOutSettingStatus(ValorantSetting setting) {
        final String value = lookUpSettingToString(setting).split("=")[1];
        System.out.printf("%s: %s%n", setting.getName(), value);
    }
}
