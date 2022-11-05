package code.yuki.commands.builder;

import java.util.ArrayList;
import java.util.List;

public class CommandBuilder {
    private final List<String> commands = new ArrayList<>();

    public CommandBuilder BcdeditSet() {
        commands.add("/set");
        return this;
    }

    public CommandBuilder addPrefix(String prefix) {
        commands.add(prefix);
        return this;
    }

    public CommandBuilder intIP() {
        commands.add("int ip");
        return this;
    }

    public CommandBuilder IntTCP()
    {
        commands.add("int tcp ");
        return this;
    }

    public CommandBuilder NetshSet() {
        commands.add("set ");
        return this;
    }

    public CommandBuilder Global() {
        commands.add("global ");
        return this;
    }

    public CommandBuilder Interface() {
        commands.add("interface");

        return this;
    }

    public CommandBuilder DeleteValue() {
        commands.add("/deletevalue");
        return this;
    }

    public CommandBuilder Value(String value) {
        commands.add(value);
        return this;
    }

    public CommandBuilder ValueSetting(String setting) {
        commands.add(setting);
        return this;
    }

    public String CompleteCommand() {
        String str = "";

        for (int i = 0; i < (long) commands.size(); i++)
        {
            str += commands.get(i);
        }
        return str;
    }
}
