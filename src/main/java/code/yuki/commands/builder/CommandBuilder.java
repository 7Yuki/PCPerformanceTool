package code.yuki.commands.builder;

import java.util.ArrayList;
import java.util.List;

public class CommandBuilder {
    private final List<String> commands = new ArrayList<>();
    private final String spaceString = " ";

    public CommandBuilder bcdeditSet() {
        commands.add(spaceString + "/set");
        return this;
    }

    public CommandBuilder customString(String customValue) {
        commands.add(customValue);
        return this;
    }

    public CommandBuilder addPrefix(String prefix) {
        commands.add(prefix);
        return this;
    }

    public CommandBuilder intIp() {
        commands.add(spaceString + "int ip");
        return this;
    }

    public CommandBuilder intTcp()
    {
        commands.add("int tcp ");
        return this;
    }

    public CommandBuilder netShSet() {
        commands.add(spaceString + "set");
        return this;
    }

    public CommandBuilder global() {
        commands.add(spaceString + "global");
        return this;
    }

    public CommandBuilder netshInterface() {
        commands.add(" interface");

        return this;
    }

    public CommandBuilder deleteValue() {
        commands.add(" /deletevalue");
        return this;
    }

    public CommandBuilder value(String value) {
        commands.add(spaceString + value);
        return this;
    }

    public CommandBuilder valueSetting(String setting) {
        commands.add(setting);
        return this;
    }

    public String completeCommand() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < (long) commands.size(); i++)
        {
            str.append(commands.get(i));
        }
        return str.toString();
    }
}
