package code.yuki;

import code.yuki.commands.builder.CommandBuilder;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        CommandBuilder builder = new CommandBuilder();
        String cmd = builder.addPrefix("netsh").intIp().netShSet().global().value("rsc").valueSetting("=disabled").completeCommand();
        System.out.println(cmd);
    }
}