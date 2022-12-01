package code.yuki.game.valorant;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ApplyValorantSettings {

    public void applyIntSetting(ValorantSetting setting, int i) {
        File settingsFile = setting.getSettingsFile().getFile();
        String settingIntToString = String.valueOf(i);
        String baseOldValue = ReadValorantSettings.lookUpSetting(setting);
        char endChar = baseOldValue.charAt(baseOldValue.length() - 1);
        String newValue = baseOldValue.replace(endChar, String.valueOf(i).charAt(0));
        System.out.println("Old Value: " + baseOldValue);
        System.out.println("New Value: " + newValue);

        try (FileInputStream is = new FileInputStream(settingsFile)) {
            String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            content = content.replaceAll("(?i:" + baseOldValue + ").*", newValue);
            try (FileWriter fw = new FileWriter(settingsFile)) {
                fw.write(content);
            }
            if (content.contains(newValue)) {
                System.out.println("Success!");
            } else {
                System.out.println("Unsuccessful :(");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void applyBooleanSetting(ValorantSetting setting, boolean bool) {
        File settingsFile = setting.getSettingsFile().getFile();


        String settingBooleanToString = String.valueOf(bool);
        String oldValue = ReadValorantSettings.lookUpSetting(setting);
        if (settingsFile == null) return;

        Scanner scanner;
        try {
            scanner = new Scanner(settingsFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String s;
        while (scanner.hasNext()) {
            s = scanner.nextLine().toLowerCase();
            if (!s.contains("=")) break;
            if (s.contains(setting.getLookUpName().toLowerCase())) {
                System.out.println("Current Value: " + s);
                String newValue = s.replace(oldValue, settingBooleanToString);
                System.out.println("New Value: " + newValue);
                if (newValue.contains(settingBooleanToString)) {
                    System.out.println("Successful!");
                } else {
                    System.out.println("Unsuccessful, ending process");
                }
                break;

            }
        }
    }
}
