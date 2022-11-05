package code.yuki;

import code.yuki.commands.builder.CMDCommandBuilder;
import code.yuki.commands.builder.util.CommandBuilderUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        CMDCommandBuilder builder = new CMDCommandBuilder();
        String cmd = builder.addPrefix("netsh").netshInterface().customString(" 6to4 set state ").valueSetting("disabled").builderToString(builder);
        System.out.println(cmd);
    }
}