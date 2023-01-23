package code.yuki.game.valorant;

import code.yuki.game.valorant.constants.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

public class ValorantFileInfo {


    private static String lastKnownUser;
    private static String lastKnownUserDirectory;
    private static final String baseConfigPath = Constants.USER_HOME + Constants.VALORANT_CONFIG_PATH;

    public static File getValorantSettingsFile(String fileName) {
        lastKnownUserDirectory = getLastKnownUserDirectory();
        if (lastKnownUserDirectory == null) return null;
        return new File(baseConfigPath + lastKnownUserDirectory + "\\Windows\\" + fileName);
    }


    public static String getLastKnownUserDirectory() {
        lastKnownUser = getLastKnownUser();
        if (lastKnownUser == null) return null;
        File dirPath = new File(baseConfigPath);
        FilenameFilter filter = (dir, name) -> name.toLowerCase().startsWith(lastKnownUser) && !name.endsWith("-ap");
        String[] dirList = dirPath.list(filter);
        if (dirList != null) {
            return dirList[0];
        }
        return null;
    }

    public static String getLastKnownUser() {
        if (lastKnownUser != null) return lastKnownUser;
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
                //System.out.println("Last Known User raw output: " + s);
                //System.out.println("Split output: " + arr[0] + " and " + arr[1]);
                if (arr[1] != null) {
                    lastKnownUser = arr[1];
                    System.out.println("Last Known User: " + lastKnownUser);
                    return lastKnownUser;
                }
            }
        }
        return null;
    }
}
