package code.yuki.commands.builder;

import code.yuki.commands.builder.util.CommandBuilderUtil;

public class NetAdapterCommandBuilder extends CommandBuilderUtil {
    public NetAdapterCommandBuilder() {
        commandParts.add("Set-NetAdapterAdvancedProperty ");
    }

    public NetAdapterCommandBuilder netAdapterName(String netAdapterName) {
        commandParts.add(netAdapterName);
        return this;
    }

    public NetAdapterCommandBuilder value(String value) {
        commandParts.add(value);
        return this;
    }

    public NetAdapterCommandBuilder valueSetting(String setting) {
        commandParts.add(spaceString + setting);
        return this;
    }



}
