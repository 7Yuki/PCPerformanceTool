package code.yuki;

import code.yuki.commands.builder.CommandBuilder;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        CommandBuilder builder = new CommandBuilder();
        String cmd = builder.addPrefix("netsh").netshInterface().customString(" 6to4 set state").valueSetting("disabled").completeCommand();
        System.out.println(cmd);
    }
}