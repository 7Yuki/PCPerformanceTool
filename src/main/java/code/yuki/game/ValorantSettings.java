package code.yuki.game;

import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

public class ValorantSettings {

    @Getter
    private int antiAliasingQuality;
    @Getter
    private int shadowQuality;
    @Getter
    private int shadingQuality;
    @Getter
    private int foliageQuality;
    @Getter
    private int effectsQuality;
    @Getter
    private int postProcessQuality;
    @Getter
    private int viewDistanceQuality;
    @Getter
    private double resolutionQuality;
    @Getter
    private int gameSettingTextureQuality;
    @Getter
    private int materialQuality;
    @Getter
    private int riotSettingTextureQuality;
    @Getter
    private int detailQuality;
    @Getter
    private int uiQuality;
    @Getter
    private int bloomQuality;
    @Getter
    private boolean shadowsEnabled;
    @Getter
    private boolean rawInputEnabled;

    private final String lastKnownUser = getLastKnownUser();
    private final String lastKnownUserDirectory = getLastKnownUserDirectory();


    public ValorantSettings() throws FileNotFoundException {
        readGameUserSettings();
        readRiotUserSettings();
    }

    public String getLastKnownUserDirectory() {
        File dirPath = new File(System.getProperty("user.home") + "\\AppData\\Local\\VALORANT\\Saved\\Config");
        FilenameFilter filter = (dir, name) -> name.toLowerCase().contains(lastKnownUser);
        String[] dirList = dirPath.list(filter);
        if (dirList != null) {
            System.out.println("bruh " + dirList[0]);

            return dirList[0];
        }
        return null;
    }

    private String getLastKnownUser() throws FileNotFoundException {
        final File lastKnownUserFile = new File(System.getProperty("user.home") + "\\AppData\\Local\\VALORANT\\Saved\\Config\\Windows\\RiotLocalMachine.ini");
        System.out.println("Riot Local Machine File Path: " + lastKnownUserFile.getAbsolutePath());
        System.out.println("Attempting to access " + lastKnownUserFile.getName() + "...");
        Scanner scanner = new Scanner(lastKnownUserFile);
        String s;
        while (scanner.hasNext()) {
            s = scanner.nextLine().toLowerCase();
            if (s.contains("lastknownuser")) {
                System.out.println("File Accessed Successfully!");
                String[] arr = s.split("=");
                System.out.println("Last Known User raw output: " + s);
                System.out.println("Split output: " + arr[0] + " and " + arr[1]);
                if (arr[1] != null) {
                    return arr[1];
                }
            }
        }
        return null;
    }

    private void readRiotUserSettings() throws FileNotFoundException {
        File file = new File(System.getProperty("user.home") + "\\AppData\\Local\\VALORANT\\Saved\\Config\\"+ lastKnownUserDirectory +"\\Windows\\RiotUserSettings.ini");
        Scanner scanner = new Scanner(file);
        String s;
        while (scanner.hasNext()) {
            s = scanner.nextLine().toLowerCase();
            if (!s.contains("=") || !(s.contains("rawinputbuffer") || s.contains("quality") || s.contains("shadow"))) continue;
            String[] arr = s.split("=");
            if (s.contains("materialquality")) {
                materialQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains("texturequality")) {
                riotSettingTextureQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains("detailquality")) {
                detailQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains("uiquality")) {
                uiQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains("bloomquality")) {
                bloomQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains("rawinputbuffer")) {
                rawInputEnabled = Boolean.parseBoolean(arr[1]);
            }
            if (s.contains("shadowsenabled")) {
                shadowsEnabled = Boolean.parseBoolean(arr[1]);
            }
        }
    }
    private void readGameUserSettings() throws FileNotFoundException {
        File file = new File(System.getProperty("user.home") + "\\AppData\\Local\\VALORANT\\Saved\\Config\\"+ lastKnownUserDirectory +"\\Windows\\GameUserSettings.ini");
        //System.out.println(file.getAbsolutePath());
        Scanner scanner = new Scanner(file);
        String s;
        while (scanner.hasNext()) {
            s = scanner.nextLine().toLowerCase();
            if (!(s.contains("=") && s.contains("quality"))) continue;
            String[] arr = s.split("=");
            if (s.contains("shadingquality")) {
                shadingQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains("foliagequality")) {
                foliageQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains("effectsquality")) {
                effectsQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains("texturequality")) {
                gameSettingTextureQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains("postprocessquality")) {
                postProcessQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains("shadowquality")) {
                shadowQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains("antialiasingquality")) {
                antiAliasingQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains("viewdistancequality")) {
                viewDistanceQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains("resolutionquality")) {
                resolutionQuality = Double.parseDouble(arr[1]);
            }
        }

    }
    public void listGameUserSettingsValues() {
        String riotUserSettingsValues =
                "\nResolution Quality: " + resolutionQuality +
                "\nView Distance Quality: " + viewDistanceQuality +
                "\nAnti Aliasing Quality: " + antiAliasingQuality +
                "\nShadow Quality: " + shadowQuality +
                "\nPost Process Quality: " + postProcessQuality +
                "\nGame Setting Texture Quality: " + gameSettingTextureQuality +
                "\nEffects Quality: " + effectsQuality +
                "\nFoliage Quality: " + foliageQuality +
                "\nShading Quality: " + shadingQuality;
        System.out.println(riotUserSettingsValues);
    }

    public void listRiotUserSettingsValues() {
        String riotUserSettingsValues =
                "\nMaterial Quality: " + materialQuality +
                "\nTexture Quality: " + riotSettingTextureQuality +
                "\nDetail Quality: " + detailQuality +
                "\nUI Quality: " + uiQuality +
                "\nBloom Quality: " + bloomQuality +
                "\nRaw Input Buffer Enabled: " + rawInputEnabled +
                "\nShadows Enabled: " + shadowsEnabled;
        System.out.println(riotUserSettingsValues);
    }

}
