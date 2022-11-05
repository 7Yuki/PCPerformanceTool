package code.yuki.commands.builder;

import code.yuki.commands.builder.util.CommandBuilderUtil;

import java.util.ArrayList;
import java.util.List;

public class CMDCommandBuilder extends CommandBuilderUtil {

    public CMDCommandBuilder bcdeditSet() {

        commandParts.add(spaceString + "/set");
        return this;
    }

    public CMDCommandBuilder customString(String customValue) {
        commandParts.add(customValue);
        return this;
    }

    public CMDCommandBuilder addPrefix(String prefix) {
        commandParts.add(prefix);
        return this;
    }

    public CMDCommandBuilder intIp() {
        commandParts.add(spaceString + "int ip");
        return this;
    }

    public CMDCommandBuilder intTcp()
    {
        commandParts.add("int tcp ");
        return this;
    }

    public CMDCommandBuilder netShSet() {
        commandParts.add(spaceString + "set");
        return this;
    }

    public CMDCommandBuilder global() {
        commandParts.add(spaceString + "global");
        return this;
    }

    public CMDCommandBuilder netshInterface() {
        commandParts.add(" interface");

        return this;
    }

    public CMDCommandBuilder deleteValue() {
        commandParts.add(" /deletevalue");
        return this;
    }

    public CMDCommandBuilder value(String value) {
        commandParts.add(spaceString + value);
        return this;
    }

    public CMDCommandBuilder valueSetting(String setting) {
        commandParts.add(setting);
        return this;
    }


}
