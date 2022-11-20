package code.yuki;

import code.yuki.commands.builder.CMDCommandBuilder;
import code.yuki.game.ValorantSettings;
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

        ValorantSettings valSettings = new ValorantSettings();
        valSettings.readSettings();
        System.out.println("Last known user directory: " + valSettings.lastKnownUserDirectory);
        System.out.println("Last known user string: " + valSettings.lastKnownUser);
    }
}