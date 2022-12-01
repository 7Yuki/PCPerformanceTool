package code.yuki;

import code.yuki.commands.builder.CMDCommandBuilder;
import code.yuki.game.valorant.ApplyValorantSettings;
import code.yuki.game.valorant.GameSettingsFile;
import code.yuki.game.valorant.ReadValorantSettings;
import code.yuki.game.valorant.ValorantSetting;
import code.yuki.servicedisabler.ServiceDisabler;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");
        CMDCommandBuilder builder = new CMDCommandBuilder();
        String cmd = builder
                .addPrefix("netsh")
                .netshInterface()
                .customString(" 6to4 set state ")
                .valueSetting("disabled")
                .builderToString(builder);
        System.out.println(cmd);

        String name = "RemoteRegistry";
        ServiceDisabler disabler = new ServiceDisabler();

        System.out.println("State of service: " + name + ": " + disabler.stateOfService(name));



        GameSettingsFile.GAME_USER.setFile(ReadValorantSettings.getValorantSettingsFile("GameUserSettings.ini"));
        GameSettingsFile.RIOT_USER.setFile(ReadValorantSettings.getValorantSettingsFile("RiotUserSettings.ini"));

        System.out.println("Riot User File: " + GameSettingsFile.RIOT_USER.getFile());
        System.out.println("Game User File: " + GameSettingsFile.GAME_USER.getFile());

        ReadValorantSettings valSettings = new ReadValorantSettings();
        System.out.println(valSettings.getBloomQuality());
        System.out.println(valSettings.getAnisotropicFiltering());
        System.out.println(valSettings.isRawInputEnabled());

        ApplyValorantSettings settingsApplier = new ApplyValorantSettings();

        settingsApplier.applyIntSetting(ValorantSetting.SHADING_QUALITY, 0);
    }
}