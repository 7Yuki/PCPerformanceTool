package code.yuki.commands.builder.util;

import java.util.ArrayList;
import java.util.List;

public class CommandBuilderUtil {

    public static final List<String> commandParts = new ArrayList<>();
    public final String spaceString = " ";
    public String builderToString(CommandBuilderUtil builder) {
        String s = "";
        for (String commandPart : commandParts) {
            s += commandPart;
        }
        return s;
    }
}
