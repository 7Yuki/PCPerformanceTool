package code.yuki;

import code.yuki.commands.builder.CMDCommandBuilder;
import code.yuki.game.valorant.InitalizeValorantSettings;
import code.yuki.hardware.information.SystemSpecifications;
import code.yuki.servicedisabler.ServiceDisabler;

import oshi.SystemInfo;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HardwareAbstractionLayer;

public class Main {

    public static void main(String[] args) throws Exception {
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

        InitalizeValorantSettings initalizeValorantSettings = new InitalizeValorantSettings();

        initalizeValorantSettings.listGameUserSettingsValues();
        initalizeValorantSettings.listRiotUserSettingsValues();



        System.out.println("CPU Brand: " + SystemSpecifications.getCPUBrand());
        System.out.println("CPU Architecture: " + SystemSpecifications.getCPUArchitechture());
        System.out.println("GPU: " + SystemSpecifications.getGPU());



    }
}