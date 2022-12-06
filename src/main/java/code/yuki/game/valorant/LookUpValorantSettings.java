package code.yuki.game.valorant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LookUpValorantSettings {


    public String lookUpSetting(ValorantSetting setting) {
        return lookUpSetting(setting.getLookUpName(), setting.getSettingsFileName());
    }

    public boolean lookUpSettingValueBoolean(ValorantSetting setting) {
        String settingString = lookUpSetting(setting);
        String[] arr = settingString.split("=");
        return Boolean.parseBoolean(arr[1]);
    }

    public int lookUpSettingValueInt(ValorantSetting setting) {

        String settingString = lookUpSetting(setting);
        String[] arr = settingString.split("=");
        return Integer.parseInt(arr[1]);
    }

    public double lookUpSettingValueDouble(ValorantSetting setting) {

        String settingString = lookUpSetting(setting);
        String[] arr = settingString.split("=");
        return Double.parseDouble(arr[1]);
    }

    private String lookUpSetting(String settingName, String settingsFileName) {
        File file = ValorantFileInfo.getValorantSettingsFile(settingsFileName);
        if (file == null) return null;
        Scanner scanner;
        String s;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scanner.hasNext()) {
            s = scanner.nextLine();
            if (s.toLowerCase().contains(settingName)) {
                return s;
            }
        }
        return null;
    }

    public void printOutSettingStatus(ValorantSetting setting) {
        final String value = lookUpSetting(setting).split("=")[1];
        System.out.printf("%s: %s%n", setting.getName(), value);
    }
}
