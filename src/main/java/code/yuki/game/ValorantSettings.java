package code.yuki.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

public class ValorantSettings {
    public int antiAliasingQuality;
    public int shadowQuality;
    public int shadingQuality;
    public int foliageQuality;
    public int effectsQuality;
    public int postProcessQuality;
    public int viewDistanceQuality;
    public double resolutionQuality;
    public int textureQuality;
    public int materialQuality;
    public int detailQuality;
    public boolean shadowsEnabled;
    public boolean rawInputEnabled;
    public String lastKnownUser = getLastKnownUser();
    public String lastKnownUserDirectory = getLastKnownUserDirectory();

    public ValorantSettings() throws FileNotFoundException {
    }

    public String getLastKnownUserDirectory() throws FileNotFoundException {
        File dirPath = new File(System.getProperty("user.home") + "\\AppData\\Local\\VALORANT\\Saved\\Config");
        FilenameFilter filter = (dir, name) -> name.toLowerCase().contains(lastKnownUser);
        String[] dirList = dirPath.list(filter);
        System.out.println("here: " + dirList);
        if (dirList != null) {
            System.out.println("bruh " + dirList[0]);

            return dirList[0];
        }
        return null;
    }

    public String getLastKnownUser() throws FileNotFoundException {
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
    public void readSettings() throws FileNotFoundException {
        File file = new File(System.getProperty("user.home") + "\\AppData\\Local\\VALORANT\\Saved\\Config\\"+ lastKnownUserDirectory +"\\Windows\\GameUserSettings.ini");
        System.out.println(file.getAbsolutePath());
        Scanner scanner = new Scanner(file);
        String s;
        while (scanner.hasNext()) {
            s = scanner.nextLine().toLowerCase();
            if (s.contains("shadingquality")) {
                String[] arr = s.split("=");
                System.out.println("Shading Quality raw output: " + s);
                System.out.println("Split output: " + arr[0] + " and " + arr[1]);
                shadingQuality = Integer.parseInt(arr[1]);
                System.out.println("Shading Quality refined output: " + shadingQuality);
            }
            if (s.contains("foliagequality")) {
                String[] arr = s.split("=");
                System.out.println("Foliage Quality raw output: " + s);
                System.out.println("Split output: " + arr[0] + " and " + arr[1]);
                foliageQuality = Integer.parseInt(arr[1]);
                System.out.println("Foliage Quality refined output: " + foliageQuality);
            }
            if (s.contains("effectsquality")) {
                String[] arr = s.split("=");
                System.out.println("Effects Quality raw output: " + s);
                System.out.println("Split output: " + arr[0] + " and " + arr[1]);
                effectsQuality = Integer.parseInt(arr[1]);
                System.out.println("Effects Quality refined output: " + effectsQuality);
            }
            if (s.contains("texturequality")) {
                String[] arr = s.split("=");
                System.out.println("Texture Quality raw output: " + s);
                System.out.println("Split output: " + arr[0] + " and " + arr[1]);
                textureQuality = Integer.parseInt(arr[1]);
                System.out.println("Texture Quality refined output: " + textureQuality);
            }
            if (s.contains("postprocessquality")) {
                String[] arr = s.split("=");
                System.out.println("Post Process Quality raw output: " + s);
                System.out.println("Split output: " + arr[0] + " and " + arr[1]);
                postProcessQuality = Integer.parseInt(arr[1]);
                System.out.println("Post Process Quality refined output: " + postProcessQuality);
            }
            if (s.contains("shadowquality")) {
                String[] arr = s.split("=");
                System.out.println("Post Process Quality raw output: " + s);
                System.out.println("Split output: " + arr[0] + " and " + arr[1]);
                shadowQuality = Integer.parseInt(arr[1]);
                System.out.println("Post Process Quality refined output: " + shadowQuality);
            }
            if (s.contains("antialiasingquality")) {
                String[] arr = s.split("=");
                System.out.println("Anti Alias Quality raw output: " + s);
                System.out.println("Split output: " + arr[0] + " and " + arr[1]);
                antiAliasingQuality = Integer.parseInt(arr[1]);
                System.out.println("Anti Alias Quality refined output: " + antiAliasingQuality);
            }
            if (s.contains("viewdistancequality")) {
                String[] arr = s.split("=");
                System.out.println("View Distance Quality raw output: " + s);
                System.out.println("Split output: " + arr[0] + " and " + arr[1]);
                viewDistanceQuality = Integer.parseInt(arr[1]);
                System.out.println("View Distance Quality refined output: " + viewDistanceQuality);
            }
            if (s.contains("resolutionquality")) {
                String[] arr = s.split("=");
                System.out.println("Resolution Quality raw output: " + s);
                System.out.println("Split output: " + arr[0] + " and " + arr[1]);
                resolutionQuality = Double.parseDouble(arr[1]);
                System.out.println("Resolution Quality refined output: " + resolutionQuality);
            }
        }
        System.out.println("\n");
        System.out.println("Resolution Quality output: " + resolutionQuality);
        System.out.println("View Distance Quality output: " + viewDistanceQuality);
        System.out.println("Anti Alias Quality output: " + antiAliasingQuality);
        System.out.println("Post Process Quality output: " + shadowQuality);
        System.out.println("Post Process Quality output: " + postProcessQuality);
        System.out.println("Texture Quality output: " + textureQuality);
        System.out.println("Effects Quality output: " + effectsQuality);
        System.out.println("Shading Quality output: " + shadingQuality);
        System.out.println("Foliage Quality output: " + foliageQuality);
    }

}
