package code.yuki.game.valorant;

import lombok.AccessLevel;
import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

public class ReadValorantSettings {

    @Getter(AccessLevel.PUBLIC)
    private int antiAliasingQuality;
    @Getter(AccessLevel.PUBLIC)
    private int shadowQuality;
    @Getter(AccessLevel.PUBLIC)
    private int shadingQuality;
    @Getter(AccessLevel.PUBLIC)
    private int foliageQuality;
    @Getter(AccessLevel.PUBLIC)
    private int effectsQuality;
    @Getter(AccessLevel.PUBLIC)
    private int postProcessQuality;
    @Getter(AccessLevel.PUBLIC)
    private int viewDistanceQuality;
    @Getter(AccessLevel.PUBLIC)
    private double resolutionQuality;
    @Getter(AccessLevel.PUBLIC)
    private int gameSettingTextureQuality;
    @Getter(AccessLevel.PUBLIC)
    private int materialQuality;
    @Getter(AccessLevel.PUBLIC)
    private int riotSettingTextureQuality;
    @Getter(AccessLevel.PUBLIC)
    private int detailQuality;
    @Getter(AccessLevel.PUBLIC)
    private int uiQuality;
    @Getter(AccessLevel.PUBLIC)
    private int bloomQuality;
    @Getter(AccessLevel.PUBLIC)
    private boolean shadowsEnabled;
    @Getter(AccessLevel.PUBLIC)
    private boolean rawInputEnabled;
    @Getter(AccessLevel.PUBLIC)
    private int anisotropicFiltering;

    private static final String lastKnownUser = getLastKnownUser();

    private static final String lastKnownUserDirectory = getLastKnownUserDirectory();


    public ReadValorantSettings() {
     /*   readGameUserSettings();
        readRiotUserSettings();*/
        bloomQuality = lookUpSettingValueInt(ValorantSetting.BLOOM_QUALITY);
        rawInputEnabled = lookUpSettingValueBoolean(ValorantSetting.RAW_INPUT_ENABLED);
        anisotropicFiltering = lookUpSettingValueInt(ValorantSetting.ANISOTROPIC_FILTERING);

    }

    public static String getLastKnownUserDirectory() {
        File dirPath = new File(System.getProperty("user.home") + "\\AppData\\Local\\VALORANT\\Saved\\Config");

        FilenameFilter filter = (dir, name) -> name.toLowerCase().contains(lastKnownUser);
        String[] dirList = dirPath.list(filter);
        if (dirList != null) {
            System.out.println("bruh " + dirList[0]);

            return dirList[0];
        }
        return null;
    }

    public static String getLastKnownUser() {
        final File lastKnownUserFile = new File(System.getProperty("user.home") + "\\AppData\\Local\\VALORANT\\Saved\\Config\\Windows\\RiotLocalMachine.ini");
        System.out.println("Riot Local Machine File Path: " + lastKnownUserFile.getAbsolutePath());
        System.out.println("Attempting to access " + lastKnownUserFile.getName() + "...");
        Scanner scanner;
        try {
            scanner = new Scanner(lastKnownUserFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    public static File getValorantSettingsFile(String fileName) {
        return new File(System.getProperty("user.home") + "\\AppData\\Local\\VALORANT\\Saved\\Config\\" + lastKnownUserDirectory + "\\Windows\\" + fileName);
    }

    public static String lookUpSetting(ValorantSetting setting) {
        return lookUpSetting(setting.getLookUpName(), setting.getSettingsFile().getFile().getName());
    }

    public static boolean lookUpSettingValueBoolean(ValorantSetting setting) {
        String settingString = lookUpSetting(setting);
        String[] arr = settingString.split("=");
        return Boolean.parseBoolean(arr[1]);
    }

    public static int lookUpSettingValueInt(ValorantSetting setting) {

        String settingString = lookUpSetting(setting);
        System.out.println(settingString);
        String[] arr = settingString.split("=");
        return Integer.parseInt(arr[1]);
    }

    private static String lookUpSetting(String settingName, String settingsFileName) {
        File file = getValorantSettingsFile(settingsFileName);
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

/*    private void readRiotUserSettings() {
        File file = getValorantSettingsFile("RiotUserSettings.ini");
        //new File(System.getProperty("user.home") + "\\AppData\\Local\\VALORANT\\Saved\\Config\\" + lastKnownUserDirectory + "\\Windows\\RiotUserSettings.ini");
        Scanner scanner;
        String s;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNext()) {
            s = scanner.nextLine().toLowerCase();
            if (!s.contains("=") || !(s.contains("rawinputbuffer") || s.contains("quality") || s.contains("shadow")))
                continue;
            String[] arr = s.split("=");
            if (s.contains(ValorantSetting.ANISOTROPIC_FILTERING.getLookUpName())) {
                anisotropicFiltering = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.ANTI_ALIASING_QUALITY.getLookUpName())) {
                antiAliasingQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.MATERIAL_QUALITY.getLookUpName())) {
                materialQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.RIOT_SETTING_TEXTURE_QUALITY.getLookUpName())) {
                riotSettingTextureQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.DETAIL_QUALITY.getLookUpName())) {
                detailQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.UI_QUALITY.getLookUpName())) {
                uiQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.BLOOM_QUALITY.getLookUpName())) {
                bloomQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.RAW_INPUT_ENABLED.getLookUpName())) {
                rawInputEnabled = Boolean.parseBoolean(arr[1]);
            }
            if (s.contains(ValorantSetting.SHADOWS_ENABLED.getLookUpName())) {
                shadowsEnabled = Boolean.parseBoolean(arr[1]);
            }
        }
    }*/

/*    private void readGameUserSettings() {
        File file = getValorantSettingsFile("GameUserSettings.ini");
        System.out.println(file);
        //new File(System.getProperty("user.home") + "\\AppData\\Local\\VALORANT\\Saved\\Config\\" + lastKnownUserDirectory + "\\Windows\\GameUserSettings.ini");
        //System.out.println(file.getAbsolutePath());
        Scanner scanner;
        String s;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNext()) {
            s = scanner.nextLine().toLowerCase();
            if (!(s.contains("=") && s.contains("quality"))) continue;
            String[] arr = s.split("=");
            if (s.contains(ValorantSetting.SHADING_QUALITY.getLookUpName())) {
                shadingQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.FOLIAGE_QUALITY.getLookUpName())) {
                foliageQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.EFFECTS_QUALITY.getLookUpName())) {
                effectsQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.GAME_SETTING_TEXTURE_QUALITY.getLookUpName())) {
                gameSettingTextureQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.POST_PROCESS_QUALITY.getLookUpName())) {
                postProcessQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.SHADOW_QUALITY.getLookUpName())) {
                shadowQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.ANTI_ALIASING_QUALITY.getLookUpName())) {
                antiAliasingQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.VIEW_DISTANCE_QUALITY.getLookUpName())) {
                viewDistanceQuality = Integer.parseInt(arr[1]);
            }
            if (s.contains(ValorantSetting.RESOLUTION_QUALITY.getLookUpName())) {
                resolutionQuality = Double.parseDouble(arr[1]);
            }
        }

    }*/

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
                        "\nShadows Enabled: " + shadowsEnabled +
                        "\nAnisotropic Filtering: " + anisotropicFiltering;
        System.out.println(riotUserSettingsValues);
    }

}
