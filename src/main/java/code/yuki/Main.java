package code.yuki;

import code.yuki.hardware.information.SystemSpecifications;
import code.yuki.init.AppSettingsFile;
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



        System.out.println("CPU Brand: " + SystemSpecifications.getCPUBrand());
        System.out.println("CPU Architecture: " + SystemSpecifications.getCPUArchitechture());
        System.out.println("GPU: " + SystemSpecifications.getGPU());

        System.out.println("Test");

        WriteAppSettingsFile writeAppSettingsFile = new WriteAppSettingsFile();

        writeAppSettingsFile.writeValorantSettings();
        System.out.println("Should've finished lol");

    }
}