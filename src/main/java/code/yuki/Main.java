package code.yuki;

import code.yuki.game.error.AddMissingSetting;
import code.yuki.game.overwatch.LookUpOverwatchSetting;
import code.yuki.game.overwatch.OverwatchSetting;
import code.yuki.game.valorant.LookUpValorantSettings;
import code.yuki.game.valorant.ValorantSetting;
import code.yuki.hardware.information.SystemSpecifications;
import code.yuki.init.WriteAppSettingsFile;

public class Main {

    public static void main(String[] args) throws Exception {
       /* System.out.println("Hello world!");
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

        InitalizeValorantSettings initalizeValorantSettings = new InitalizeValorantSettings();

        initalizeValorantSettings.listGameUserSettingsValues();
        initalizeValorantSettings.listRiotUserSettingsValues();*/



       /* System.out.println("CPU Brand: " + SystemSpecifications.getCPUBrand());
        System.out.println("CPU Architecture: " + SystemSpecifications.getCPUArchitechture());
        System.out.println("GPU: " + SystemSpecifications.getGPU());*/


       /* WriteAppSettingsFile appSettingsFile = new WriteAppSettingsFile();

        appSettingsFile.writeValorantSettings();
        appSettingsFile.writeDefaultSettingsFileLocations();*/

        LookUpValorantSettings lookUp = new LookUpValorantSettings();
        System.out.println("Network Smoothing: " + lookUp.lookUpSettingValueInt(ValorantSetting.NETWORK_SMOOTHING));
        //AddMissingSetting.addValorantSetting(ValorantSetting.NETWORK_SMOOTHING);
        //LookUpOverwatchSetting lookUp = new LookUpOverwatchSetting();

        //System.out.println(lookUp.prettyPrint(OverwatchSetting.ANISOTROPIC_FILTERING));
        System.out.println("Should've finished lol");


    }
}